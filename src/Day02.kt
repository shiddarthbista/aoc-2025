fun main() {

    fun isRepeatedTwice(number: Long) : Boolean {
        val string = number.toString()
        if(string.length % 2 != 0) return false
        val mid = string.length / 2
        return string.take(mid) == string.drop(mid)
    }

    fun getValidRanges(input: List<String>): List<LongRange> {
        val ranges = input.joinToString("")
            .split(",")
            .filter { it.isNotBlank() }
            .map { range ->
                val (start, end) = range.split("-")
                start.toLong()..end.toLong()
            }
        return ranges
    }

    fun isRepeatedAtLeastTwice(number: Long) : Boolean {
        val string = number.toString()
        val maxChunks = string.length / 2

//        for (size in 1..maxChunks) {
//            val chunk = string.take(size)
//            val repeated = chunk.repeat(string.length / size)
//            if (repeated == string) return true
//        }
//
//        return false

        for (size in 1..maxChunks){
            val chunks = string.chunked(size)
            if ( chunks.all { it == chunks.first() } ) return true
        }

        return false
    }

    fun part1(input: List<String>): Long {
        val ranges = getValidRanges(input)

        return ranges.sumOf { range ->
            range.asSequence()
                .filter(::isRepeatedTwice)
                .sum()
        }
    }

    fun part2(input: List<String>): Long {

        val ranges = getValidRanges(input)

        return ranges.sumOf { range ->
            range.asSequence()
                .filter(::isRepeatedAtLeastTwice)
                .sum()
        }

    }


    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    part1(testInput).println()
    part2(testInput).println()
    check(part1(testInput) == 1227775554L)
    check(part2(testInput) == 4174379265L)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    println("PART 1 SOLUTION: ${part1(input)}")
    println("PART 2 SOLUTION: ${part2(input)}")
}

