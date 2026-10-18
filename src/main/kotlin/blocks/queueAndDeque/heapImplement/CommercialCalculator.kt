package blocks.queueAndDeque.heapImplement

import java.util.PriorityQueue

fun main() {
    val n = readln().trim().toInt()
    val array = readln().trim().split(Regex("\\s+")).map { it.toInt() }.toIntArray()

    val heap = PriorityQueue<Int>()
    array.forEach { heap.add(it) }

    var price = 0.0
    while (heap.size > 1) {

    }

    println(price)
}