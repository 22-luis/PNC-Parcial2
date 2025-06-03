package com.example.demo1.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;

@AllArgsConstructor
@Data
public class BookDto {

    private UUID id;
    private String title;
    private String author;
    private String isbn;
    private Integer publicationYear;
    private String language;
    private Integer pages;
    private String genre;
}
