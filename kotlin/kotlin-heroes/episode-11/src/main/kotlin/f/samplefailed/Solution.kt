package f.samplefailed

import kotlin.math.max
import kotlin.math.min

fun main() {
    val tt = readln().toInt()
    repeat(tt) { testCase() }
}

fun testCase() {
    val nn = readln().toInt()
    val aa = readln().splitToSequence(' ').map { it.toInt() }.toList()

    var count = 0
    var lastI = 0

    var i = 0
    while (i < nn) {
        var min = aa[i]
        var max = aa[i]
        i++

        while (i < nn) {
            val ai = aa[i]
            if (ai in min - 1..max + 1) {
                min = min(min, ai)
                max = max(max, ai)
                i++
            } else
                break
        }
        val length = i - lastI
        lastI = i
        count += (length * (length + 1)) / 2
    }

    println(count)
}
