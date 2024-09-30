package b

fun main() {
    val tt = readln().toInt()
    repeat(tt) { testCase() }
}

fun testCase() {
   val nn = readln().toInt()

    val answer = sequenceOf(1) + (nn downTo 2).asSequence()

    println(answer.joinToString(" "))
}
