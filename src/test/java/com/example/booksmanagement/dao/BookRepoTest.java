package com.example.booksmanagement.dao;

import com.example.booksmanagement.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class BookRepoTest {

    @Autowired
    private BookRepo bookRepository;

    @Test
    public void testFindAll() {
        List<Book> books = bookRepository.findAll();
        assertThat(books).isNotEmpty();
    }

    @Test
    public void testFindById() {
        Book book = bookRepository.findById(1).orElse(null);
        assertThat(book).isNotNull();
        assertThat(book.getTitle()).isEqualTo("To Kill a Mockingbird");
    }
}