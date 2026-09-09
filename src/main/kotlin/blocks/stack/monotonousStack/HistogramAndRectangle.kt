package blocks.stack.monotonousStack

import java.util.Stack
import kotlin.math.max

/*

Задача: Гистограмма и прямоугольник - определить площадь самого большого прямоугольника в гистограмме

Сложность = O(N)
Ограничения: 1 <= N <= 1_000_000
             0 <= Hi <= 1_000_000_000

Время = 617ms
Память = 41.91MB

 */


fun main() {
    val heights = readln().trim()
        .split(Regex("\\s+"))
        .map { it.toInt() }
        .drop(1)

    val stack = Stack<Pair<Int, Int>>()
    val recordsStraight = IntArray(heights.size)
    for (i in heights.indices) {
        while (stack.isNotEmpty() && heights[i] < stack.peek().second) {
            val (index, height) = stack.pop()
            recordsStraight[index] = i
        }
        stack.push(i to heights[i])
    }
    while (stack.isNotEmpty()) {
        val (index, height) = stack.pop()
        recordsStraight[index] = heights.size
    }

    val recordsReverse = IntArray(heights.size)
    for (i in heights.indices.reversed()) {

        while (stack.isNotEmpty() && heights[i] < stack.peek().second) {
            val (index, height) = stack.pop()
            recordsReverse[index] = i
        }
        stack.push(i to heights[i])
    }
    while (stack.isNotEmpty()) {
        val (index, height) = stack.pop()
        recordsReverse[index] = -1
    }

    var maxArea = 0L
    for ((index, height) in heights.withIndex()) {
        maxArea = max(maxArea, height * (recordsStraight[index] - recordsReverse[index] - 1).toLong())
    }
    println(maxArea)
}