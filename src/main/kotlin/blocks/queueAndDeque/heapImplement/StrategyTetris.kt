package blocks.queueAndDeque.heapImplement

fun main() {
    val (n, w) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val blocks = mutableListOf<Triple<Int, Int, Int>>()
    repeat(n) {
        val (x, width) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
        blocks.add(Triple(it + 1, x, x + width))
    }
    blocks.sortBy { it.second }
}