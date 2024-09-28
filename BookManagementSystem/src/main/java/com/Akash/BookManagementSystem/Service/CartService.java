package com.Akash.BookManagementSystem.Service;

import com.Akash.BookManagementSystem.Model.BookCart;
import com.Akash.BookManagementSystem.Model.BookCartRequest;
import com.Akash.BookManagementSystem.Model.BookCatalogue;
import com.Akash.BookManagementSystem.Repository.BookCartServiceRepository;
import com.Akash.BookManagementSystem.Repository.BookCatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;

@Service
public class CartService {

    Logger logger = Logger.getLogger(CartService.class.getName());

    @Autowired
    BookCatalogueRepository bookCatalogueRepository;

    @Autowired
    BookCartServiceRepository bookCartServiceRepository;

    public String addToCart(BookCartRequest bookCartRequest){


        logger.info("Finding the book from the server end");
        BookCatalogue  bookFound = bookCatalogueRepository.getBookById(bookCartRequest.getBookId());
        if(bookFound == null) {
            logger.info("Book not found");
            return "Book not found";
        }
        else
        {
            logger.info("Book found");
            BookCart bookCart = new BookCart();
            if(bookCartRequest.getQuantity() <=bookFound.getStock()) {
                logger.info("Book is available");
//                bookCart.setPrice(bookCartRequest.getQuantity() * bookFound.getPrice());
//                bookCart.setBookId(bookFound.getBookId());
//                bookCart.setQuantity(bookCartRequest.getQuantity());
//                bookCart.setUserId(bookCartRequest.getUserId());
                bookCartServiceRepository.addToCart(bookCart);
                bookFound.setStock(bookFound.getStock() - bookCartRequest.getQuantity());
//                logger.info("Updating the stock of the book");
//                //bookCatalogueRepository.updateBookStock(bookFound);
//                logger.info("Book stock updated");
//                return "Book added to cart";
            }
            else
                logger.info("Book is not available");
            return "Book is out of stock" ;
        }

    }
}
