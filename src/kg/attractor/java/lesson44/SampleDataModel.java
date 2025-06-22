package kg.attractor.java.lesson44;

import kg.attractor.java.server.models.BorrowedBooks;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SampleDataModel {
    private User user = new User("Apache", "FreeMarker");
    private LocalDateTime currentDateTime = LocalDateTime.now();
    private List<User> customers = new ArrayList<>();

    public SampleDataModel() {
        customers.add(new User("Marco"));
        customers.add(new User("Winston", "Duarte"));
        customers.add(new User("Amos", "Burton", "'Timmy'"));
        customers.get(1).setEmailConfirmed(true);
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getCurrentDateTime() {
        return currentDateTime;
    }

    public void setCurrentDateTime(LocalDateTime currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public List<User> getCustomers() {
        return customers;
    }

    public void setCustomers(List<User> customers) {
        this.customers = customers;
    }

    public static class User {
        private String firstName;
        private String lastName;
        private String middleName = null;
        private boolean emailConfirmed = false;
        private String email;
        private BorrowedBooks borrowedBooks;

        public User(String firstName) {
            this(firstName, null, null);
        }

        public User(String firstName, String lastName) {
            this(firstName, lastName, null);
        }

        public User(String firstName, String lastName, String middleName) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.middleName = middleName;
            this.email = firstName+"@test.mail";
        }

        public BorrowedBooks getBorrowedBooks() {
            return borrowedBooks;
        }

        public void setBorrowedBooks(BorrowedBooks borrowedBooks) {
            this.borrowedBooks = borrowedBooks;
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

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public boolean isEmailConfirmed() {
            return emailConfirmed;
        }

        public void setEmailConfirmed(boolean emailConfirmed) {
            this.emailConfirmed = emailConfirmed;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
