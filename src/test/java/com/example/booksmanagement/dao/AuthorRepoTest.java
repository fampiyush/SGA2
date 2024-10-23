package com.example.booksmanagement.dao;

import com.example.booksmanagement.entity.Author;
import com.example.booksmanagement.service.AuthorService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AuthorRepoTest {

    @Mock
    private AuthorRepo authorRepository;

    @InjectMocks
    private AuthorService authorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAll() {
        Author author1 = new Author("Harper Lee");
        Author author2 = new Author("George Orwell");
        List<Author> authors = Arrays.asList(author1, author2);

        when(authorRepository.findAll()).thenReturn(authors);

        List<Author> result = authorService.getAllAuthors();
        assertThat(result).isEqualTo(authors);
    }

    @Test
    public void testFindById() {
        Author author = new Author("Harper Lee");

        when(authorRepository.findById(1)).thenReturn(java.util.Optional.of(author));

        Author result = authorService.getAuthorById(1);
        assertThat(result).isEqualTo(author);
    }
}