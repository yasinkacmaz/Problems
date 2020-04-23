package cracking.linkedlist

import cracking.Node
import cracking.initLinkedList
import cracking.joinToString

// 2.4 Partition: Write code to partition a linked list around a value x, such that all nodes less than x come
// before all nodes greater than or equal to x. lf x is contained within the list, the values of x only need
// to be after the elements less than x (see below). The partition element x can appear anywhere in the
// "right partition"; it does not need to appear between the left and right partitions.
fun main() {
    val nodeValues = listOf(3, 5, 8, 5, 10, 2, 1)
    val head = initLinkedList(nodeValues)
    val lowerHead = partition(head, 5)
    val result = joinToString(lowerHead!!)
    print("yaso result : $result")
}

private fun partition(head: Node<Int>?, partitionValue: Int): Node<Int>? {
    val lowerHead = Node.create(-1)
    val higherHead = Node.create(-1)
    var lowerHeadIterator: Node<Int>? = lowerHead
    var higherHeadIterator: Node<Int>? = higherHead
    var headIterator = head ?: return head

    while (true) {
        val nodeValue = headIterator.value!!
        val newNode = Node<Int>()
        newNode.value = nodeValue

        if (nodeValue < partitionValue) {
            lowerHeadIterator!!.next = newNode
            lowerHeadIterator = newNode
        } else {
            higherHeadIterator!!.next = newNode
            higherHeadIterator = newNode
        }

        headIterator = headIterator.next ?: break
    }
    lowerHeadIterator!!.next = higherHead.next
    return lowerHead.next
}
