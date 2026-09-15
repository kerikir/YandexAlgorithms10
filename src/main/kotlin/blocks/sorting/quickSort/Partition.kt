package blocks.sorting.quickSort

fun main() {
    val n = readln().trim().toInt()
    val array = readln().trim().split(Regex("\\s+")).filter { it.isNotEmpty() }.map { it.toInt() }.toIntArray()
    val x = readln().trim().toInt()

    val index = partition(array, 0, array.lastIndex) {
        it < x
    }

    println(index + 1)
    println(array.size - (index + 1))
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