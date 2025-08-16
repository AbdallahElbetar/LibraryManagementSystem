package com.library.services;

import com.library.model.Book;
import com.library.model.User;
import java.util.ArrayList;

public class Librarian {
    private String name; // Encapsulation
    private int id;
    private Library lib; // Aggregation

    // Constructor: Initialize name, id, and library
    public Librarian(String name, int id, Library lib) {
        this.name = name;
        this.id = id;
        this.lib = lib;
    }

    // Getters
    public String getName() { return name; }
    public int getId() { return id; }

    // Add a user to the library
    public void addUser(User user) {

            lib.getUsers().add(user);

            System.out.println("User added by Librarian: " + user);
    }

    // Delete a user from the library
    public void deleteUser(User user) {
        if (lib.getUsers().remove(user)) {
            System.out.println("User removed by Librarian: " + user);
        } else {
            System.out.println("User not found.");
        }
    }

    // Add single book
    public void addBook(Book book) {
        if (lib.searchBook(book.getTitle()) == null) {
            lib.getBooks().add(book);
            System.out.println("Added by Librarian: " + book);
        } else {
            System.out.println("Book with title " + book.getTitle() + " already exists.");
        }
    }

    // Add multiple books (Overloading)
    public void addBook(Book... books) {
        for (Book b : books) {
            addBook(b);
        }
    }

    // Remove book
    public void removeBook(Book book) {
        if (lib.getBooks().remove(book)) {
            System.out.println("Removed by Librarian: " + book);
        } else {
            System.out.println("Book not found.");
        }
    }

    // Print summary report
    public void printReport() {
        System.out.println("Library Report by Librarian:");
        System.out.println("Total Books Created: " + Book.getTotalBooks());
        System.out.println("Books in Library: " + lib.getBooks().size());
        System.out.println("Registered Users: " + lib.getUsers().size());
    }

    // Inner Class (بديل Friend Function)
    public class ReportGenerator {
        public void detailedReport() {
            System.out.println("Detailed Report by Librarian:");
            lib.displayBooks();
            lib.displayUsers();
        }
    }
}