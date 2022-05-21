/**
 * Represents an object with multiple [Face]s. [Shape]s and be ordered and manipulated to form equations.
 * @param name of the shape
 * @param faces the [Face]s of the shape which hold operations that make up an equation
 */
data class Shape(val name: String, val faces: Set<Face>)
