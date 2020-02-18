package sorting

class InsertionSort : Sorter<Int>() {
    override val description: String
        get() = """Like placing batak cards, shift elements bigger than current value until beginning
            If an element lower than or equal to it, place element to that position
            """.trimIndent()

    override fun sortOperation(input: Array<Int>): Array<Int> {
        for (index in 1 until input.size) {
            val valueToInsert = input[index]
            var holePosition = index

            while (holePosition > 0 && input[holePosition - 1] > valueToInsert) {
                input[holePosition] = input[holePosition - 1]
                holePosition--
            }

            input[holePosition] = valueToInsert
        }
        return input
    }
}
