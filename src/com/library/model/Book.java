package com.library.model;

public class Book   {
    // Encapsulation: private fields
    private String title;
    private String author;
    private boolean available;
    private static int totalBooks = 0; // Static: shared across all objects

    // Constructor: initializes object
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.available = true; // Default: available
        totalBooks++; // Increment static counter
    }

    // Getters (Encapsulation: read access)
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }

    // Setter (Encapsulation: controlled write access)
    public void setAvailable(boolean available) { this.available = available; }

    // Static Method: access static field
    public static int getTotalBooks() { return totalBooks; }

//     Polymorphism: Override toString() from Object
    @Override
    public String toString() {
        return "Book: " + title + ", Author: " + author + ", Available: " + available;
    }

}