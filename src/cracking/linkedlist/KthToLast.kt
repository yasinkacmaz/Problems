package cracking.linkedlist

import cracking.initLinkedList
import cracking.moveToNode

// 2.2 Return Kth to Last: Implement an algorithm to find
// the kth to last element of a singly linked list.
fun main() {
    val nodeValues = "yasinkacmaz".toList()
    var head = initLinkedList(nodeValues)
    val times = 5
    var movedHead = moveToNode(head, times)
    while (true) {
        movedHead = movedHead.next ?: break
        head = head.next ?: break
    }
    print("yaso result: ${head.value}") // k
}
