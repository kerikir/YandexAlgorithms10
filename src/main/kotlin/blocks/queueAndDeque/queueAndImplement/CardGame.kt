package blocks.queueAndDeque.queueAndImplement

import java.util.LinkedList
import java.util.Queue


/*

Задача: Карточная игра - определить победителя игры со сбором карт и количество ходов

Сложность = не известно
Ограничения: N = 10

Время = 125ms
Память = 20.89MB

 */


fun main() {
    val firstPlayer = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val secondPlayer = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val firstCards: Queue<Int> = LinkedList<Int>(firstPlayer)
    val secondCards: Queue<Int> = LinkedList<Int>(secondPlayer)

    var step = 0
    while (firstCards.isNotEmpty() && secondCards.isNotEmpty() && step < 1_000_000) {

        val card1 = firstCards.poll()
        val card2 = secondCards.poll()

        if (isFirstWin(card1, card2)) {
            firstCards.offer(card1)
            firstCards.offer(card2)
        } else {
            secondCards.offer(card1)
            secondCards.offer(card2)
        }

        step++
    }

    if (step == 1_000_000) {
        println("botva")
    } else if (firstCards.isEmpty()) {
        println("second $step")
    } else {
        println("first $step")
    }
}


fun isFirstWin(first: Int, second: Int): Boolean {
    return (first > second && !(first == 9 && second == 0)) || (first == 0 && second == 9)
}