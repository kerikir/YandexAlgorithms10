package blocks.queueAndDeque.dequeAndMinimumInWindow

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter
import java.util.ArrayDeque

/*

Задача: Минимум на отрезке - определить минимум для каждого положения окна

Сложность = O(N)
Ограничения: 1 <= N <= 150_000
             1 <= K <= 10_000

Время = 653ms
Память = 47.11MB

 */

fun main() {
    val reader = BufferedReader(FileReader(File("input.txt")))
    val writer = BufferedWriter(FileWriter(File("output.txt")))

    val (n, k) = reader.readLine().trim().split(' ').map { it.toInt() }
    val array = reader.readLine().trim().split(' ').map { it.toInt() }

    val deque = ArrayDeque<Int>()
    for (i in 0..<k) {
        while (deque.isNotEmpty() && deque.peekLast() > array[i]) {
            deque.pollLast()
        }
        deque.offerLast(array[i])
    }

    val result = ArrayList<Int>(n - k + 1)
    result.add(deque.peekFirst())
    for (i in k..<n) {
        if (deque.isNotEmpty() && deque.peekFirst() == array[i - k]) {
            deque.pollFirst()
        }

        while (deque.isNotEmpty() && deque.peekLast() > array[i]) {
            deque.pollLast()
        }
        deque.offerLast(array[i])

        result.add(deque.peekFirst())
    }

    for (value in result) {
        writer.write(value.toString())
        writer.newLine()
    }
    reader.close()
    writer.close()
}