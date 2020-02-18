package sorting

fun main() {
    val input = (30 downTo 0).toList().toTypedArray()
    val sorters = listOf(SelectionSort(), BubbleSort(), InsertionSort(), QuickSort(), MergeSort())
    sorters.map {
        it.sort(input.toList().shuffled().toTypedArray())
    }.forEach { it.printResult() }

    //https://www.geeksforgeeks.org/radix-sort/
    //https://www.geeksforgeeks.org/quicksort-on-singly-linked-list/
}
