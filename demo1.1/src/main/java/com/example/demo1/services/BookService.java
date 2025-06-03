package com.example.demo1.services;

import com.example.demo1.entities.Book;
import com.example.demo1.entities.dto.BookDto;
import com.example.demo1.repositories.BookRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@NoArgsConstructor
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public void createBook(BookDto bookInfo) {
        Book book = new Book();
        book.setTitle(bookInfo.getTitle());
        book.setAuthor(bookInfo.getAuthor());
        book.setIsbn(bookInfo.getIsbn());
        book.setGenre(bookInfo.getGenre());
        book.setPages(bookInfo.getPages());
        book.setLanguage(bookInfo.getLanguage());
        book.setPublicationYear(bookInfo.getPublicationYear());
        bookRepository.save(book);
    }

    public void deleteBook(UUID id) {
        bookRepository.deleteById(id);
    }

    public List<BookDto> getByAuthor(String author) {
        List<BookDto> response = new ArrayList<>();
        List<Book> optionalBook = bookRepository.findByAuthor(author);
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("Author not found");
        }
        optionalBook.forEach(book -> {
            response.add(new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublicationYear(), book.getLanguage(), book.getPages(), book.getGenre()));
        });
        return response;
    }

    public List<BookDto> getByLanguage(String language) {
        List<BookDto> response = new ArrayList<>();
        List<Book> optionalBook = bookRepository.findByLanguage(language);
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("Language not found");
        }
        optionalBook.forEach(book -> {
            response.add(new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublicationYear(), book.getLanguage(), book.getPages(), book.getGenre()));
        });
        return response;
    }

    public List<BookDto> getByGenre(String genre) {
        List<BookDto> response = new ArrayList<>();
        List<Book> optionalBook = bookRepository.findByGenre(genre);
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("Genre not found");
        }
        optionalBook.forEach(book -> {
            response.add(new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublicationYear(), book.getLanguage(), book.getPages(), book.getGenre()));
        });
        return response;
    }

    public List<BookDto> getByIsbn(String isbn) {
        List<BookDto> response = new ArrayList<>();
        List<Book> optionalBook = bookRepository.findByIsbn(isbn);
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("Genre not found");
        }
        optionalBook.forEach(book -> {
            response.add(new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublicationYear(), book.getLanguage(), book.getPages(), book.getGenre()));
        });
        return response;
    }

    public List<BookDto> getByPages(Integer min) {
        List<BookDto> response = new ArrayList<>();
        List<Book> optionalBook = bookRepository.findByPages(min);
        if (optionalBook.isEmpty()) {
            throw new RuntimeException("Genre not found");
        }
        optionalBook.forEach(book -> {
            response.add(new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublicationYear(), book.getLanguage(), book.getPages(), book.getGenre()));
        });
        return response;
    }


    public BookDto putTitle(BookDto book) {
        BookDto response = BookRepository.finById(book.getId());
        if (response == null) {
            throw new RuntimeException("Book not found");
        }
        book.setTitle(response.getTitle());
        book.setLanguage(response.getLanguage());
        return response;
    }
}
