package d

fun main() {
    val tt = readln().toInt()
    repeat(tt) { testCase() }
}

fun testCase() {
    val (nn, hh, bb) = readln().splitToSequence(' ').map { it.toLong() }.toList()
    val grid = List(2) { readln() }

    val sheepJ = grid.firstNotNullOf { it.withIndex().firstOrNull { it.value == 'S' }?.index }
    val numWolvesLeft = grid.sumOf { it.substring(0, sheepJ).count { it == 'W' } }
    val numWolvesRight = grid.sumOf { it.substring(sheepJ + 1).count { it == 'W' } }
    val moneyEradicateLeft = numWolvesLeft * hh
    val moneyEradicateRight = numWolvesRight * hh

    val minMoney = minOf(
        moneyEradicateLeft + moneyEradicateRight,
        // If there are no wolves on the one side, since all money is positive, the case of not needing to build a trench is covered by killing this side's wolves, which is 0.
        moneyEradicateLeft + 2 * bb,
        2 * bb + moneyEradicateRight,
        3 * bb
    )

    println(minMoney)
}

/*
enum class Use {
    Hunter, Builder
}
*/
