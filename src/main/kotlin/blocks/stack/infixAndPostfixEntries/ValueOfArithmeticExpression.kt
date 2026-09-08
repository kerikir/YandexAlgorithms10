package blocks.stack.infixAndPostfixEntries

import java.util.Stack


/*

Задача: Значение арифметического выражения - вывести значение выражения или ошибку, если выражение некорректно

Сложность = O(N)
Ограничения: 1 <= N <= 100
             -2_000_000_000 <= Ai <= 2_000_000_000

Время = 160ms
Память = 25.11MB

 */


fun main() {
    var expression = readln().trim()

    // Избавление от унарного минуса
    if (expression[0] == '-') {
        expression = "0$expression"
    }
    expression = expression.replace("(-", "(0-")

    // Разбиваем выражения пробелами
    val symbols = mutableSetOf("+", "-", "*", "(", ")")
    for (symbol in symbols) {
        expression = expression.replace(symbol, " $symbol ")
    }

    convertInfixToPostfix(expression.split(Regex("\\s+")).filter { it.isNotBlank() })
        .also { postfix ->
            if (postfix.size == 1) {
                println(postfix.first())
            } else {
                calculatePostfix(postfix)
                    .also(::println)
            }
        }
}


fun convertInfixToPostfix(list: List<String>): List<String> {
    val stackOperators = Stack<String>()
    val ans = mutableListOf<String>()

    val brackets = mutableSetOf("(", ")")
    val operations = mutableMapOf<String, Int>().apply {
        this["-"] = 1
        this["+"] = 1
        this["*"] = 2
    }

    var prevType = "operation"

    for (element in list) {

        if (element in operations && prevType != "number") {
            return listOf("WRONG")
        }

        if (element in operations) {

            // Выполнение операций по приоритету
            while (stackOperators.isNotEmpty() && stackOperators.peek() in operations &&
                operations[stackOperators.peek()]!! >= operations[element]!!) {

                ans.add(stackOperators.pop())
            }
            stackOperators.push(element)
            prevType = "operation"

        } else if (element.toIntOrNull() != null) {

            if (prevType == "number") {
                return listOf("WRONG")
            }

            ans.add(element)
            prevType = "number"

        } else if (element in brackets) {

            if (element == "(") {
                if (prevType == "number") {
                    return listOf("WRONG")
                }
                stackOperators.push(element)
                prevType = "bracket"

            } else {
                // Выполняем операции в скобках
                while (stackOperators.isNotEmpty() && stackOperators.peek() != "(") {
                    ans.add(stackOperators.pop())
                }

                if (stackOperators.empty()) {
                    return listOf("WRONG")
                }
                stackOperators.pop()
            }

        } else {
            return listOf("WRONG")
        }
    }

    if (prevType != "number") {
        return listOf("WRONG")
    }

    while (stackOperators.isNotEmpty()) {
        if (stackOperators.peek() == "(") {
            return listOf("WRONG")
        }

        ans.add(stackOperators.pop())
    }

    return ans
}


fun calculatePostfix(list: List<String>): Int {
    val stack = Stack<Int>()

    for (element in list) {
        when(element) {

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

    return stack.first()
}