package cracking.linkedlist

import cracking.Node
import cracking.initLinkedList
import cracking.joinToString

// 2.1 Remove Dups! Write code to remove duplicates from an unsorted linked list
// How would you solve this problem if a temporary buffer is not allowed?
fun main() {
    val nodeValues = arrayListOf(1, 5, 3, 2, 6, 7, 8, 3, 2)
    val head = initLinkedList(nodeValues)
    removeDuplicateNodes(head)
    val result = joinToString(head)
    print("yaso result = $result")
}

// Iterate through remaining nodes and remove matched nodes
fun removeDuplicateNodes(head: Node<Int>) {
    var headNode = head

    while (true) {
        val currentValue = headNode.value
        var previousNode: Node<Int>? = headNode
        var nextNode = headNode.next

        while (true) {
            if (nextNode?.value == currentValue) {
                previousNode?.next = nextNode?.next
            } else {
                previousNode = nextNode
            }
            nextNode = nextNode?.next ?: break
        }

        headNode = headNode.next ?: break
    }
}
