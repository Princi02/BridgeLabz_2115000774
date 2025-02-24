package Reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.AnnotatedElement;

@Retention(RetentionPolicy.RUNTIME)
@interface Author {
    String name();
}

@Author(name = "Priyanshi")
class Book {
    void display() {
        System.out.println("Book class method");
    }
}

public class RetrieveAnnotations {
    public static void main(String[] args) {
        Class<Book> bookClass = Book.class;
        if (bookClass.isAnnotationPresent(Author.class)) {
            Author author = bookClass.getAnnotation(Author.class);
            System.out.println("Author: " + author.name());
        }
    }
}

