package blocks.stack.infixAndPostfixEntries

import java.util.Stack

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

    println(result.toString())
}