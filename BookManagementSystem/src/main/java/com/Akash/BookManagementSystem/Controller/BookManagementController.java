package com.Akash.BookManagementSystem.Controller;

import com.Akash.BookManagementSystem.Model.BookCatalogue;
import com.Akash.BookManagementSystem.Repository.BookCatalogueRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping(value="/store")
public class BookManagementController {

    Logger logger = Logger.getLogger(BookManagementController.class.getName());
    @Autowired
    BookCatalogueRepository bookCatalogueRepository;


    @GetMapping(value = "/view")
    public String viewBook() {
        return "View Book";
    }

    @GetMapping(value = "/show/{BookId}")
    public BookCatalogue showBook(@PathVariable("BookId") Integer id) {
        logger.info("Finding Books");
      BookCatalogue found = bookCatalogueRepository.getBookById(id);
       return found;

    }

    @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addBook(@RequestBody BookCatalogue book) {
        logger.info("Adding Books");
        bookCatalogueRepository.addBook(book);
        return "Book Added";
    }
}
