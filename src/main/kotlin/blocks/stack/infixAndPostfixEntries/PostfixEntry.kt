package blocks.stack.infixAndPostfixEntries

import java.util.Stack


/*

Задача: Постфиксная запись - рассчитать значение записанного выражения в форме обратной польской записи

Сложность = O(N)
Ограничения: нет данных

Время = 356ms
Память = 31.48MB

 */


fun main() {
    val expression = readln().trim().split(Regex("\\s+"))

    val stack = Stack<Int>()

    for (element in expression) {
        when (element) {

            "+" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a + b)
            }

            "-" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a - b)
            }

            "*" -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a * b)
            }

            else -> {
                stack.push(element.toInt())
            }
        }
    }

    stack.peek().also(::println)
}