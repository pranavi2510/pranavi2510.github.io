package com.cloudthat.librarymanagement;
import com.cloudthat.librarymanagement.exceptions.BookAlreadyExistsException;

public class Main {
    public static void main(String[] args) throws BookAlreadyExistsException {

        System.out.println("Welcome to Library Management System");
        try {
            Library library = new Library();
            library.addBook(new Book("Into to Java", "1234567", "James Gosling"));

            library.addBook(new Book("Into to Javascript", "123456", "James"));
            library.removeBook("12345");
            library.addBook(new Book("Into to Java", "1234567", "James Gosling"));
        } catch (BookAlreadyExistsException e){
            System.out.println("Book Already Exists");
        }
    }
}
