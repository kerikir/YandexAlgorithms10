package blocks.sorting.ordinalStatistics

fun main() {

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