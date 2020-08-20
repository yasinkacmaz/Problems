package cracking.linkedlist

import cracking.*

/*
Intersection: Given two (singly) linked lists, determine if the two lists intersect.Return the intersecting node.
Note that the intersection is defined based on reference, not value. That is, if the kth node of the first linked list
is the exact same node (by reference) as the jth node of the second linked list, then they are intersecting.
 */
fun main() {
    val firstInput = "789"
    val secondInput = "0123456"
    val commonInput = "same"
    val firstHead = initLinkedList(firstInput.toList())
    val secondHead = initLinkedList(secondInput.toList())
    val commonHead = initLinkedList(commonInput.toList())
    val firstTail = moveToNode(firstHead, 2)
    firstTail.next = commonHead
    val secondTail = moveToNode(secondHead, 6)
    secondTail.next = commonHead
    val commonNode = findCommonNode(firstHead, secondHead)
    if (commonNode == null) {
        println("No common node detected")
    } else {
        println("Found common node. Hash Code: ${commonNode.hashCode()}, value: ${commonNode.value}")
    }
}

private fun findCommonNode(_head: Node<Char>, _secondHead: Node<Char>): Node<Char>? {
    var head: Node<Char>? = _head
    var secondHead: Node<Char>? = _secondHead
    val firstListLength = length(_head)
    val secondListLength = length(_secondHead)

    if (firstListLength > secondListLength) {
        head = moveToNode(_head, firstListLength - secondListLength)
    } else if (firstListLength < secondListLength) {
        secondHead = moveToNode(_secondHead, secondListLength - firstListLength)
    }

    while (true) {
        if (head === secondHead) return head
        head = head?.next ?: break
        secondHead = secondHead?.next ?: break
    }
    return null
}
