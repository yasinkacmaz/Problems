package questions

fun main() {
    val array = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
    fun maxSubArray(nums: IntArray): Int {
        var overallMax = Int.MIN_VALUE
        var currentMax = 0

        for (index in nums.indices) {
            currentMax += nums[index]
            overallMax = maxOf(currentMax, overallMax)
            if (currentMax < 0) currentMax = 0
        }
        return overallMax
    }
    val result = maxSubArray(array)
    print("Result: $result")


}

