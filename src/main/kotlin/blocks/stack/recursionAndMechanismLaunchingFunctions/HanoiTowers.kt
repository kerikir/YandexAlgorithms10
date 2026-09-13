package blocks.stack.recursionAndMechanismLaunchingFunctions

fun main() {
    val n = readln().trim().toInt()
    move(n, 1, 3)
}


fun move(n: Int, x: Int, y: Int) {
    if (n == 0) return
    val temp = 6 - x - y
    move(n - 1, x, temp)
    println("$n $x $y")
    move(n - 1, temp, y)
}