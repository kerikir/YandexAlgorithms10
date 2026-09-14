package blocks.queueAndDeque.dequeAndMinimumInWindow

/*

Задача: Гоблины и шаманы - определить порядок гоблинов в очереди

Сложность = O(N)
Ограничения: 1 <= N <= 100_000

Время = 453ms
Память = 41.51MB

 */

fun main() {
    val n = readln().trim().toInt()
    val part1 = ArrayDeque<Int>()
    val part2 = ArrayDeque<Int>()
    val result = mutableListOf<Int>()

    repeat(n) {
        val command = readln().trim()

        when (command.first()) {
            '+' -> {
                part2.addLast(command.substring(2).toInt())
            }

            '*' -> {
                part2.addFirst(command.substring(2).toInt())
            }

            '-' -> {
                val goblin = part1.removeFirst()
                result.add(goblin)
            }
        }

        if (part2.size > part1.size) {
            val goblin = part2.removeFirst()
            part1.addLast(goblin)
        }
    }

    println(result.joinToString("\n"))
}