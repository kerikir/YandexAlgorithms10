package blocks.sorting.mergeSort

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
}