package sorting

import swap

class BubbleSort : Sorter<Int>() {
    override val description: String
        get() = """Max elements cumulates at the end of array like a bubble
            Swap elements from start to last - iteration
            """.trimIndent()

    override fun sortOperation(input: Array<Int>): Array<Int> {
        var alreadySorted: Boolean
        do {
            alreadySorted = iterateOver(input)
        } while (!alreadySorted)
        return input
    }

    private fun iterateOver(input: Array<Int>): Boolean {
        var alreadySorted = true
        for (i in 0 until input.lastIndex) {
            for (index in 0 until input.lastIndex - i)
                if (input[index] > input[index + 1]) {
                    alreadySorted = false
                    input.swap(index, index + 1)
                }
        }
        return alreadySorted
    }
}
