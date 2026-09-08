package blocks.stack.infixAndPostfixEntries

import java.util.Stack

/*

Задача: Значение логического выражения - определить значение логического выражения (0 или 1)

Сложность = O(N)
Ограничения: 1 <= N <= 100
             0 <= Ai <= 1

Время = 146ms
Память = 24.2MB

 */

fun main() {
    var expression = readln().trim()

    val brackets = mutableSetOf('(', ')')
    val operations = mutableMapOf<Char, Int>().apply {
        this['!'] = 3
        this['&'] = 2
        this['|'] = 1
        this['^'] = 1
    }

    val stackOperators = Stack<Char>()
    val result = StringBuilder()
    for (element in expression) {

        if (element in operations) {
            while (stackOperators.isNotEmpty() && stackOperators.peek() in operations &&
                operations[stackOperators.peek()]!! >= operations[element]!!) {

                result.append(stackOperators.pop())
            }
            stackOperators.push(element)

        } else if (element in brackets) {
            if (element == '(') {
                stackOperators.push(element)
            } else {
                while (stackOperators.isNotEmpty() && stackOperators.peek() != '(') {
                    result.append(stackOperators.pop())
                }
                stackOperators.pop()
            }

        } else {
            result.append(element)
        }
    }
    while (stackOperators.isNotEmpty()) {
        result.append(stackOperators.pop())
    }

    val stack = Stack<Int>()
    for (element in result.toString()) {
        when(element) {

            '^' -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a xor b)
            }

            '!' -> {
                val a = stack.pop()
                if (a == 0) {
                    stack.push(1)
                } else {
                    stack.push(0)
                }
            }

            '&' -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a and b)
            }

            '|' -> {
                val b = stack.pop()
                val a = stack.pop()
                stack.push(a or b)
            }

            else -> {
                stack.push(element.digitToInt())
            }
        }
    }

    println(stack.first())
}