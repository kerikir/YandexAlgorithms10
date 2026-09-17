package blocks.sorting.ordinalStatistics

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.sqrt

/*

Задача: Столица - определить координаты столицы для быстрой дороги в другие города

Сложность = O(N * logN * logN)
Ограничения: 1 <= N <= 100
             -1_000 <= Ai <= 1_000

Время = 171ms
Память = 24.54MB

 */

fun main() {
    val n = readln().trim().toInt()
    val coords = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (x, y) = readln().trim().split(' ').map { it.toInt() }
        coords.add(x to y)
    }

    val arrX = coords.map { it.first }.toIntArray()
    val arrY = coords.map { it.second }.toIntArray()

    val middleX = if (n % 2 == 0) {
        val index1 = n / 2 - 1
        val index2 = n / 2
        val middle1 = searchOrdinalStatistics1(arrX, index1)
        val middle2 = searchOrdinalStatistics1(arrX, index2)
        (middle1 + middle2) / 2
    } else {

        val index = n / 2
        val middle = searchOrdinalStatistics1(arrX, index)
        middle
    }
    val middleY = if (n % 2 == 0) {
        val index1 = n / 2 - 1
        val index2 = n / 2
        val middle1 = searchOrdinalStatistics1(arrY, index1)
        val middle2 = searchOrdinalStatistics1(arrY, index2)
        (middle1 + middle2) / 2
    } else {

        val index = n / 2
        val middle = searchOrdinalStatistics1(arrY, index)
        middle
    }

    val cities = coords.toSet()

    val d = ceil(sqrt(n.toDouble())).toInt() + 1
    var min = Int.MAX_VALUE
    var capital = coords.first()
    for (i in -d..d) {
        for (j in -d..d) {
            val x = middleX + i
            val y = middleY + j

            if ((x to y) !in cities) {
                var s = 0
                for ((cityX, cityY) in coords) {
                    s += abs(x - cityX) + abs(y - cityY)
                }

                if (s < min) {
                    min = s
                    capital = x to y
                }
            }
        }
    }

    println("${capital.first} ${capital.second}")
}


fun searchOrdinalStatistics1(array: IntArray, k: Int): Int {
    var left = 0
    var right = array.lastIndex

    while (left < right) {
        val middle = left + (right - left) / 2
        val arrayX = intArrayOf(array[left], array[middle], array[right])
        arrayX.sort()
        val x = arrayX[1]

        val (eq, gr) = partition1(array, left, right, x)

        if (k < eq) {
            right = eq - 1
        } else if (k >= gr) {
            left = gr
        } else {
            return array[k]
        }
    }

    return array[k]
}


fun partition1(array: IntArray, left: Int, right: Int, x: Int): Pair<Int, Int> {
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