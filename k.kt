import kotlin.system.exitProcess

fun add (a: Int, b: Int): Int {
    println("Result: ${a + b}")
    return a + b
}

fun sub (a: Int, b: Int): Int {
    println("Result: ${a - b}")
    return a - b
}

fun mul (a: Int, b: Int): Int {
    println("Result: ${a * b}")
    return a * b
}

fun div (a: Int, b: Int): Int {
    println("Result: ${a / b}")
    return a / b
}


fun main () {
    var history = intArrayOf()

    while (true) {
        print("\u001b[H\u001b[2J")
        System.out.flush()

        println("Welcome to Kotlin Calculator!\nChoose an Operation:\n1. Addition\n2. Subtraction\n3. Multiplication\n4. Division\n5. View History\n6. Clear History\n7. Exit")

        print("\nEnter your choice: ")
        val choice: Int? = readln().toInt()


        var a = 0
        var b = 0

        if (choice in 1..4) {
            print("Enter the first number: ")
            a = readln().toInt()
            print("Enter the second number: ")
            b = readln().toInt()
        }

        when (choice) {
            1 -> history += add(a, b)
            2 -> history += sub(a, b)
            3 -> history += mul(a, b)
            4 -> history += div(a, b)
            5 -> println("Calculation history: " + history.contentToString())
            6 -> history = intArrayOf()
            7 -> {
                println("Goodbye!")
                exitProcess(0)
            }
        }
        readlnOrNull()
    }
}
