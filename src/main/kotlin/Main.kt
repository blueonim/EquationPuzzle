/**
 * This program ensures that for a given equation puzzle there is only one solution. Each puzzle has an initial value
 * and a solution value. Puzzles are composed of a number of [Shape]s that posses [Face]s. By manipulating the ordering
 * of the [Shape]s and which [Face] is showing, you can form equations.
 */
fun main() {
    printPuzzleCheck("Cube", CUBE_PUZZLE, CUBE_PUZZLE_INITIAL, CUBE_PUZZLE_ANSWER, true)
    printPuzzleCheck("Cylinder", CYLINDER_PUZZLE, CYLINDER_PUZZLE_INITIAL, CYLINDER_PUZZLE_ANSWER, true)
    printPuzzleCheck("Triangle", TRIANGLE_PUZZLE, TRIANGLE_PUZZLE_INITIAL, TRIANGLE_PUZZLE_ANSWER, true)
}

/**
 * Prints the results of the puzzle check.
 * @param name of the puzzle
 * @param puzzle the set of [Shape]s that make up the puzzle
 * @param initialValue the start value of the equation
 * @param answer the target value for the equation
 * @param printInfo whether to print details to the console
 */
fun printPuzzleCheck(name: String, puzzle: Set<Shape>, initialValue: Double, answer: Double, printInfo: Boolean) {
    println("Checking $name Puzzle:")
    if (ensureOneSolution(puzzle, initialValue, answer, printInfo)) {
        println("$name: Passed")
    } else {
        println("$name: Failed")
    }
    println()
}

/**
 * Performs the equation reading left to right.
 * @param initialValue the start value of the equation
 * @param faces an ordered list of operations to perform
 * @return the result of the equation
 */
fun performEquation(initialValue: Double, faces: List<Face>): Double {
    var resultValue = initialValue
    faces.forEach { resultValue = performOperation(resultValue, it) }
    return resultValue
}

/**
 * For a given puzzle, check every possible equation that can be made and ensure only one configuration produces the
 * expected answer.
 * @param puzzle the set of [Shape]s that make up the puzzle
 * @param initialValue the start value of the equation
 * @param answer the target value for the equation
 * @param printInfo whether to print details to the console
 * @return true if there is only one solution to the puzzle, false otherwise
 */
fun ensureOneSolution(puzzle: Set<Shape>, initialValue: Double, answer: Double, printInfo: Boolean): Boolean {
    var solutionCount = 0

    makeOrderings(setOf(), puzzle).forEach { order ->
        makeEquations(setOf(), order).forEach { equation ->
            if (performEquation(initialValue, equation) == answer) {
                if (printInfo) {
                    printEquation(initialValue, equation)
                } else if (solutionCount == 1) return false
                solutionCount ++
            }
        }
    }

    if (printInfo) println("SolutionCount: $solutionCount")
    return solutionCount == 1
}

/**
 * Prints a readable equation along with the evaluated result.
 * @param initialValue the start value of the equation
 * @param equation an ordered list of [Face]s that make up an equation
 */
fun printEquation(initialValue: Double, equation: List<Face>) {
    print("$initialValue ")
    equation.forEach { print("${it.operator.name} ${it.value} ") }
    println("= ${performEquation(initialValue, equation)}")
}

/**
 * Make all possible equations for a given ordering of [Shape]s. This is a recursive operation that builds up a set of
 * equations at each step.
 * @param equations the current set of equations
 * @param remainingShapes an ordered list of shapes that haven't been used in the equation yet
 * @return the set of all equations
 */
fun makeEquations(equations: Set<List<Face>>, remainingShapes: List<Shape>): Set<List<Face>> {
    if (remainingShapes.isEmpty()) return equations

    val resultEquations = mutableSetOf<List<Face>>()
    val newRemainingShapes = remainingShapes.toMutableList()
    val nextShape = newRemainingShapes.removeFirst()
    if (equations.isEmpty()) {
        nextShape.faces.forEach { resultEquations.addAll(makeEquations(setOf(listOf(it)), newRemainingShapes)) }
    } else {
        nextShape.faces.forEach { face ->
            val newEquations = mutableSetOf<List<Face>>()
            equations.forEach { newEquations.add(it.plus(face)) }
            resultEquations.addAll(makeEquations(newEquations, newRemainingShapes))
        }
    }
    return resultEquations
}

/**
 * Make all possible ordering of [Shape]s for a given puzzle. This is a recursive operation that builds up a set of
 * orderings at each step.
 * @param orderings the current set of [Shape] orderings
 * @param remainingShapes the set of [Shape]s that haven't been added to the orderings yet
 * @return the set of all [Shape] orderings
 */
fun makeOrderings(orderings: Set<List<Shape>>, remainingShapes: Set<Shape>): Set<List<Shape>> {
    if (remainingShapes.isEmpty()) return orderings

    val resultOrderings = mutableSetOf<List<Shape>>()
    if (orderings.isEmpty()) {
        remainingShapes.forEach { resultOrderings.addAll(makeOrderings(setOf(listOf(it)), remainingShapes.minus(it))) }
    } else {
        remainingShapes.forEach { shape ->
            val newOrderings = mutableSetOf<List<Shape>>()
            orderings.forEach { newOrderings.add(it.plus(shape)) }
            resultOrderings.addAll(makeOrderings(newOrderings, remainingShapes.minus(shape)))
        }
    }
    return resultOrderings
}
