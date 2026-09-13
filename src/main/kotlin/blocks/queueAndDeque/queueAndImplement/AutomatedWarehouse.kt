package blocks.queueAndDeque.queueAndImplement

fun main() {
    val n = readln().trim().toInt()
    val mainRoad = readln().trim().split(Regex("\\s+")).map { it.toInt() - 1 }

    val queueRoads = Array<ArrayDeque<Pair<Int, Int>>>(n) { ArrayDeque<Pair<Int, Int>>() }
    repeat(n) { index ->
        val (d, t) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
        queueRoads[d - 1].addLast(index to t)
    }

    val result = IntArray(n)
    for (time in 1..n) {
        
    }
}