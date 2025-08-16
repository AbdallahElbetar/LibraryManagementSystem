package com.library.model;

public class Teacher extends User {
    public Teacher(String name, int id) {
        super(name, id);
    }

    @Override
    public void borrow(Book book) {
        if (book.isAvailable()) {
            book.setAvailable(false);
            System.out.println(getName() + " (Teacher) borrowed " + book.getTitle() + " (extended period)");
        } else {
            System.out.println("Book not available");
        }
    }

    @Override
    public void returnBook(Book book) {
        book.setAvailable(true);
        System.out.println(getName() + " (Teacher) returned " + book.getTitle());
    }

    @Override
    public void displayInfo() {
        System.out.println("Teacher: " + getName() + ", ID: " + getId());
    }
}