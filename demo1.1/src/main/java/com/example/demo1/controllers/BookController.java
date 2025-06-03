package com.example.demo1.controllers;

import com.example.demo1.entities.Book;
import com.example.demo1.entities.dto.BookDto;
import com.example.demo1.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    private Pattern UUID_REGEX =
            Pattern.compile("^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$");

    @PostMapping("/book/add")
    public ResponseEntity<Book> addBook(@RequestBody BookDto book) {
        try {
            bookService.createBook(book);
            return ResponseEntity.ok().build();
        } catch (Exception e){
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/books/delete/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable UUID id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/books?author={author}")
    public ResponseEntity<List<BookDto>> getBookByAuthor(@RequestParam("author") String author) {
        return ResponseEntity.ok(bookService.getByAuthor(author));
    }

    @GetMapping("/books?language={language}")
    public ResponseEntity<List<BookDto>> getBookByLanguage(@RequestParam("language") String language) {
        return ResponseEntity.ok(bookService.getByLanguage(language));
    }

    @GetMapping("/books?genre={genre}")
    public ResponseEntity<List<BookDto>> getBookByGenre(@RequestParam("genre") String genre) {
        return ResponseEntity.ok(bookService.getByLanguage(genre));
    }

    @GetMapping("/books/{isbn}")
    public ResponseEntity<List<BookDto>> getBookByIsbn(@RequestParam("isbn") String isbn) {
        return ResponseEntity.ok(bookService.getByLanguage(isbn));
    }

    @GetMapping("/books?minPages={min}")
    public ResponseEntity<List<BookDto>> getBookByPages(@RequestParam("min") Integer min) {
        return ResponseEntity.ok(bookService.getByPages(min));
    }

    @PutMapping("book/update/{id}")
    public ResponseEntity<BookDto> updateBook(@PathVariable("id") Integer id, @RequestBody BookDto book) {
        return ResponseEntity.ok(bookService.putTitle(book));
    }

}
