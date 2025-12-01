fun main() {


    fun part1(input: List<String>): Int {
        var position = 50
        var zeros = 0

        input.forEach { line ->
            val direction = if (line.startsWith("R")) 1 else -1
            val steps = line.drop(1).toInt()

            position = Math.floorMod(position + direction * steps, 100)

            if (position == 0) zeros++
        }
        return zeros
    }

    fun part2(input: List<String>): Int {
        var startingPosition = 50
        var crossZero = 0

        input.forEach { line ->
            val direction = line.takeWhile { it.isLetter() }
            val stepsInstruction = line.dropWhile { it.isLetter() }.toInt()

            val dir = if (direction == "R") 1 else -1

            crossZero += stepsInstruction / 100

            val remainder = stepsInstruction % 100

            val hitZero = if (direction == "L") {
                startingPosition in 1..remainder
            } else {
                (100 - startingPosition) in 1..remainder
            }
            if (hitZero) crossZero++

            startingPosition = ((startingPosition + dir * remainder) % 100 + 100) % 100
        }

        return crossZero
    }


    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    part1(testInput).println()
    part2(testInput).println()
    check(part1(testInput) == 3)
    check(part2(testInput) == 6)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    println("PART 1 SOLUTION: ${part1(input)}")
    println("PART 2 SOLUTION: ${part2(input)}")
}
