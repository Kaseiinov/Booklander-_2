package kg.attractor.java.server.models;

import com.google.gson.annotations.Expose;
import kg.attractor.java.lesson44.SampleDataModel;

import java.time.LocalDate;

public class Book {
    @Expose
    private Long id;
    @Expose
    private String name;
    @Expose
    private String author;
    @Expose
    private String description;
    @Expose
    private LocalDate releaseYear;
    @Expose
    private SampleDataModel.User borrowedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
