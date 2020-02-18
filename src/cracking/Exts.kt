package cracking

fun <T : Any> initLinkedList(iterable: Iterable<T>): Node<T> {
    val head = Node<T>()
    var iteratingHead = head
    for ((index, item) in iterable.withIndex()) {
        iteratingHead.value = item
        if (index != iterable.count() - 1) {
            val newNode = Node<T>()
            iteratingHead.next = newNode
            iteratingHead = newNode
        }
    }
    return head
}

fun <T : Any> joinToString(head: Node<T>): String {
    val stringBuilder = StringBuilder()
    var iteratingHead = head
    while (true) {
        stringBuilder.append(iteratingHead.value).append(" ")
        iteratingHead = iteratingHead.next ?: break
    }
    return stringBuilder.toString()
}
