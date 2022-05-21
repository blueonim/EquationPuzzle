import Operator.*

/**
 * Represents a side of a [Shape].
 * @param operator the operation to perform on the incoming value and the face value
 * @param value the right side of the equation that is formed with the incoming value and the operation
 */
data class Face(val operator: Operator, val value: Int)

/**
 * Evaluates an equation given an incoming value, the [Face] operation, and the [Face] value.
 * @param value the incoming value is the left side of the equation
 * @param face represents the operation and right side of the equation
 * @return the result of the evaluated equation
 */
fun performOperation(value: Double, face: Face): Double {
    return when(face.operator) {
        ADD -> value + face.value
        SUBTRACT -> value - face.value
        MULTIPLY -> value * face.value
        DIVIDE -> value / face.value
    }
}
