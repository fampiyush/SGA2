package com.example.booksmanagement.service;

import com.example.booksmanagement.entity.Book;
import com.example.booksmanagement.dao.BookRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

public class BookServiceTest {

    @Mock
    private BookRepo bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllBooks() {
        Book book1 = new Book("To Kill a Mockingbird", null, 1960);
        Book book2 = new Book("1984", null, 1949);
        List<Book> books = Arrays.asList(book1, book2);

        when(bookRepository.findAll()).thenReturn(books);

        List<Book> result = bookService.getAllBooks();
        assertThat(result).isEqualTo(books);
    }

    @Test
    public void testGetBookById() {
        Book book = new Book("To Kill a Mockingbird", null, 1960);

        when(bookRepository.findById(1)).thenReturn(java.util.Optional.of(book));

        Book result = bookService.getBookById(1);
        assertThat(result).isEqualTo(book);
    }
}