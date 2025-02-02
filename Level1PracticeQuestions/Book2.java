package Level1PracticeQuestions;
public class Book2 {
    String title;
    String author;
    double price;
    Boolean isAvailable;

    public Book2(String title, String author, double price, Boolean isAvailable){
        this.title = title;
        this.author = author;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public boolean borrowBook(){
        if(isAvailable){
            isAvailable = false;
            System.out.println("\nYou have successfully borrowed the book: " + title);
            return true;
        }
        else{
            System.out.println("\nSorry, the book \"" + title + "\" is not available.");
            return false;
        }
    }

    public void displayBookInfo() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: $" + price);
        System.out.println("Availability: " + (isAvailable ? "Available" : "Not Available"));
    }

    public static void main(String[] args) {
        Book2 book = new Book2("1984", "George Orwell", 9.99, true);

        System.out.println("Before borrow book : ");
        book.displayBookInfo();
        
        book.borrowBook();
        
        System.out.println("\nAfter borrow book : ");
        book.displayBookInfo();


    }

}
