package com.example.demo1.repositories;

import com.example.demo1.entities.Book;
import com.example.demo1.entities.dto.BookDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book, UUID> {

    public static BookDto finById(UUID id) {
        return null;
    }
    public List<Book> findByAuthor(String author);
    public List<Book> findByLanguage(String language);
    public List<Book> findByGenre(String genre);
    public List<Book> findByIsbn(String isbn);
    public List<Book> findByPages(Integer min);




}
