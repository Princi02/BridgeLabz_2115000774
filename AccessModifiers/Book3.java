package AccessModifiers;
class Book {
    public String ISBN;
    protected String title;
    private String author;

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return this.author;
    }
}


class EBook extends Book {

    public void displayInfo() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + getAuthor());
    }
}

public class Book3 {
    public static void main(String[] args) {
        EBook ebook = new EBook();
        ebook.ISBN = "123-456-789";
        ebook.title = "Java Programming";
        ebook.setAuthor("James Gosling");
        ebook.displayInfo();
    }
}

