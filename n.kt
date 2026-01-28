class Book constructor(val title: String, val author: String,val yearPublished: Int,var isAvailable: Boolean = true) {

    fun borrowBook() { isAvailable = false }
    fun returnBook() { isAvailable = true  }

    fun printDetails(): String = "\"${title}\" by ${author} (${yearPublished})"
}

class Library {
    var books: MutableList<Book> = mutableListOf()

    fun addBook(book: Book) {
        books.add(Book(book.title, book.author, book.yearPublished, book.isAvailable))
    }
    fun showAvailableBooks() {
        var i = 1
        println("All Available Books: \n")
        books.forEach { if(it.isAvailable == true) println("${i++}. ${it.printDetails()}") }
    }

    /*EXTRA FUNCTIONS*/
    fun borrow(book: String?) {
        println("Borrowing \"${book}\"...\n")
        books.forEach { if(it.title == book) it.borrowBook() }
    }

    fun Return(book: String?) {
        println("Returning \"${book}\"...\n")
        books.forEach { if(it.title == book) it.returnBook() }
    }
}

fun main() {
    var linux = Library()

    linux.addBook(Book("Kotlin Basics","Jane Doe", 2023))
    linux.addBook(Book("Android Development","John Smith", 2022))
    linux.addBook(Book("Data Structures","Alice Lee", 2021))

    linux.showAvailableBooks()
    print("\nEnter the title of the book to borrow: ")
    linux.borrow(readln())
    linux.showAvailableBooks()
    print("\nEnter the title of the book to return: ")
    linux.Return(readln())
    linux.showAvailableBooks()
}//     Android Development
