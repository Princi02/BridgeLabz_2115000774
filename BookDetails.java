import java.util.*;
public class BookDetails {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String author = sc.nextLine();
        String title = sc.nextLine();
        double price = sc.nextDouble();
        Book book = new Book(author, title, price);
        book.details();
    }
}

class Book{

    String author;
    String title;
    double price;
    Book(String author, String title, double price){
        this.author = author;
        this.title = title;
        this.price = price;
        
    }

    public void details(){
        System.out.println("The author of the book : " + author);
        System.out.println("The title of the book : " + title);
        System.out.println("The price of the book : " + price);
    }
}

