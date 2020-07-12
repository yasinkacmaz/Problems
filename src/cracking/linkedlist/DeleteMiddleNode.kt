package cracking.linkedlist

import cracking.Node
import cracking.initLinkedList
import cracking.joinToString
import cracking.moveToNode

// 2.3 Delete Middle Node: Implement an algorithm to delete a node in the middle
// (i.e., any node but the first and last node, not necessarily the exact middle)
// of a singly linked list, given only access to that node.
fun main() {
    val nodeValues = "yasinkacmaz".toList()
    val head = initLinkedList(nodeValues)
    val nodeToRemove = moveToNode(head, 0) // k

    removeMiddleNode(nodeToRemove)

    val result = joinToString(head)
    print("Result: $result")
}

private fun removeMiddleNode(nodeToRemove: Node<Char>) {
    val nextNode = requireNotNull(nodeToRemove.next) {
        "Cannot remove last node"
    }

    nodeToRemove.value = nextNode.value
    nodeToRemove.next = nextNode.next
}
