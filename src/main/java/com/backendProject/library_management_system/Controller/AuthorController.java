package com.backendProject.library_management_system.Controller;


import com.backendProject.library_management_system.Entity.Author;
import com.backendProject.library_management_system.Service.AuthorService;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public String addAuthor(@RequestBody Author author){
        authorService.addAuthor(author);
        return "Author added successively";
    }

    @GetMapping("/get_authors")
    public List<Author> getAuthors(){
        return authorService.getAuthors();
    }


    @GetMapping("/getAuthorById")
    public Author getAuthorById(@RequestParam("id") Integer id){
        return authorService.getAuthorById(id);
    }
}
