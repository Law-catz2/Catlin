fun max(l: MutableList<Int>): Int {
	var max = 0
	for (list in l) {
		if (max < list) max = list
	}
	return max
}

fun min(l: MutableList<Int>): Int {
	var min = l[0]
	for (list in l) {
		if (min > list) min = list
	}
	return min
}


fun main() {
	val l = mutableListOf<Int>() 


	print("Enter first number: ")
	l.add(readln().toInt())
	print("Enter second number: ")
	l.add(readln().toInt())
	print("Enter third number: ")
	l.add(readln().toInt())
	print("Enter fourth number: ")
	l.add(readln().toInt())
	print("Enter fifth number: ")
	l.add(readln().toInt())




	println("\nList: [" + l.joinToString() + "]")
	println("Minimum number: " + min(l))
	println("Maximum number: " + max(l))
}
