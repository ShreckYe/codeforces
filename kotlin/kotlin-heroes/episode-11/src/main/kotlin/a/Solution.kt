package a

fun main() {
    val tt = readln().toInt()
    repeat(tt) { testCase() }
}

fun testCase() {
    val nn = readln().toInt()
    val dd = readln().splitToSequence(' ').map { it.toInt() }.toList()

    val minSkill = dd.subList(0, dd.lastIndex).max()
    val lastD = dd.last()
    val skill = if (minSkill == lastD - 1) minSkill else null

    println(skill ?: "Ambiguous")
}
