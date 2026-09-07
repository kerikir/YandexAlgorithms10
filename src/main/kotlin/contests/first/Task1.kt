package contests.first

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