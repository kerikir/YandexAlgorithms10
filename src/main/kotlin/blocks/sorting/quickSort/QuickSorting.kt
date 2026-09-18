package blocks.sorting.quickSort

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.File
import java.io.FileReader
import java.io.FileWriter

/*

Задача: Быстрая сортировка - отсортировать массив чисел

Сложность = O(N * logN)
Ограничения: 0 <= N <= 1_000_000
             -1_000_000_000 <= Ai <= 1_000_000_000

Время = 1s
Память = 134.63MB

 */


fun main() {
    val reader = BufferedReader(FileReader(File("input.txt")))
    val writer = BufferedWriter(FileWriter(File("output.txt")))

    val n = reader.readLine().trim().toInt()
    val array = reader.readLine().trim().split(' ').filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()

    quickSort(array, 0, array.lastIndex)

    for (i in array.indices) {
        writer.write("${array[i]} ")
    }

    reader.close()
    writer.close()
}


fun quickSort(array: IntArray, left: Int, right: Int) {
    if (left >= right) return

    if (right - left < 20) {
        bubbleSort(array, left, right)
        return
    }

    var l = left
    var r = right
    while (l < r) {
        val middle = l + (r - l) / 2
        val values = intArrayOf(array[l], array[middle], array[r])
        values.sort()
        val value = values[1]

        val (eq, gr) = partition(array, l, r, value)

        if (eq < (l + r) / 2) {
            quickSort(array, l, eq - 1)
            l = gr
        } else {
            quickSort(array, gr, r)
            r = eq - 1
        }
    }
}


fun partition(array: IntArray, left: Int, right: Int, x: Int): Pair<Int, Int> {
    var equals = left
    var greatest = left
    var now = left

    while (now <= right) {
        if (array[now] < x) {
            val temp = array[now]
            array[now] = array[greatest]
            array[greatest] = array[equals]
            array[equals] = temp
            equals++
            greatest++

        } else if (array[now] == x) {
            val temp = array[now]
            array[now] = array[greatest]
            array[greatest] = temp
            greatest++
        }

        now++
    }

    return equals to greatest
}


fun bubbleSort(array: IntArray, left: Int, right: Int) {

    repeat(right - left) {
        for (index in left..<right - it) {

            if (array[index] > array[index + 1]) {
                val temp = array[index + 1]
                array[index + 1] = array[index]
                array[index] = temp
            }
        }
    }
}