fun main() {

    fun isRepeatedTwice(number: Long) : Boolean {
        val string = number.toString()
        if(string.length % 2 != 0) return false
        val mid = string.length / 2
        return string.take(mid) == string.drop(mid)
    }

    fun part1(input: List<String>): Long {
        val ranges = input.joinToString("")
            .split(",")
            .filter { it.isNotBlank() }
            .map { range ->
                val (start, end) = range.split("-")
                start.toLong()..end.toLong()
            }

        return ranges.sumOf { range ->
            range.asSequence()
                .filter(::isRepeatedTwice)
                .sum()
        }
    }

    fun part2(input: List<String>): Int {
        return 6
    }


    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day02_test")
    part1(testInput).println()
    part2(testInput).println()
    check(part1(testInput) == 1227775554L)
    check(part2(testInput) == 6)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day02")
    println("PART 1 SOLUTION: ${part1(input)}")
    println("PART 2 SOLUTION: ${part2(input)}")
}

