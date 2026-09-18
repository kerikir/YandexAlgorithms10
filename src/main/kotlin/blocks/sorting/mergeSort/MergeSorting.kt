package blocks.sorting.mergeSort

/*

Задача: Сортировка слиянием - реализовать сортировку слиянием

Сложность = O(N * logN)
Ограничения: 0 <= N <= 1_000_000
             -1_000_000_000 <= Ai <= 1_000_000_000

Время = 2s
Память = 195.18MB

 */

fun main() {
    val n = readln().trim().toInt()
    val array = readln().trim().split(Regex("\\s+")).filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()

    mergeSort1(array, 0, array.lastIndex)

    println(array.joinToString(" "))
}


fun mergeSort1(array: IntArray, left: Int, right: Int) {
    if (left >= right) return

    val middle = (right + left) / 2
    mergeSort1(array, left, middle)
    mergeSort1(array, middle + 1, right)

    val sortedArray = IntArray(right - left + 1)
    mergeArrays2(
        array, left, middle,
        array, middle + 1, right,
        sortedArray, 0
    )

    for (i in sortedArray.indices) {
        array[left + i] = sortedArray[i]
    }
}


fun mergeArrays2(
    array1: IntArray, start1: Int, end1: Int,
    array2: IntArray, start2: Int, end2: Int,
    arrayResult: IntArray, startIndex: Int
) {
    var size = (end1 - start1 + 1) + (end2 - start2 + 1)
    var left1 = start1
    var left2 = start2

    repeat(size) { index ->
        if (left1 <= end1 && (left2 > end2 || array1[left1] <= array2[left2])) {
            arrayResult[startIndex + index] = array1[left1]
            left1++
        } else {
            arrayResult[startIndex + index] = array2[left2]
            left2++
        }
    }
}