package questions
fun main() {
    val ss = twoStrings("yaso", "dm")
    print(ss)
}


fun twoStrings(first: String, second: String): String {
    val unMathchedChars = hashMapOf<Char, Boolean>()
    first.forEach {
        if (unMathchedChars[it] != true) {
            if(it in second) {
                return "YES"
            } else {
                unMathchedChars[it] = true
            }
        }
    }
    return "NO"
}