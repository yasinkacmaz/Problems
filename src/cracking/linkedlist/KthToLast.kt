package cracking.linkedlist

import cracking.initLinkedList
import cracking.moveToItem

fun main() {
    val nodeValues = "yasinkacmaz".toCharArray().toList()
    var head = initLinkedList(nodeValues)
    val times = 5
    var movedHead = moveToItem(head, times)
    while (true) {
        movedHead = movedHead.next ?: break
        head = head.next ?: break
    }
    print("yaso result: ${head.value}") // k
}
