import Operator.*

private val CUBE1 = Shape("cube1",
    setOf(
        Face(DIVIDE, 2),
        Face(DIVIDE, 3),
        Face(DIVIDE, 4),
        Face(ADD, 6)
    )
)
private val CUBE2 = Shape("cube2",
        setOf(
        Face(ADD, 0),
        Face(ADD, 5),
        Face(MULTIPLY, 1),
        Face(ADD, 7)
    )
)
private val CUBE3 = Shape("cube3",
    setOf(
        Face(ADD, 2),
        Face(SUBTRACT, 1),
        Face(SUBTRACT, 8),
        Face(ADD, 0)
    )
)
private val CUBE4 = Shape("cube4",
    setOf(
        Face(MULTIPLY, 5),
        Face(MULTIPLY, 4),
        Face(MULTIPLY, 1),
        Face(ADD, 3)
    )
)
val CUBE_PUZZLE = setOf(CUBE1, CUBE2, CUBE3, CUBE4)
const val CUBE_PUZZLE_INITIAL = 0.0
const val CUBE_PUZZLE_ANSWER = 10.0

private val CYLINDER1 = Shape("cylinder1",
    setOf(
        Face(ADD, 2),
        Face(MULTIPLY, 4)
    )
)
private val CYLINDER2 = Shape("cylinder2",
    setOf(
        Face(ADD, 12),
        Face(DIVIDE, 2)
    )
)
private val CYLINDER3 = Shape("cylinder3",
    setOf(
        Face(ADD, 5),
        Face(DIVIDE, 4)
    )
)
private val CYLINDER4 = Shape("cylinder4",
    setOf(
        Face(MULTIPLY, 7),
        Face(SUBTRACT, 3)
    )
)
val CYLINDER_PUZZLE = setOf(CYLINDER1, CYLINDER2, CYLINDER3, CYLINDER4)
const val CYLINDER_PUZZLE_INITIAL = 1.0
const val CYLINDER_PUZZLE_ANSWER = 13.0

private val TRIANGLE1 = Shape("triangle1",
    setOf(
        Face(ADD, 2),
        Face(DIVIDE, 4)
    )
)
private val TRIANGLE2 = Shape("triangle2",
    setOf(
        Face(MULTIPLY, 5),
        Face(ADD, 8),
        Face(SUBTRACT, 7)
    )
)
private val TRIANGLE3 = Shape("triangle3",
    setOf(
        Face(MULTIPLY, 6),
        Face(SUBTRACT, 1)
    )
)
private val TRIANGLE4 = Shape("triangle4",
    setOf(
        Face(SUBTRACT, 11),
        Face(DIVIDE, 2),
        Face(MULTIPLY, 4)
    )
)
val TRIANGLE_PUZZLE = setOf(TRIANGLE1, TRIANGLE2, TRIANGLE3, TRIANGLE4)
const val TRIANGLE_PUZZLE_INITIAL = 1.0
const val TRIANGLE_PUZZLE_ANSWER = 7.0
