package blocks.sorting.ordinalStatistics

import kotlin.math.abs
import kotlin.math.ceil
import kotlin.math.sqrt


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
        val middle1 = searchOrdinalStatistics(arrX, index1)
        val middle2 = searchOrdinalStatistics(arrX, index2)
        (middle1 + middle2) / 2
    } else {

        val index = n / 2
        val middle = searchOrdinalStatistics(arrX, index)
        middle
    }
    val middleY = if (n % 2 == 0) {
        val index1 = n / 2 - 1
        val index2 = n / 2
        val middle1 = searchOrdinalStatistics(arrY, index1)
        val middle2 = searchOrdinalStatistics(arrY, index2)
        (middle1 + middle2) / 2
    } else {

        val index = n / 2
        val middle = searchOrdinalStatistics(arrY, index)
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


fun searchOrdinalStatistics(array: IntArray, k: Int): Int {
    var left = 0
    var right = array.lastIndex

    while (left < right) {
        val middle = left + (right - left) / 2
        val arrayX = intArrayOf(array[left], array[middle], array[right])
        arrayX.sort()
        val x = arrayX[1]

        val p = partition(array, left, right) {
            it < x
        }

        if (p <= k) {
            right = p
        } else {
            left = p + 1
        }
    }

    return array[k]
}


fun partition(array: IntArray, left: Int, right: Int, predicate: (Int) -> Boolean): Int {
    var l = left
    var r = right

    while (l <= r) {
        while (l <= right && predicate(array[l])) {
            l++
        }
        while (r >= left && !predicate(array[r])) {
            r--
        }

        if (r > l) {
            val temp = array[l]
            array[l] = array[r]
            array[r] = temp
        }
    }

    return l - 1
}