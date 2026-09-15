package blocks.sorting.quickSort

/*

Задача: Быстрая сортировка - отсортировать массив чисел

Сложность = O(N * logN)
Ограничения: 0 <= N <= 1_000_000
             -1_000_000_000 <= Ai <= 1_000_000_000

Время = 1s
Память = 134.63MB

 */


fun main() {
    val n = readln().trim().toInt()
    val array = readln().trim().split(' ').filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()

    quickSort(array, 0, array.lastIndex)

    println(array.joinToString(" "))
}


fun quickSort(array: IntArray, left: Int, right: Int) {
    if (left >= right) return

    var l = left
    var r = right
    while (l < r) {
        val middle = l + (r - l) / 2
        val value = array[middle]
        val p = partition(array, l, r) {
            it <= value
        }

        if (p < (l + r) / 2) {
            quickSort(array, l, p)
            l = p + 1
        } else {
            quickSort(array, p + 1, r)
            r = p
        }
    }
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