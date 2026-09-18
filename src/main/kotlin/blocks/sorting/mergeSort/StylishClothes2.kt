package blocks.sorting.mergeSort

/*

Задача: Стильная одежда 2 - определить цвета наиболее стильной одежды

Сложность = O(N * logN)
Ограничения: 1 <= N <= 100_000
             1 <= Ai <= 100_000

Время = 2s
Память = 57.3MB

 */

fun main() {
    val numberOfCaps = readln().trim().toInt()
    val colorsOfCaps = readln().trim().split(Regex("\\s+")).map { it.toInt() }.toIntArray()
    val numberOfShirts = readln().trim().toInt()
    val colorsOfShirts = readln().trim().split(Regex("\\s+")).map { it.toInt() }.toIntArray()
    val numberOfPants = readln().trim().toInt()
    val colorsOfPants = readln().trim().split(Regex("\\s+")).map { it.toInt() }.toIntArray()
    val numberOfShoes = readln().trim().toInt()
    val colorsOfShoes = readln().trim().split(Regex("\\s+")).map { it.toInt() }.toIntArray()

    colorsOfCaps.sort()
    colorsOfShirts.sort()
    colorsOfPants.sort()
    colorsOfShoes.sort()

    var minDifference = Int.MAX_VALUE
    var indexOfCap = 0
    var indexOfShirt = 0
    var indexOfPants = 0
    var indexOfShoes = 0
    var clothingColors = intArrayOf()

    while (
        indexOfCap < numberOfCaps &&
        indexOfShirt < numberOfShirts &&
        indexOfPants < numberOfPants &&
        indexOfShoes < numberOfShoes
    ) {
        val array = arrayOf(
            colorsOfCaps[indexOfCap] to Clothes.CAP,
            colorsOfShirts[indexOfShirt] to Clothes.SHIRT,
            colorsOfPants[indexOfPants] to Clothes.PANTS,
            colorsOfShoes[indexOfShoes] to Clothes.SHOES
        ).sortedWith(
            compareBy<Pair<Int, Clothes>>({ it.first }, { it.second })
        )

        val max = array.last().first
        val min = array.first().first
        val dif = max - min

        if (dif < minDifference) {
            minDifference = dif
            clothingColors = intArrayOf(
                colorsOfCaps[indexOfCap],
                colorsOfShirts[indexOfShirt],
                colorsOfPants[indexOfPants],
                colorsOfShoes[indexOfShoes]
            )
        }

        when (array.first().second) {
            Clothes.CAP -> {
                indexOfCap++
            }
            Clothes.SHIRT -> {
                indexOfShirt++
            }
            Clothes.PANTS -> {
                indexOfPants++
            }
            Clothes.SHOES -> {
                indexOfShoes++
            }
        }
    }

    println(clothingColors.joinToString(" "))
}


enum class Clothes {
    CAP, SHIRT, PANTS, SHOES
}