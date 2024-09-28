package com.Akash.BookManagementSystem.Repository;

import com.Akash.BookManagementSystem.Model.BookCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class BookCartServiceRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    Logger logger = Logger.getLogger(BookCartServiceRepository.class.getName());

    private String INSERT_BOOK_INTO_CART = "INSERT INTO cart (user_id , book_id, quantity,price) VALUES (?,?,?, ?)";

    public void addToCart(BookCart bookCart) {
        logger.info("Adding book to cart");
        this.jdbcTemplate.update(INSERT_BOOK_INTO_CART, bookCart.getUserId(), bookCart.getBookId(), bookCart.getQuantity(), bookCart.getPrice());
    }
}
