package blocks.sorting.mergeSort

/*

Задача: Сортировка пузырьком: количество обменов - определить количество перестановок
                                                   при сортировке массива пузырьком

Сложность = O(N * logN)
Ограничения: 0 <= N <= 100_000
             -1_000_000_000 <= Ai <= 1_000_000_000

Время = 2s
Память = 195.18MB

 */

fun main() {
    val n = readln().trim().toInt()
    val array = readln().trim().split(Regex("\\s+")).filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()

    val result = mergeSort(array, 0, array.lastIndex)

    println(result)
}


fun mergeSort(array: IntArray, left: Int, right: Int): Int {
    if (left >= right) return 0

    val middle = (right + left) / 2
    val a = mergeSort(array, left, middle)
    val b = mergeSort(array, middle + 1, right)

    val sortedArray = IntArray(right - left + 1)
    val c = mergeArrays(
        array, left, middle,
        array, middle + 1, right,
        sortedArray, 0
    )

    for (i in sortedArray.indices) {
        array[left + i] = sortedArray[i]
    }

    return a + b + c
}


fun mergeArrays(
    array1: IntArray, start1: Int, end1: Int,
    array2: IntArray, start2: Int, end2: Int,
    arrayResult: IntArray, startIndex: Int
): Int {
    var size = (end1 - start1 + 1) + (end2 - start2 + 1)
    var left1 = start1
    var left2 = start2

    var counter = 0

    repeat(size) { index ->
        if (left1 <= end1 && (left2 > end2 || array1[left1] <= array2[left2])) {
            arrayResult[startIndex + index] = array1[left1]
            left1++
        } else {
            arrayResult[startIndex + index] = array2[left2]
            left2++
            counter += end1 - left1 + 1
        }
    }

    return counter
}