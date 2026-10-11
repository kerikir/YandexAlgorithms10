package blocks.queueAndDeque.heapImplement

/*

Задача: Хипуй - реализовать кучу с наибольшими числами

Сложность = O(N * logN)
Ограничения: 1 <= N <= 100_000

Время = 532ms
Память = 40.24MB

 */

fun main() {
    val n = readln().trim().toInt()
    val commands = mutableListOf<String>()
    repeat(n) {
        val command = readln().trim()
        commands.add(command)
    }

    val heap = mutableListOf<Int>()
    val result = mutableListOf<Int>()
    for (command in commands) {
        when (command[0]) {
            '0' -> {
                val number = command.substring(2).toInt()
                heap.add(number)
                siftingUp(heap)
            }

            '1' -> {
                val number = heap.first()
                siftingDown(heap)
                heap.removeLast()
                result.add(number)
            }
        }
    }

    println(result.joinToString("\n"))
}


fun siftingUp(array: MutableList<Int>) {
    var index = array.lastIndex

    while (index > 0) {
        val parent = (index - 1) / 2

        if (array[parent] < array[index]) {
            array[index] = array[parent].also { array[parent] = array[index] }
            index = parent

        } else {
            break
        }
    }
}


fun siftingDown(array: MutableList<Int>) {
    var index = 0
    array[index] = array[array.lastIndex]

    while (index < array.lastIndex) {
        val child1 = 2 * index + 1
        val child2 = 2 * index + 2

        when {
            child2 < array.size && (array[child1] > array[index] || array[child2] > array[index]) -> {

                if (array[child1] > array[child2]) {
                    array[index] = array[child1].also { array[child1] = array[index] }
                    index = child1

                } else {
                    array[index] = array[child2].also { array[child2] = array[index] }
                    index = child2
                }
            }

            child2 == array.size && array[child1] > array[index] -> {
                array[index] = array[child1].also { array[child1] = array[index] }
                index = child1
            }

            else -> {
                break
            }
        }
    }
}