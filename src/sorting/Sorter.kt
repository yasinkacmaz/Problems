package sorting

import java.text.DecimalFormat

abstract class Sorter<T : Any> {
    internal abstract fun sortOperation(input: Array<T>): Array<T>
    abstract val description: String

    fun sort(input: Array<T>): SortResult<T> {
        val startTimeStamp = System.nanoTime()
        val sorted = sortOperation(input.copyOf())
        val endTimeStamp = System.nanoTime()
        val duration = endTimeStamp - startTimeStamp
        return SortResult(sorted, this.javaClass.simpleName, description, duration)
    }
}

data class SortResult<T : Any>(
    val sorted: Array<T>,
    val sortName: String,
    val description: String,
    val duration: Long
) {
    fun printResult() {
        val result = """
            
            ************    $sortName    ************
            $description
            *****************************************
            Sorted elements: ${sorted.joinToString(" ")}
            Duration: ${DecimalFormat("#,###").format(duration)} nanoseconds
            
        """.trimIndent()
        print(result)
    }
}
