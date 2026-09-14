package blocks.queueAndDeque.dequeAndMinimumInWindow

import java.util.ArrayDeque

fun main() {
    val n = readln().trim().toInt()
    val power = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val q = readln().trim().toInt()
    val watch = mutableListOf<Long>()
    var maxGame = 0L
    repeat(q) {
        val k = readln().trim().toLong()
        watch.add(k)
        if (maxGame < k) maxGame = k
    }

    val watchingGames = watch.toSet()
    val deque = ArrayDeque<Int>(power)

    val result = mutableMapOf<Long, String>()
    for (index in 1..maxGame) {
        val a = deque.pollFirst()
        val b = deque.pollFirst()

        if (index in watchingGames) {
            result[index] = "$a $b"
        }

        if (a > b) {
            deque.offerFirst(a)
            deque.offerLast(b)
        } else {
            deque.offerFirst(b)
            deque.offerLast(a)
        }
    }

    for (index in watch) {
        println(result[index])
    }
}