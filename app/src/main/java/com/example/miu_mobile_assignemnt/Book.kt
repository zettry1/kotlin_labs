/**
 * You can edit, run, and share this code.
 * play.kotlinlang.org
 */
fun print_last_first(num:Int){
    var  last:Int=num%10;
    var first =num;
    while (first>=10){
        first = first/10;
    }

    println("$first$last".toInt());
}

fun odd_squar_sum(nums:IntArray){
    var  res:Int=0;
    for (n in nums){
        println(n);
        if (n%2==1){
            res+=n*n;
        }
    }
    println(res);
}

fun printWeight(weight:Int,planetString:String):Number{


    // println("Enter planer:")
    //   val planetString = readLine();
    val intWeight =weight;
    var res= when(planetString){
        "Venus"->intWeight*0.78;
        "Mars"-> intWeight*0.39;
        "Jupiter"->  intWeight*2.65
        "Saturn"->  intWeight*1.17
        "Uranus"->  intWeight*1.05
        "Neptune"->  intWeight*1.23
        else-> intWeight;
    }
    println(res);
    return res;

}

open class Book(
    var title: String,
    var author: String,
    var price: Double,
) {

    open fun read() {
        println("Reading Paper book");
    }

    fun getBookTitle(): String {
        return title
    }

    fun setBookTitle(titl: String) {
        title = titl
    }

    fun getBookAuthor(): String {
        return author
    }

    fun setBookAuthor(newAuthor: String) {
        author = newAuthor
    }
    fun getBookPrice():Double{
        return price;
    }


}

class EBook(
    title: String,
    author: String,
    price: Double,
    private var fileType: String
) : Book(title, author, price) {

    override fun read() {
        println("Overriding")
        println("Read from Electronic Device")
    }


    fun setFileType(newFileType: String) {
        fileType = newFileType
    }

    fun getFileType(): String {
        return fileType
    }
}

fun main() {
    printWeight(80,"Venus");
    print(print_last_first(4212));
    print(odd_squar_sum(intArrayOf(1,2,3,4,5)));
    //
    val paperBook = Book("My Orgil", "Orgilbat", 322.22)
     val ebook = EBook("Orgil e book", "EBook ZZ", 12.99, "epub")

    println("Paper Book - Title: ${paperBook.getBookTitle()}, Author: ${paperBook.getBookAuthor()}, Price: ${paperBook.getBookPrice()}")
    paperBook.read()

     println("EBook - Title: ${ebook.getBookTitle()}, Author: ${ebook.getBookAuthor()}, Price: ${ebook.getBookPrice()}, FileType: ${ebook.getFileType()}")
     ebook.read()
}
