package com.library.services;
import com.library.model.*;
import java.util.ArrayList;

public class Library {
    // Composition && Encapsulation
    private  ArrayList<Book> books= new ArrayList<>();



    private ArrayList<User> users = new ArrayList<>(); // Aggregation

    // Getters (Encapsulation)
    public ArrayList<Book> getBooks() { return books; }
    public ArrayList<User> getUsers() { return users; }

    // Search for a book by title
    public Book searchBook(String title) {
        for (Book b : books) {
            if (b.getTitle().equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    // Display all books
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in Library:");
            for (Book b : books) {
                System.out.println(b);
            }
        }
    }

    // Display all users
    public void displayUsers() {
        if (users.isEmpty()) {
            System.out.println("No users registered.");
        } else {
            System.out.println("Registered Users:");
            for (User u : users) {
                u.displayInfo();
            }
        }
    }
}