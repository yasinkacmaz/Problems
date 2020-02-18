package sorting

class MergeSort : Sorter<Int>() {
    override val description: String
        get() = "Split array as left and right, split sides recursively till" +
                "only one element, then merge back smaller arrays into bigger" +
                "arrays by comparing side elements"

    override fun sortOperation(input: Array<Int>): Array<Int> {
        mergeSort(input, 0, input.lastIndex)
        return input
    }

    private fun mergeSort(array: Array<Int>, low: Int, high: Int) {
        if (high <= low) return // empty or single element array or the sub array cannot split

        val mid = (low + high) / 2
        mergeSort(array, low, mid)
        mergeSort(array, mid + 1, high)
        merge(array, low, mid, high)
    }
}

fun merge(array: Array<Int>, low: Int, mid: Int, high: Int) {
    val leftArray = array.sliceArray(low..mid)
    val rightArray = array.sliceArray(mid + 1..high)

    var leftIndex = 0
    var rightIndex = 0

    for (i in low..high) {
        val canCopyFromLeft = leftIndex < leftArray.size
        val canCopyFromRight = rightIndex < rightArray.size

        val copyFromLeft = {
            array[i] = leftArray[leftIndex]
            leftIndex++
        }
        val copyFromRight = {
            array[i] = rightArray[rightIndex]
            rightIndex++
        }

        when {
            canCopyFromLeft && canCopyFromRight -> {
                if (leftArray[leftIndex] < rightArray[rightIndex]) {
                    copyFromLeft()
                } else {
                    copyFromRight()
                }
            }
            canCopyFromLeft -> copyFromLeft()
            canCopyFromRight -> copyFromRight()
        }
    }
}