package models;

import java.sql.Date;

public class IssuedBook {
    private int issueId;
    private int bookId;
    private int userId;
    private Date issueDate;
    private Date returnDate;

    // Constructor with all fields
    public IssuedBook(int issueId, int bookId, int userId, Date issueDate, Date returnDate) {
        this.issueId = issueId;
        this.bookId = bookId;
        this.userId = userId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
    }

    // Getters
    public int getIssueId() {
        return issueId;
    }

    public int getBookId() {
        return bookId;
    }

    public int getUserId() {
        return userId;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    // Setters
    public void setIssueId(int issueId) {
        this.issueId = issueId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setIssueDate(Date issueDate) {
        this.issueDate = issueDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    // Optional: toString for logging/debugging
    @Override
    public String toString() {
        return "IssuedBook{" +
                "issueId=" + issueId +
                ", bookId=" + bookId +
                ", userId=" + userId +
                ", issueDate=" + issueDate +
                ", returnDate=" + returnDate +
                '}';
    }
}
