package blocks.stack.correctParenthesisSequence

/*
    Ошибка в тестируемой среде
 */


fun main() {
    val n = readln().trim().toInt()
    val parenthesis = readln().trim()
    val string = readln().trim()

    val closingParenthesis = mutableMapOf<Char, Char>(
        ']' to '[',
        ')' to '('
    )

    val stack = ArrayDeque<Char>()
    for (char in string) {
        if (char in closingParenthesis) {
            if (stack.isNotEmpty())
                stack.removeLast()
        } else {
            stack.addLast(char)
        }
    }

    val result = StringBuilder(string)
    var remain = n - string.length

    while (remain > 0) {

        for (ch in parenthesis) {

            if (ch in closingParenthesis && stack.isNotEmpty() && stack.last() == closingParenthesis[ch]) {
                result.append(ch)
                stack.removeLast()
                break

            } else if (ch !in closingParenthesis && remain >= stack.size + 2) {
                result.append(ch)
                stack.addLast(ch)
                break
            }
        }

        remain--
    }

    println(result.toString())
}