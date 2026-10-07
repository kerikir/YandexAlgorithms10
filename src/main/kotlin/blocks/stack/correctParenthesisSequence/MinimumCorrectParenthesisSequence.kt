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

    val stackArray = CharArray(n)
    var top = 0

    for (char in string) {
        if (char in closingParenthesis) {
            if (top > 0)
                top--
        } else {
            stackArray[top++] = char
        }
    }

    val result = StringBuilder(string)
    var remain = n - string.length

    while (remain > 0) {

        for (ch in parenthesis) {
            if (ch in closingParenthesis && top > 0 && stackArray[top - 1] == closingParenthesis[ch]) {
                result.append(ch)
                top--
                break

            } else if (ch !in closingParenthesis && remain >= top + 2) {
                result.append(ch)
                stackArray[top++] = ch
                break
            }
        }

        remain--
    }

    println(result.toString())
}