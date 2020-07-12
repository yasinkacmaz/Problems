package cracking.linkedlist

import cracking.Node
import cracking.initLinkedList
import cracking.joinToString

// Palindrome: Implement a function to check if a linked list is a palindrome.
// Palindrome = reverse word is equal to original
fun main() {
    val input = "Ey Edip Adanada pide ye"
    isPalindromeWithString(input)
    isPalindromeWithLinkedList(input)
}

fun isPalindromeWithString(input: String) {
    val nodeValues = input.toList()
    val head = initLinkedList(nodeValues)
    val value = joinToString(head, separator = "")
    val reversedValue = value.reversed()
    if (value.equals(reversedValue, ignoreCase = true)) {
        print("\"$input\" is a palindrome")
    } else {
        print("\"$input\" is not a palindrome")
    }
}

fun isPalindromeWithLinkedList(input: String) {
    val nodeValues = input.toList()
    val head = initLinkedList(nodeValues)
    val reversed = reverseAndClone(head)
    val isEqual = isEqual(head, reversed)
    if (isEqual) {
        print("\"$input\" is a palindrome")
    } else {
        print("\"$input\" is not a palindrome")
    }
}

fun reverseAndClone(_head: Node<Char>): Node<Char> {
    var reverseHead: Node<Char>? = null
    var head: Node<Char>? = _head

    while (head != null) {
        val newNode = Node<Char>()
        newNode.value = head.value
        newNode.next = reverseHead
        reverseHead = newNode
        head = head.next
    }
    return reverseHead!!
}

fun isEqual(_head: Node<Char>, _reversedHead: Node<Char>): Boolean {
    var head: Node<Char>? = _head
    var reversedHead: Node<Char>? = _reversedHead
    while (head != null && reversedHead != null) {
        if (head.value!!.equals(reversedHead.value!!, ignoreCase = true)) return false
        head = head.next
        reversedHead = reversedHead.next
    }
    return head == null && reversedHead == null
}
