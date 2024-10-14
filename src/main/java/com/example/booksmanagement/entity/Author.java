package com.example.booksmanagement.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int author_id;
    private String name;

    public Author() {
    }

    public Author(String name) {
        this.name = name;
    }

    public int getId() {
        return author_id;
    }

    public void setId(int author_id) {
        this.author_id = author_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
