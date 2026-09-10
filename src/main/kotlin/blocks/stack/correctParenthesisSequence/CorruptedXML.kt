package blocks.stack.correctParenthesisSequence

import java.util.Stack

fun main() {
    val string = readln().trim()


    println(string.isCorrectXML())
}


fun String.isCorrectXML(): Boolean {
    val tags = Regex("<[a-z/<]+>")
        .findAll(this)
        .map { it.value.replace(Regex("[<>]"), "") }
        .toList()

    val stack = Stack<String>()
    return false
}