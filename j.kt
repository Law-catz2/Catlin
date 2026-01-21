fun print_common_array(a: IntArray, b: IntArray, c: IntArray): String {
    var arr = intArrayOf()

    for ((n,i) in a.withIndex()) {
        for ((m,j) in b.withIndex()) {
            for ((o,k) in c.withIndex()) {
                if (i == j && j == k) arr += i
            }
        }
    }

    return arr.joinToString()
}

fun main(){

    val ar1 = intArrayOf(1, 5, 10, 20, 40, 80)
    val ar2 = intArrayOf(6, 7, 20, 80, 100)
    val ar3 = intArrayOf(3, 4, 15, 20, 30, 70, 80, 120)

    println("Given:\n\nar1[] = {"+  ar1.joinToString() +"}\n\nar2[] = {"+  ar2.joinToString() +"}\n\nar3[] = {"+  ar3.joinToString() +"}\n")
    println("Output: " + print_common_array(ar1, ar2, ar3))
}
