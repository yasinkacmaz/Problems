package sorting

import swap

class SelectionSort : Sorter<Int>() {
    override val description: String
        get() = "Select minimum element from remaining array and place it to start"

    override fun sortOperation(input: Array<Int>): Array<Int> {
        for (index in input.indices) {
            var min = Int.MAX_VALUE
            var minIndex = -1
            for (j in index until input.size) {
                if (input[j] < min) {
                    min = input[j]
                    minIndex = j
                }
            }
            input.swap(index, minIndex)
        }
        return input
    }
}
