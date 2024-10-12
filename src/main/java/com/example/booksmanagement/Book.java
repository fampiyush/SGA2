package com.example.booksmanagement;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int book_id;
    private String title;
    @ManyToMany
    @JoinColumn(name = "author_id")
    private List<Author> author;
    @ManyToOne
    private Category category;
    private int year;

    public Book() {
    }

    public Book(String title, List<Author> author, Category category, int year) {
        this.title = title;
        this.author = author;
        this.category = category;
        this.year = year;
    }

    public int getId() {
        return book_id;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public Category getCategory() {
        return category;
    }

    public int getYear() {
        return year;
    }

    public void setId(int book_id) {
        this.book_id = book_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
