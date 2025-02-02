package Level1PracticeQuestions;
public class Book {
    String title;
    String author;
    double price;

    // default constructor
    public Book(){
        this.title = "1984";
        this.author = "George Orwell";
        this.price = 1386;
    }
    // parameterized constructor
    public Book(String title, String author, double price){
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void display(){
        System.out.println("Book Title: " + title + "\nAuthor: " + author + "\nPrice: $" + price);
    }

    public static void main(String[] args) {
        System.out.println("using default constructor: ");
        Book book1 = new Book();
        book1.display();
        
        System.out.println("using parameterized constructor: ");
        Book book2 = new Book("The Catcher in the Rye", "J.D. Salinger", 9.99);
        book2.display();
    }

}
