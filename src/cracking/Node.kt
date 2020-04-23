package cracking

class Node<T : Any> {
    var value: T? = null

    var next: Node<T>? = null

    companion object {
        fun <T : Any> create(value: T) = Node<T>().apply { this.value = value }
    }
}
