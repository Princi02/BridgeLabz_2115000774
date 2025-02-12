import java.util.*;

class Book {
    String title, author, genre;
    int id;
    boolean available;
    Book next, prev;

    Book(int id, String title, String author, String genre, boolean available) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.available = available;
    }
}

class Library {
    Book head, tail;

    void addFirst(int id, String title, String author, String genre, boolean available) {
        Book newBook = new Book(id, title, author, genre, available);
        if (head == null) {
            head = tail = newBook;
            return;
        }
        newBook.next = head;
        head.prev = newBook;
        head = newBook;
    }

    void addLast(int id, String title, String author, String genre, boolean available) {
        Book newBook = new Book(id, title, author, genre, available);
        if (head == null) {
            head = tail = newBook;
            return;
        }
        tail.next = newBook;
        newBook.prev = tail;
        tail = newBook;
    }

    void addAt(int id, String title, String author, String genre, boolean available, int pos) {
        if (pos == 1) {
            addFirst(id, title, author, genre, available);
            return;
        }
        Book temp = head;
        for (int i = 1; temp != null && i < pos - 1; i++) temp = temp.next;
        if (temp == null) return;
        Book newBook = new Book(id, title, author, genre, available);
        newBook.next = temp.next;
        if (temp.next != null) temp.next.prev = newBook;
        temp.next = newBook;
        newBook.prev = temp;
        if (newBook.next == null) tail = newBook;
    }

    void removeById(int id) {
        if (head == null) return;
        if (head.id == id) {
            head = head.next;
            if (head != null) head.prev = null;
            return;
        }
        Book temp = head;
        while (temp != null && temp.id != id) temp = temp.next;
        if (temp == null) return;
        if (temp.next != null) temp.next.prev = temp.prev;
        if (temp.prev != null) temp.prev.next = temp.next;
        if (temp == tail) tail = temp.prev;
    }

    void searchByTitle(String title) {
        for (Book temp = head; temp != null; temp = temp.next)
            if (temp.title.equalsIgnoreCase(title))
                System.out.println(temp.id + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | " + (temp.available ? "Available" : "Not Available"));
    }

    void searchByAuthor(String author) {
        for (Book temp = head; temp != null; temp = temp.next)
            if (temp.author.equalsIgnoreCase(author))
                System.out.println(temp.id + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | " + (temp.available ? "Available" : "Not Available"));
    }

    void updateAvailability(int id, boolean status) {
        for (Book temp = head; temp != null; temp = temp.next)
            if (temp.id == id) { temp.available = status; return; }
    }

    void displayForward() {
        for (Book temp = head; temp != null; temp = temp.next)
            System.out.println(temp.id + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | " + (temp.available ? "Available" : "Not Available"));
    }

    void displayReverse() {
        for (Book temp = tail; temp != null; temp = temp.prev)
            System.out.println(temp.id + " | " + temp.title + " | " + temp.author + " | " + temp.genre + " | " + (temp.available ? "Available" : "Not Available"));
    }

    int countBooks() {
        int count = 0;
        for (Book temp = head; temp != null; temp = temp.next) count++;
        return count;
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Library lib = new Library();
        lib.addLast(1, "The Alchemist", "Paulo Coelho", "Fiction", true);
        lib.addFirst(2, "1984", "George Orwell", "Dystopian", true);
        lib.addAt(3, "To Kill a Mockingbird", "Harper Lee", "Classic", false, 2);
        lib.addLast(4, "The Great Gatsby", "F. Scott Fitzgerald", "Novel", true);
        lib.displayForward();
        lib.updateAvailability(1, false);
        lib.removeById(2);
    }
}
