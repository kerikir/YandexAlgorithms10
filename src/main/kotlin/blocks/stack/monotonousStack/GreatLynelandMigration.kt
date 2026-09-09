package blocks.stack.monotonousStack

import java.util.Stack

/*

Задача: Великое Лайнландское переселение - определить ближайший восточный город с меньшей стоимостью жизни

Сложность = O(N)
Ограничения: 2 <= N <= 100_000
             0 <= Ai <= 1_000_000_000

Время = 646ms
Память = 42.71MB

 */


fun main() {
    val n = readln().trim().toInt()
    val prices = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val stack = Stack<Pair<Int, Int>>()
    val relocations = IntArray(n) { -1 }
    for (city in prices.indices) {
        while (stack.isNotEmpty() && prices[city] < stack.peek().second) {
            val (index, cost) = stack.pop()
            relocations[index] = city
        }
        stack.push(city to prices[city])
    }

    relocations.joinToString(" ").also(::println)
}