package blocks.stack.correctParenthesisSequence

import java.util.Stack

/*
    Ошибка в тестируемой среде
 */


fun main() {
    val n = readln().trim().toInt()
    val parenthesis = readln().trim().toList()
    val string = readln().trim()

    val closingParenthesis = mutableMapOf<Char, Char>(
        ']' to '[',
        ')' to '('
    )

    val stack = Stack<Char>()
    for (char in string) {
        if (char in closingParenthesis) {
            stack.pop()
        } else {
            stack.push(char)
        }
    }

    val result = mutableListOf<Char>()
    var remain = n - string.length

    while (remain > 0) {

        for (ch in parenthesis) {

            if (ch in closingParenthesis && stack.isNotEmpty() && stack.peek() == closingParenthesis[ch]) {
                result.add(ch)
                stack.pop()
                break

            } else if (ch !in closingParenthesis && remain >= stack.size + 2) {
                result.add(ch)
                stack.push(ch)
                break
            }
        }

        remain--
    }

    println(string + result.joinToString(""))
}