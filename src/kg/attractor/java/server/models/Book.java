package kg.attractor.java.server.models;

import kg.attractor.java.lesson44.SampleDataModel;

import java.time.LocalDate;

public class Book {
    private String name;
    private String author;
    private String description;
    private LocalDate releaseYear;
    private SampleDataModel.User borrowedBy;

    public SampleDataModel.User getBorrowedBy() {
        return borrowedBy;
    }

    public void setBorrowedBy(SampleDataModel.User borrowedBy) {
        this.borrowedBy = borrowedBy;
    }

    public LocalDate getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(LocalDate releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
