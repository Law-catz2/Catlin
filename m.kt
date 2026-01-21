fun discount(type: String?, price: Int?): Double {
	when (type!!.uppercase()) {
		"REGULAR" -> return price?.let {p -> p - (p*0.05) } ?: 0.0
		"MEMBER" -> return price?.let {p -> p - (p*0.1) } ?: 0.0
		"VIP" -> return price?.let {p -> p - (p*0.15) } ?: 0.0
	}
	return 0.00
}

fun main() {
	println("Welcome to our Discount Calculator!\n\nList of Customer Types: Regular, Member, VIP")
	
	print("\nSelect a customer type: ")
	val type: String? = readlnOrNull()
	print("Enter price of product: ")
	val price = readlnOrNull()?.toIntOrNull() ?: 0

	println("\nFinal price of product: " + "%.2f".format(discount(type, price)))
}
