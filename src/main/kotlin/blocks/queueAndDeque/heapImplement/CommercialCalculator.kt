package blocks.queueAndDeque.heapImplement

import java.util.PriorityQueue

fun main() {
    val n = readln().trim().toInt()
    val array = readln().trim().split(Regex("\\s+")).map { it.toInt() }.toIntArray()

    val heap = PriorityQueue<Int>()
    
}