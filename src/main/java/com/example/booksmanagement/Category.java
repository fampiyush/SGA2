package com.example.booksmanagement;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    private String category_id;
    private String name;

    public Category() {
    }

    public String getId() {
        return category_id;
    }

    public void setId(String category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
