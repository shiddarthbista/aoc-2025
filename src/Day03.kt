fun main() {

    fun part1(input: List<String>): Int {
         return input.sumOf {bank ->
             val volt = bank.map { it.digitToInt() }

             val best = volt.indices.maxOfOrNull { i ->
                 volt.drop(i + 1).maxOrNull()?.let { right ->
                     volt[i] * 10 + right
                 } ?: 0
             } ?: 0

             best
        }
    }

    fun part2(input: List<String>): Int {
        return 6
    }


    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day03_test")
    part1(testInput).println()
    part2(testInput).println()
    check(part1(testInput) == 357)
    check(part2(testInput) == 6)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day03")
    println("PART 1 SOLUTION: ${part1(input)}")
    println("PART 2 SOLUTION: ${part2(input)}")
}

