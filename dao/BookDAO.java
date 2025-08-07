package dao;

import db.DBConnection;
import models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    // Add a new book
    public void addBook(Book book) {
        String sql = "INSERT INTO books (title, author, quantity) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setInt(3, book.getQuantity());
            stmt.executeUpdate();
            System.out.println("✅ Book added.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get all books
    public List<Book> getAllBooks() {
        List<Book> list = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM books")) {
            while (rs.next()) {
                list.add(new Book(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("quantity")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    // Update book quantity
    public void updateBookQuantity(int bookId, int newQuantity) {
        String sql = "UPDATE books SET quantity = ? WHERE book_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, newQuantity);
            stmt.setInt(2, bookId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("🔁 Quantity updated for book ID " + bookId);
            } else {
                System.out.println("⚠️ Book not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Delete a book
    public void deleteBook(int bookId) {
        String sql = "DELETE FROM books WHERE book_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bookId);
            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("🗑️ Book deleted with ID: " + bookId);
            } else {
                System.out.println("⚠️ Book not found!");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get a single book by ID
    public Book getBookById(int bookId) {
        String sql = "SELECT * FROM books WHERE book_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, bookId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Book(
                        rs.getInt("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getInt("quantity")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null; // Not found
    }
}
