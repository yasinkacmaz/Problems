package sorting

import swap

class QuickSort : Sorter<Int>() {
    override val description: String
        get() = "Set pivot as the last element, then find its place." +
                " After that sort left and right sides of pivot recursively"

    override fun sortOperation(input: Array<Int>): Array<Int> {
        return quickSort(input, 0, input.lastIndex)
    }

    private fun quickSort(input: Array<Int>, startIndex: Int, endIndex: Int): Array<Int> {
        if (startIndex >= endIndex) return input

        val partitionIndex = placePivot(input, startIndex, endIndex)

        quickSort(input, startIndex, partitionIndex - 1)
        quickSort(input, partitionIndex + 1, endIndex)
        return input
    }

    private fun placePivot(input: Array<Int>, startIndex: Int, endIndex: Int): Int {
        var i = startIndex - 1

        for (j in startIndex until endIndex) {
            if (input[j] < input[endIndex]) {
                i++
                input.swap(i, j)
            }
        }

        input.swap(i + 1, endIndex)

        return i + 1
    }
}