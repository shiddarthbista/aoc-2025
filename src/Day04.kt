fun main() {

    fun part1(input: List<String>): Int {
        val grid = input.map { it.toList() }
        println(grid)
        return 3
    }

    fun part2(input: List<String>): Int {
        return 6
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day04_test")
    part1(testInput).println()
    part2(testInput).println()
    check(part1(testInput) == 3)
    check(part2(testInput) == 6)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day04")
    println("PART 1 SOLUTION: ${part1(input)}")
    println("PART 2 SOLUTION: ${part2(input)}")
}
