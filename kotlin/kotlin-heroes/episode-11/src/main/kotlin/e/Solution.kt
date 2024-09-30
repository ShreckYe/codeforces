package e

fun main() {
    val tt = readln().toInt()
    repeat(tt) { testCase() }
}

fun testCase() {
    val ss = readln()

    fun helper(s: String): Int {
        val monocarpChoicesForS = s.asSequence().map {
            when (it) {
                'R' -> 'S'
                'S' -> 'P'
                'P' -> 'R'
                else -> throw IllegalArgumentException(it.toString())
            }
        }
        val commonRoundsScoreDiff = (monocarpChoicesForS.drop(1) zip s.asSequence().take(s.length - 1)).sumOf {
            roundScore(it.first, it.second)
        }

        val sLength = s.length


        /*
        bot:
        RSPRSP...
        Monocarp:
        PRSPRS...
         */

        val botStarting = "RSP"
        //val monStarting = "PRS"

        fun minTotalNumRounds(numRounds: Int, scoreDiff: Int) =
            if (scoreDiff > 0) numRounds
            else numRounds + (1 - scoreDiff)

        return if (s.first() == 'R') {
            val numRounds = sLength
            val scoreDiff = commonRoundsScoreDiff + 1
            minTotalNumRounds(numRounds, scoreDiff)
        } else
            (0..2).minOf { makingSStartingAt ->
                val numRounds = makingSStartingAt + 1 + sLength
                val scoreDiff = makingSStartingAt +
                        roundScore(monocarpChoicesForS.first(), botStarting[makingSStartingAt]) +
                        commonRoundsScoreDiff +
                        1
                minTotalNumRounds(numRounds, scoreDiff)
            }
    }

    println(helper(ss))
}

val choiceNumberMap = mapOf('R' to 0, 'P' to 1, 'S' to 2)

fun roundScore(m: Char, b: Char): Int {
    val diff = (choiceNumberMap.getValue(m) - choiceNumberMap.getValue(b) + 3) % 3
    return (if (diff == 2) -1 else diff).also {
        if (it !in listOf(-1, 0, 1)) throw AssertionError()
    }
}
