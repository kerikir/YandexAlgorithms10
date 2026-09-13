package blocks.queueAndDeque.queueAndImplement

import java.util.Stack

fun main() {
    val n = readln().trim().toInt()
    val mainRoad = readln().trim().split(Regex("\\s+")).map { it.toInt() - 1 }

    val queueRoads = Array<ArrayDeque<Pair<Int, Int>>>(4) { ArrayDeque<Pair<Int, Int>>() }
    repeat(n) { index ->
        val (d, t) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
        queueRoads[d - 1].addLast(index to t)
    }

    val drivingRoads = Stack<Int>()
    val result = IntArray(n)
    for (time in 1..n) {
        drivingRoads.clear()

        for (road in queueRoads.indices) {
            val rightRoad = (road - 1 + 4 ) % 4
            val rover = queueRoads[road].firstOrNull()
            if (rover != null && rover.second <= time ) {

                if (
                    road in mainRoad &&
                    (rightRoad !in mainRoad || queueRoads[rightRoad].isEmpty() || queueRoads[rightRoad].first().second > time)
                ) {
                    drivingRoads.push(road)
                    result[rover.first] = time
                }
                if (
                    road !in mainRoad &&
                    (queueRoads[mainRoad[0]].isEmpty() || queueRoads[mainRoad[0]].first().second > time) &&
                    (queueRoads[mainRoad[1]].isEmpty() || queueRoads[mainRoad[1]].first().second > time) &&
                    (queueRoads[rightRoad].isEmpty() || queueRoads[rightRoad].first().second > time)
                ) {
                    drivingRoads.push(road)
                    result[rover.first] = time
                }
            }
        }

        while (drivingRoads.isNotEmpty()) {
            queueRoads[drivingRoads.pop()].removeFirst()
        }
    }

    println(result.joinToString("\n"))
}