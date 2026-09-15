package blocks.sorting.quickSort

/*

Задача: Partition - определить индекс элемента при разбиении массива для быстрой сортировки

Сложность = O(N)
Ограничения: 0 <= N <= 1_000_000
             -1_000_000_000 <= Ai <= 1_000_000_000

Время = 1s
Память = 134.63MB

 */


fun main() {
    val n = readln().trim().toInt()
    val array = readln().trim().split(Regex("\\s+")).filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()

    quickSort(array, 0, array.lastIndex)

    println(array.joinToString(" "))
}


fun quickSort(array: IntArray, left: Int, right: Int) {
    if (left >= right) return

    val middle = left + (right - left) / 2
    val value = array[middle]
    val p = partition(array, left, right) {
        it <= value
    }
    quickSort(array, left, p)
    quickSort(array, p + 1, right)
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