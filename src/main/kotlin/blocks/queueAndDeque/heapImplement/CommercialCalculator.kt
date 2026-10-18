package blocks.queueAndDeque.heapImplement

import java.util.Locale
import java.util.PriorityQueue

/*

Задача: Коммерческий калькулятор - определение стоимости вычисления суммы чисел

Сложность = O(N * logN)
Ограничения: 2 <= N <= 100_000

Время = 593ms
Память = 41.18MB

 */

fun main() {
    val n = readln().trim().toInt()
    val array = readln().trim().split(Regex("\\s+")).map { it.toInt() }.toIntArray()

    val heap = PriorityQueue<Int>()
    array.forEach { heap.add(it) }

    var price = 0.0
    while (heap.size > 1) {
        val a = heap.poll()
        val b = heap.poll()
        val c = a + b

        price += c * 0.05
        heap.add(c)
    }

    println(String.format(Locale.US, "%.2f", price))
}