package blocks.sorting.mergeSort

fun main() {
    val n = readln().trim().toInt()
    val array = readln().trim().split(Regex("\\s+")).map { it.toInt() }.toIntArray()

    val counterSwaps = bubbleSort(array)

    println(counterSwaps)
}


fun bubbleSort(array: IntArray): Int {
    var counterSwap = 0

    repeat(array.size - 1) {
        for (index in 0..<array.lastIndex - it) {

            if (array[index] > array[index + 1]) {
                val temp = array[index + 1]
                array[index + 1] = array[index]
                array[index] = temp

                counterSwap++
            }
        }
    }

    return counterSwap
}