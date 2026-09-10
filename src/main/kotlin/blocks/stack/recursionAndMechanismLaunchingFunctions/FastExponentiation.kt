package blocks.stack.recursionAndMechanismLaunchingFunctions

/*

Задача: Быстрое возведение в степень - определить результат возведения в степень действительного числа

Сложность = O(logN)
Ограничения: 0 <= N <= 1_000_000_000

Время = 107ms
Память = 19.91MB

 */


fun main() {
    val a = readln().trim().toDouble()
    val n = readln().trim().toInt()

    println(power(a, n))
}


fun power(a: Double, n: Int): Double {
    if (n == 0) return 1.0
    return if (n % 2 == 0) {
        power(a * a, n / 2)
    } else {
        a * power(a, n - 1)
    }
}