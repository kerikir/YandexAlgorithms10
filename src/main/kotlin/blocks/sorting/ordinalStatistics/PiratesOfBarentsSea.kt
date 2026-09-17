package blocks.sorting.ordinalStatistics

import kotlin.math.abs

/*

Задача: Пираты Баренцева моря - определить минимальное количество ходов для построения кораблей в один столбец

Сложность = O(N * logN)
Ограничения: 1 <= N <= 100
             1 <= Ai <= 100

Время = 171ms
Память = 24.63MB

 */

fun main() {
    val n = readln().trim().toInt()
    val coords = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (row, column) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
        coords.add(row to column)
    }

    val arrX = coords.map { it.second }.toIntArray()

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

    val sortedShips = coords.sortedWith(
        compareBy<Pair<Int, Int>> { it.first }
            .thenBy { it.second }
    )

    val arrayDistances = IntArray(n)
    for (i in arrayDistances.indices) {
        arrayDistances[i] = abs(sortedShips[i].second - middleX) + abs(sortedShips[i].first - (i + 1))
    }

    println(arrayDistances.sum())
}


fun searchOrdinalStatistics(array: IntArray, k: Int): Int {
    var left = 0
    var right = array.lastIndex

    while (left < right) {
        val middle = left + (right - left) / 2
        val arrayX = intArrayOf(array[left], array[middle], array[right])
        arrayX.sort()
        val x = arrayX[1]

        val (eq, gr) = partition(array, left, right, x)

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