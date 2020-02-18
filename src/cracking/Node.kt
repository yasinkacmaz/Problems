package cracking

class Node<T : Any> {
    lateinit var value: T

    var next: Node<T>? = null
}
