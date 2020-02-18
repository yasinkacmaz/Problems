fun String.asOperationList() = reader().readLines()

fun <T : Any> Array<T>.swap(leftIndex: Int, rightIndex: Int) {
    val temp = get(leftIndex)
    set(leftIndex, get(rightIndex))
    set(rightIndex, temp)
}
