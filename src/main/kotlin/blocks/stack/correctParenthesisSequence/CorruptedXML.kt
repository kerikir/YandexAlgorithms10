package blocks.stack.correctParenthesisSequence

import java.util.Stack

fun main() {
    val string = readln().trim()

    val symbols = mutableMapOf<Char, Int>()
    for (char in string) {
        symbols[char] = symbols.getOrDefault(char, 0) + 1
    }

    val setSymbols = setOf(
        '<', '>', '/',
        'a', 'b', 'c', 'd', 'e', 'f', 'g',
        'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u',
        'v', 'w', 'x', 'y', 'z'
    )

    val result = when {
        symbols['<'] != symbols['>'] -> {
            
        }

        symbols['/'] != symbols['<']!! / 2 -> {

        }

        else -> {
            var char = 'a'
            var count = symbols.getOrDefault(char, 0)
            for (ch in 'b'..'z') {
                if (
                    symbols.getOrDefault(ch, 0) % 2 != 0 &&
                    symbols.getOrDefault(ch, 0) > count
                ) {
                    char = ch
                    count = symbols.getOrDefault(char, 0)
                }
            }

            println(char)
        }
    }

    println(result)
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