package kg.attractor.java.server.models;

import java.time.LocalDate;
import java.util.List;

public class BorrowedBooks {
    private List<Book> borrowedBooks;
    private LocalDate borrowedDate;
    private LocalDate returnDate;

    public BorrowedBooks(List<Book> borrowedBooks, LocalDate borrowedDate, LocalDate returnDate) {
        this.borrowedBooks = borrowedBooks;
        this.borrowedDate = borrowedDate;
        this.returnDate = returnDate;
    }

    public String addBorrowBook(Book book) {
        if(borrowedBooks.size() >= 2) {
            return "Can't borrow more than two books";
        } else if (borrowedBooks.contains(book) ) {
            return "Book already added";
        }

        borrowedBooks.add(book);
        return "Book added";

    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(List<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    public LocalDate getBorrowedDate() {
        return borrowedDate;
    }

    public void setBorrowedDate(LocalDate borrowedDate) {
        this.borrowedDate = borrowedDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
