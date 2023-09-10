package com.backendProject.library_management_system.Controller;


import com.backendProject.library_management_system.DTO.BookRequestDto;
import com.backendProject.library_management_system.DTO.BookResponseDto;
import com.backendProject.library_management_system.Entity.Author;
import com.backendProject.library_management_system.Entity.Book;
import com.backendProject.library_management_system.Repository.AuthorRepository;
import com.backendProject.library_management_system.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public BookResponseDto addBook(@RequestBody BookRequestDto bookRequestDto) throws Exception {
        return bookService.addBook(bookRequestDto);
    }
}
