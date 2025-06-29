package kg.attractor.java.server.models;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class User {
    private static List<User> users = new ArrayList<>();

    private Long id;
    @Expose
    private String firstName;
    @Expose
    private String lastName;
    @Expose
    private String email;
    private String password;
    private BorrowedBooks borrowedBooks;

    public User(String firstName, String lastName, String email, String password, BorrowedBooks borrowedBooks) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.borrowedBooks = borrowedBooks;
    }

    public User() {
    }

    public static List<User> getUsers() {
        return users;
    }

    public static void setUsers(List<User> users) {
        User.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BorrowedBooks getBorrowedBooks() {
        return borrowedBooks;
    }

    public void setBorrowedBooks(BorrowedBooks borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return email != null && email.equals(user.email);
    }

    @Override
    public int hashCode() {
        return email != null ? email.hashCode() : 0;
    }

}
