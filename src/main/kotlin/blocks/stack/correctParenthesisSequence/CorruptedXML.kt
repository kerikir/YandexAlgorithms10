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
    for (tag in tags) {
        if (tag[0] == '/') {
            if (stack.isNotEmpty() && stack.peek() == tag.substring(1)) {
                stack.pop()
            } else {
                return false
            }
        } else {
            stack.push(tag)
        }
    }
    return stack.isEmpty()
}