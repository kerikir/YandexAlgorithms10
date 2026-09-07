package contests.first

fun main() {
    val s = readln().trim()
    val t = readln().trim()

    val letters = mutableMapOf<Char, Int>()
    for (char in t) {
        letters[char] = letters.getOrDefault(char, 0) + 1
    }

    var counter = 0

    for (length in 1..t.length) {
        val substring = mutableMapOf<Char, Int>()

        repeat(length - 1) {
            substring[s[it]] = substring.getOrDefault(s[it], 0) + 1
        }

        var flag = true
        for (right in (length - 1)..s.lastIndex) {
            substring[s[right]] = substring.getOrDefault(s[right], 0) + 1
            if (right != length - 1) {
                substring[s[right - length]] = substring.getOrDefault(s[right - length], 0) - 1
            }

            flag = true
            repeat(length) {
                if (substring.getOrDefault(s[right - it], 1) > letters.getOrDefault(s[right - it], 0)) {
                    flag = false
                }
            }
            if (flag) counter++
        }
    }

    println(counter)
}