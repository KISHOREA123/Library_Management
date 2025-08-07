package main;

import dao.BookDAO;
import models.Book;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BookDAO bookDAO = new BookDAO();

        while (true) {
            System.out.println("\n📘 Library Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. View Books");
            System.out.println("0. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = sc.nextLine();
                    System.out.print("Author: ");
                    String author = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    bookDAO.addBook(new Book(title, author, qty));
                    break;
                case 2:
                    for (Book b : bookDAO.getAllBooks()) {
                        System.out.println(b.getBookId() + " | " + b.getTitle() + " | " + b.getAuthor() + " | " + b.getQuantity());
                    }
                    break;
                case 0:
                    System.out.println("👋 Bye!");
                    return;
                default:
                    System.out.println("❌ Invalid choice!");
            }
        }
    }
}
