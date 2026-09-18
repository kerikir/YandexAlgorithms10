package blocks.sorting.mergeSort

/*

Задача: Слияние - реализовать слияние двух отсортированных массивов в один

Сложность = O(N + M)
Ограничения: 0 <= N <= 1_000_000
             0 <= M <= 1_000_000
             -1_000_000_000 <= Ai <= 1_000_000_000

Время = 3s
Память = 224.89MB

 */

fun main() {
    val n = readln().trim().toInt()
    val array1 = readln().trim().split(Regex("\\s+")).filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()
    val m = readln().trim().toInt()
    val array2 = readln().trim().split(Regex("\\s+")).filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()

    val result = IntArray(n + m)
    mergeArrays(array1, 0, array1.lastIndex, array2, 0, array2.lastIndex, result, 0)

    println(result.joinToString(" "))
}


fun mergeArrays(
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