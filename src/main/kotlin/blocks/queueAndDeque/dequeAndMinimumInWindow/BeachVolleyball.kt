package blocks.queueAndDeque.dequeAndMinimumInWindow

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter

fun main() {
    val reader = BufferedReader(FileReader(File("input.txt")))
    val writer = BufferedWriter(FileWriter(File("output.txt")))

    val n = reader.readLine().trim().toInt()
    val power = reader.readLine().trim().split(' ').map { it.toInt() }
    val q = reader.readLine().trim().toInt()
    val watch = ArrayList<Long>(q)
    var maxGame = 0L
    repeat(q) {
        val k = reader.readLine().trim().toLong()
        watch.add(k)
        if (maxGame < k) maxGame = k
    }

    val watchingGames = watch.toSet()
    val deque = ArrayDeque<Int>(power)

    val result = mutableMapOf<Long, String>()
    for (index in 1..maxGame) {
        val a = deque.removeFirst()
        val b = deque.removeFirst()

        if (index in watchingGames) {
            result[index] = "$a $b"
        }

        if (a > b) {
            deque.addFirst(a)
            deque.addLast(b)
        } else {
            deque.addFirst(b)
            deque.addLast(a)
        }
    }

    for (index in watch) {
        writer.write(result[index].toString())
        writer.newLine()
    }
    reader.close()
    writer.close()
}