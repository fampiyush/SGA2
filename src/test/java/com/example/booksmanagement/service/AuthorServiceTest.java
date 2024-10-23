package com.example.booksmanagement.service;

import com.example.booksmanagement.dao.AuthorRepo;
import com.example.booksmanagement.entity.Author;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class AuthorServiceTest {

    @Mock
    private AuthorRepo authorRepo;

    @InjectMocks
    private AuthorService authorService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetOrCreateAuthor_AuthorExists() {
        Author author = new Author("Harper Lee");
        when(authorRepo.findByNameIgnoreCase("Harper Lee")).thenReturn(author);

        Author result = authorService.getOrCreateAuthor("Harper Lee");

        assertThat(result).isEqualTo(author);
        verify(authorRepo, never()).save(any(Author.class));
    }

    @Test
    public void testGetOrCreateAuthor_AuthorDoesNotExist() {
        when(authorRepo.findByNameIgnoreCase("Harper Lee")).thenReturn(null);
        Author newAuthor = new Author("Harper Lee");
        when(authorRepo.save(any(Author.class))).thenReturn(newAuthor);

        Author result = authorService.getOrCreateAuthor("Harper Lee");

        assertThat(result.getName()).isEqualTo("Harper Lee");
        verify(authorRepo).save(any(Author.class));
    }

    @Test
    public void testGetAllAuthors() {
        Author author1 = new Author("Harper Lee");
        Author author2 = new Author("George Orwell");
        List<Author> authors = Arrays.asList(author1, author2);
        when(authorRepo.findAll()).thenReturn(authors);

        List<Author> result = authorService.getAllAuthors();

        assertThat(result).isEqualTo(authors);
    }

    @Test
    public void testDeleteAuthor() {
        Author author = new Author("Harper Lee");
        doNothing().when(authorRepo).delete(author);

        authorService.deleteAuthor(author);

        verify(authorRepo).delete(author);
    }

    @Test
    public void testGetAuthorById() {
        Author author = new Author("Harper Lee");
        when(authorRepo.findById(1)).thenReturn(Optional.of(author));

        Author result = authorService.getAuthorById(1);

        assertThat(result).isEqualTo(author);
    }

    @Test
    public void testGetAuthorById_NotFound() {
        when(authorRepo.findById(1)).thenReturn(Optional.empty());

        Author result = authorService.getAuthorById(1);

        assertThat(result).isNull();
    }
}