package a

fun main() {
    val tt = readln().toInt()
    repeat(tt) { testCase() }
}

fun testCase() {
    val xAndY = readln().splitToSequence(' ').map { it.toInt() }.toList()

    println("${xAndY.min()} ${xAndY.max()}")
}
