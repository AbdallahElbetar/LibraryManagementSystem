package com.library.model;

public class Student  extends  User{


    public Student(String name, int id) {
        super(name, id);
    }

    @Override
    public void displayInfo() {
        System.out.println("Student: " + getName() + ", ID: " + getId());

    }

    @Override
    public void borrow(Book book) {
        if(book.isAvailable()){
            book.setAvailable(false);
            System.out.println(getName() + " (Student) borrowed " + book.getTitle());
        }
        else{
            System.out.println("Book not available");
        }

    }

    @Override
    public void returnBook(Book book) {

        book.setAvailable(true);
        System.out.println(getName() + " (Student) returned " + book.getTitle());


    }
}
