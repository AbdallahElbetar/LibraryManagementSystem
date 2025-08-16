package com.library.model;

public interface Borrowable {
    void borrow(Book book); // Abstract method
    void returnBook(Book book); // Abstract method
}