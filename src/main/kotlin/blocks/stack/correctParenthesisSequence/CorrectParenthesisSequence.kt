package blocks.stack.correctParenthesisSequence

import java.util.Stack

/*

Задача: Правильная скобочная последовательность - определить является ли последовательность ПСП
                                                  из нескольких видов скобок

Сложность = O(N)
Ограничения: 0 <= N <= 100_000

Время = 206ms
Память = 21.14MB

 */


fun main() {
    val string = readln().trim()

    val parentheses = mutableMapOf<Char, Char>().apply {
        this['}'] = '{'
        this[')'] = '('
        this[']'] = '['
    }

    val stack = Stack<Char>()

    for (parenthesis in string) {
        when (parenthesis) {

            in parentheses -> {
                if (stack.isNotEmpty() && stack.peek() == parentheses.getOrDefault(parenthesis, ' ')) {
                    stack.pop()
                } else {
                    println("no")
                    return
                }
            }

            '(', '[', '{' -> {
                stack.push(parenthesis)
            }
        }
    }

    if (stack.empty()) {
        println("yes")
    } else {
        println("no")
    }
}