package dao;

import db.DBConnection;
import models.IssuedBook;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IssuedBookDAO {

    public void issueBook(IssuedBook book) {
        String sql = "INSERT INTO issued_books (book_id, user_id, issue_date, return_date) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, book.getBookId());
            stmt.setInt(2, book.getUserId());
            stmt.setDate(3, book.getIssueDate());
            stmt.setDate(4, book.getReturnDate());
            stmt.executeUpdate();
            System.out.println("📕 Book issued.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<IssuedBook> getAllIssuedBooks() {
        List<IssuedBook> issuedBooks = new ArrayList<>();
        String sql = "SELECT * FROM issued_books";
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                issuedBooks.add(new IssuedBook(
                        rs.getInt("issue_id"),
                        rs.getInt("book_id"),
                        rs.getInt("user_id"),
                        rs.getDate("issue_date"),
                        rs.getDate("return_date")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return issuedBooks;
    }
}
