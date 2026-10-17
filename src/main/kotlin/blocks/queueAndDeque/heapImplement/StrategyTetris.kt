package blocks.queueAndDeque.heapImplement

import java.util.PriorityQueue

fun main() {
    val (n, w) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val blocks = mutableListOf<Triple<Int, Int, Int>>()
    repeat(n) {
        val (x, width) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
        blocks.add(Triple(it + 1, x, x + width))
    }
    blocks.sortBy { it.second }

    val result = mutableListOf<Int>()

    val heap = PriorityQueue<Int>()
    heap.add(blocks.first().third)
    repeat(n - 1) {

        if (heap.peek() <= blocks[it + 1].second) {
            heap.poll()
            heap.add(blocks[it + 1].third)

        } else {
            heap.add(blocks[it + 1].third)
        }
    }

    println(heap.size)
}