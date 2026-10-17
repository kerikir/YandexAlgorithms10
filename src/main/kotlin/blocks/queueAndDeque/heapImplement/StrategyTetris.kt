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

    val rows = mutableMapOf<Int, ArrayList<Int>>()
    val heap = PriorityQueue<Pair<Int, Int>>(
        compareBy { it.second }
    )

    heap.add(0 to blocks.first().third)
    rows[0] = arrayListOf(blocks.first().first)
    repeat(n - 1) {

        if (heap.peek().second <= blocks[it + 1].second) {
            val (row, _) = heap.poll()
            heap.add(row to blocks[it + 1].third)
            rows[row]?.add(blocks[it + 1].first)

        } else {
            heap.add(heap.size to blocks[it + 1].third)
            rows[heap.size] = arrayListOf(blocks[it + 1].first)
        }
    }

    println(heap.size)
}