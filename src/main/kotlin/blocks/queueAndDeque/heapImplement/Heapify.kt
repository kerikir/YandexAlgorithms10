package blocks.queueAndDeque.heapImplement

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