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

    val middle = left + (right - left) / 2
    val values = intArrayOf(array[left], array[middle], array[right])
    values.sort()
    val value = values[1]

    val (eq, gr) = partition(array, left, right, value)

    quickSort(array, left, eq - 1)
    quickSort(array, gr, right)
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