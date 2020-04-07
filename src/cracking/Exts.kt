package cracking

fun <T : Any> initLinkedList(iterable: Collection<T>): Node<T> {
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
    return stringBuilder.toString().trim()
}

fun <T : Any> moveToNode(head: Node<T>, nodeIndex: Int): Node<T> {
    var iteratingHead = head
    repeat(nodeIndex) {
        iteratingHead = requireNotNull(iteratingHead.next) {
            "Linked list size is lower than node place : $nodeIndex"
        }
    }
    return iteratingHead
}
