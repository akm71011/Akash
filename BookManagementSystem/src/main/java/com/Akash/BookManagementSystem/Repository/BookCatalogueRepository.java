package com.Akash.BookManagementSystem.Repository;

import com.Akash.BookManagementSystem.Model.BookCatalogue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class BookCatalogueRepository {
    Logger logger = Logger.getLogger(BookCatalogueRepository.class.getName());

    private String FETCH_BOOK_BY_ID = "SELECT * FROM book_catalog WHERE book_id = ?";
    private String INSERT_BOOK = "INSERT INTO book_catalog (title, genre, author, published_year, stock,price) VALUES (?, ?, ?, ?, ? , ?)";
    private String UPDATE_BOOK = "UPDATE book_catalog set stock = ? where book_id = ?";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public BookCatalogue getBookById(int bookId) {
        logger.info("Fetching book with id");
        return this.jdbcTemplate.queryForObject(FETCH_BOOK_BY_ID, new Object[]{bookId}, new BeanPropertyRowMapper<>(BookCatalogue.class));
    }

    public void addBook(BookCatalogue book) {
        //logger.info("Fetching book with id");
        this.jdbcTemplate.update(INSERT_BOOK,book.getTitle(),book.getGenre(), book.getAuthor(), book.getPublishedYear(), book.getStock(),book.getPrice());

    }

    public void updateBookStock(BookCatalogue bookCatalogue) {
        logger.info("Updating book stock");
        this.jdbcTemplate.update(UPDATE_BOOK, bookCatalogue.getStock(), bookCatalogue.getBookId());
    }
}



