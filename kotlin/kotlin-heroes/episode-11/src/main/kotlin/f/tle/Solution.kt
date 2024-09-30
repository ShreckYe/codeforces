package f.tle

import kotlin.math.max
import kotlin.math.min

fun main() {
    val tt = readln().toInt()
    repeat(tt) { testCase() }
}

fun testCase() {
    val nn = readln().toInt()
    val aa = readln().splitToSequence(' ').map { it.toInt() }.toList()

    val subarraysStartingFrom = Array(nn) {
        val ai = aa[it]
        SubarrayCountAndMinMax(true, 1, ai, ai)
    }

    // It's the size before the op.
    for (subarraySize in 1 until nn) {
        for (i in 0 until nn - subarraySize) {
            with(subarraysStartingFrom[i]) {
                if (isStillGood) {
                    //println("$i-${i + subarraySize}: ")
                    val nextA = aa[i + subarraySize]
                    if (nextA in min - 1..max + 1) {
                        count++
                        min = min(min, nextA)
                        max = max(max, nextA)
                        //println(aa.subList(i, i + subarraySize + 1))
                    } else
                        isStillGood = false
                }
            }
        }
        //println()
    }

    println(subarraysStartingFrom.sumOf { it.count })
}

class SubarrayCountAndMinMax(
    var isStillGood: Boolean,
    var count: Long,
    var min: Int,
    var max: Int
)
