package c

fun main() {
    val tt = readln().toInt()
    repeat(tt) { testCase() }
}

fun testCase() {
    val ss = readln()

    val blocks = ss.split('+')
    val midBlocks = blocks.subList(1, blocks.lastIndex)
    val blockMaxes = midBlocks.asSequence().map { block ->
        (1..block.lastIndex).maxOf { block.substring(0, it).toLong() + block.substring(it).toLong() }
    }

    println(blocks.first().toLong() + blockMaxes.sum() + blocks.last().toLong())
}
