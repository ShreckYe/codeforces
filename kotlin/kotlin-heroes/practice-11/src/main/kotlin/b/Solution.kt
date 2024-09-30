package b

import kotlin.math.sqrt

fun main() {
    val tt = readln().toInt()
    repeat(tt) { testCase() }
}

fun testCase() {
    val nn = readln().toInt()
    val ss = readln()

    println(if (isSquare(nn, ss)) "Yes" else "No")
}

fun isSquare(n: Int, s: String): Boolean {
    val rc = sqrt(n.toDouble()).toInt()
    if (n != rc * rc) return false
    if (rc == 1) return s == "1"

    val matrix = s.asSequence().chunked(rc).toList()

    return matrix.first().all { it == '1' } &&
            matrix.last().all { it == '1' } &&
            matrix.all { it.first() == '1' } &&
            matrix.all { it.last() == '1' } &&

            matrix.subList(1, rc - 1).all { it.subList(1, rc - 1).all { it == '0' } }
}
