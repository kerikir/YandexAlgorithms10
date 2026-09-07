package contests.first

fun main() {
    val s = readln().trim()
    val t = readln().trim()

    val letters = mutableMapOf<Char, Int>()
    for (char in t) {
        letters[char] = letters.getOrDefault(char, 0) + 1
    }

    var counter = 0

    for (char in s) {
        if (char in letters) {
            counter++
        }
    }

    if (s.length >= 2) {
        val substring1 = mutableMapOf<Char, Int>()
        var flag = true

        substring1[s[0]] = substring1.getOrDefault(s[0], 0) + 1

        for (left in 0..<s.lastIndex) {
            substring1[s[left + 1]] = substring1.getOrDefault(s[1], 0) + 1
            if (left != 0) {
                substring1[s[left - 1]] = substring1.getOrDefault(s[left - 1], 0) - 1
            }

            flag = true
            if (substring1.getOrDefault(s[left], 0) > letters.getOrDefault(s[left], 0)) {
                flag = false
            }
            if (substring1.getOrDefault(s[left + 1], 0) > letters.getOrDefault(s[left + 1], 0)) {
                flag = false
            }
            if (flag) counter++
        }
    }

    if (s.length >= 3) {
        val substring2 = mutableMapOf<Char, Int>()
        var flag = true

        substring2[s[0]] = substring2.getOrDefault(s[0], 0) + 1
        substring2[s[1]] = substring2.getOrDefault(s[1], 0) + 1

        for (right in 2..s.lastIndex) {
            substring2[s[right]] = substring2.getOrDefault(s[right], 0) + 1
            if (right != 2) {
                substring2[s[right - 2]] = substring2.getOrDefault(s[right - 2], 0) - 1
            }

            flag = true
            if (substring2.getOrDefault(s[right - 2], 0) > letters.getOrDefault(s[right - 2], 0)) {
                flag = false
            }
            if (substring2.getOrDefault(s[right - 1], 0) > letters.getOrDefault(s[right - 1], 0)) {
                flag = false
            }
            if (substring2.getOrDefault(s[right], 0) > letters.getOrDefault(s[right], 0)) {
                flag = false
            }
            if (flag) counter++
        }
    }

    println(counter)
}