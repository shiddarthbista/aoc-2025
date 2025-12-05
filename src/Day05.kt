fun main() {

    fun mergeRanges(ranges: List<Pair<Long, Long>>): List<Pair<Long, Long>> =
        ranges
            .sortedBy { it.first }
            .fold(mutableListOf()) { acc, (start, end) ->
                when {
                    acc.isEmpty() ->
                        acc += start to end

                    start <= acc.last().second + 1 -> {
                        val (s, e) = acc.last()
                        acc[acc.lastIndex] = s to maxOf(e, end)
                    }

                    else ->
                        acc += start to end
                }
                acc
            }

    fun part1(input: List<String>): Int {
        val (ingredientRange, ingredientId) = input.partition {
            it.contains("-")
        }
        val ingredientRanges = ingredientRange.map { range ->
            val(start,end) = range.split("-").map { it.toLong() }
            start to end
        }
        val ingredientIdClean = ingredientId.filter { it.isNotBlank() }.map { it.toLong() }
        val validIngreadientIds = ingredientIdClean.count {
            ingredientRanges.any { (start, end) -> it in start..end }
        }

        return validIngreadientIds
    }

    fun part2(input: List<String>): Long {
        input.filter { it.contains("-") }
        val ingredientRanges =input
            .filter { it.contains("-") }
            .map { range ->
                val(start,end) = range.split("-").map { it.toLong() }
            start to end
        }

        val merged = mergeRanges(ingredientRanges)
        println(merged)

        val total = merged.sumOf {
            it.second - it.first + 1
        }

        return total
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day05_test")
    part1(testInput).println()
    part2(testInput).println()
    check(part1(testInput) == 3)
    check(part2(testInput) == 14L)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day05")
    println("PART 1 SOLUTION: ${part1(input)}")
    println("PART 2 SOLUTION TEST SOLUTION: ${part2(testInput)}")
    println("PART 2 SOLUTION: ${part2(input)}")
}
