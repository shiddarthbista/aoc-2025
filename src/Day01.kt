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
        var pos = 50
        var hits = 0

        input.forEach { line ->
            val dir = if (line.startsWith("R")) 1 else -1
            val steps = line.drop(1).toInt()

            val distanceToZero =
                if (dir == 1) (100 - pos) % 100 else pos % 100

            val firstHit = if (distanceToZero == 0) 100 else distanceToZero

            if (steps >= firstHit) {
                hits += 1 + (steps - firstHit) / 100
            }

            pos = Math.floorMod(pos + dir * steps, 100)
        }

        return hits

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
