package contests.first

/*

Задача: Смена стиля - изменить стиль именования переменных

Сложность = O(N * S)
Ограничения: 1 <= N <= 100
             1 <= S <= 1_000

Время = 251ms
Память = 28.23MB

 */

fun main() {
    val n = readln().trim().toInt()
    val words = ArrayList<String>(n)
    repeat(n) {
        val word = readln().trim()
        words.add(word)
    }

    val result = ArrayList<String>(n)
    val sb = StringBuilder()
    for (word in words) {
        sb.clear()
        word.forEachIndexed { index, char ->
            if (char.isLowerCase()) {
                sb.append(char)
            } else if (index == 0) {
                sb.append(char.lowercase())
            } else {
                sb.append('_' + char.lowercase())
            }
        }
        result.add(sb.toString())
    }
    println(result.joinToString("\n"))
}