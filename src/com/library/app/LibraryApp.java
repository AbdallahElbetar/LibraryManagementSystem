
package com.library.app;

import com.library.model.*; import com.library.services.*; import java.util.ArrayList; import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library lib = new Library();
        Librarian librarian = new Librarian("Admin", 0, lib);

        // Add sample data
         Book book1 = new Book("Java OOP", "John Doe");
        Book book2 = new Book("Python Basics", "Jane Smith");
        librarian.addBook(book1, book2);
        librarian.addUser(new Student("Ali", 1));
        librarian.addUser(new Teacher("Ahmed", 2));

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\\n1. Add Book\\n2. Remove Book\\n3. Add User\\n4. Remove User\\n5. Borrow\\n6. Return\\n7. Display Books\\n8. Display Users\\n9. Report\\n10. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                System.out.print("Title: ");
                String title = scanner.nextLine();
                System.out.print("Author: ");
                String author = scanner.nextLine();
                librarian.addBook(new Book(title, author));
            } else if (choice == 2) {
                System.out.print("Book Title: ");
                String title = scanner.nextLine();
                Book book = lib.searchBook(title);
                if (book != null) {
                    librarian.removeBook(book);
                } else {
                    System.out.println("Book not found");
                }
            } else if (choice == 3) {
                System.out.print("User Name: ");
                String name = scanner.nextLine();
                System.out.print("User ID: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                System.out.print("User Type (1=Student, 2=Teacher): ");
                int type = scanner.nextInt();
                scanner.nextLine();
                User user = type == 1 ? new Student(name, id) : new Teacher(name, id);
                librarian.addUser(user);
            } else if (choice == 4) {
                System.out.print("User Name: ");
                String name = scanner.nextLine();
                User user = findUser(lib.getUsers(), name);
                if (user != null) {
                    librarian.deleteUser(user);
                } else {
                    System.out.println("User not found");
                }
            } else if (choice == 5) {
                System.out.print("User Name: ");
                String name = scanner.nextLine();
                System.out.print("Book Title: ");
                String title = scanner.nextLine();
                User user = findUser(lib.getUsers(), name);
                Book book = lib.searchBook(title);
                if (user != null && book != null) {
                    user.borrow(book);
                } else {
                    System.out.println("User or Book not found");
                }
            } else if (choice == 6) {
                System.out.print("User Name: ");
                String name = scanner.nextLine();
                System.out.print("Book Title: ");
                String title = scanner.nextLine();
                User user = findUser(lib.getUsers(), name);
                Book book = lib.searchBook(title);
                if (user != null && book != null) {
                    user.returnBook(book);
                } else {
                    System.out.println("User or Book not found");
                }
            } else if (choice == 7) {
                lib.displayBooks();
            } else if (choice == 8) {
                lib.displayUsers();
            } else if (choice == 9) {
                librarian.printReport();
                Librarian.ReportGenerator generator = librarian.new ReportGenerator();
                generator.detailedReport();
            } else if (choice == 10) {
                break;
            } else {
                System.out.println("Invalid choice");
            }
        }
        scanner.close();
    }


    private static User findUser(ArrayList<User> users, String name) {
        for (User u : users) {
            if (u.getName().equalsIgnoreCase(name)) {
                return u;
            }
        }
        return null;
    }
}