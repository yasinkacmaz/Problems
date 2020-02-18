package questions

fun main() {
    val aray = productExceptSelf(intArrayOf(1, 2, 3, 4, 5))
    // expected = 720, 360, 240, 180, 144, 120
    println(aray.joinToString(" "))
}

fun productExceptSelf(nums: IntArray): IntArray {
    var leftProduct = 1
    var rightProduct = 1
    val result = IntArray(nums.size) { 1 }

    for(i in nums.indices) {
        result[i] = leftProduct
        leftProduct *= nums[i]
    }

    for (i in nums.lastIndex downTo 0) {
        result[i] *= rightProduct
        rightProduct *= nums[i]
    }

    return result
}
