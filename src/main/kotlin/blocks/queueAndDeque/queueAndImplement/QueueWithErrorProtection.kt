package blocks.queueAndDeque.queueAndImplement

import java.util.LinkedList
import java.util.Queue


/*

Задача: Стек с защитой от ошибок - вывести протокол работы стека

Сложность = O(N)
Ограничения: нет данных

Время = 544ms
Память = 36.12MB

 */


fun main() {

    val queue: Queue<Int> = LinkedList<Int>()

    while (true) {
        val operation = readln().trim()

        when {
            operation.contains("push") -> {
                val (_, n) = operation.split(Regex("\\s+"))
                queue.offer(n.toInt())
                println("ok")
            }

            operation.contains("pop") -> {
                if (queue.isNotEmpty()) {
                    val a = queue.poll()
                    println(a)
                } else {
                    println("error")
                }
            }

            operation.contains("front") -> {
                if (queue.isNotEmpty()) {
                    val a = queue.peek()
                    println(a)
                } else {
                    println("error")
                }
            }

            operation.contains("size") -> {
                println(queue.size)
            }

            operation.contains("clear") -> {
                queue.clear()
                println("ok")
            }

            operation.contains("exit") -> {
                println("bye")
                break
            }
        }
    }
}