package Assisted_Problems;

import java.util.*;
class Book{
    private String title;
    private String author;

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public String getAuthor(){
        return author;
    }
    public String getTitle(){
        return title;
    }

    public void displayBookDetails(){
        System.out.println("Author name : " + author + "\n");
        System.out.println("Title : " + title + "\n");
    }
    
}

class Library{
    private ArrayList<Book> books ;
    
    Library(){
        this.books = new ArrayList<>();
    }
    
    public void addBook(Book book){
        books.add(book);
    }
    
    public void displayBooks(){
        System.out.println("Books in this Library:");
        for(Book book : books){
            System.out.println("Author : " + book.getAuthor() + "\n" + "Title : " + book.getTitle() + "\n");
        }
    }
}


public class LibrarySystem{
    public static void main(String[] args) {
        Book book1 = new Book("java", "xyz");
        Book book2 = new Book("OOPS", "abc");

        Library library1 = new Library();
        Library library2 = new Library();

        library1.addBook(book1);
        library1.addBook(book2);

        // here book2 is added in both library1 and library2
        library2.addBook(book2);

        library1.displayBooks();
        library2.displayBooks();
    }
}