package com.cloudthat.librarymanagement;

import com.cloudthat.librarymanagement.exceptions.BookAlreadyExistsException;
import com.cloudthat.librarymanagement.exceptions.BookNotFoundException;

import java.util.HashMap;
import java.util.Map;
import java.util.HashSet;
import java.util.Set;

public class Library {
    private Map<String, Book> books;
    private Set<String> bookIsbns;

    public Library() {

        books = new HashMap<>();
        bookIsbns = new HashSet<>();
    }

    public void addBook(Book book) throws BookAlreadyExistsException{

        if(!bookIsbns.contains(book.getIsbn())){
            books.put(book.getIsbn(), book);
            bookIsbns.add(book.getIsbn());
        } else{
//            System.out.println("Duplicate book found");
            throw new BookAlreadyExistsException("Book with ISBN"+book.getIsbn()+"already exists");
        }


    }
    public void removeBook(String isbn){
        if(books.containsKey(isbn)){
            Book removedBook = books.remove(isbn);
            System.out.println("Removed: "+removedBook);
        }
        else{
            System.out.println("No book with ISBN: "+isbn);
        }
    }
}

