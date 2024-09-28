package com.Akash.BookManagementSystem.Controller;

import com.Akash.BookManagementSystem.Model.BookCartRequest;
import com.Akash.BookManagementSystem.Service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
@RequestMapping(value="/cart")
public class CartServiceController {

    Logger logger= Logger.getLogger(CartServiceController.class.getName());

    @Autowired
    CartService cartService;

    @PostMapping(value = "/addToCart", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String addToCartService(@RequestBody BookCartRequest bookCart) {
        logger.info("Requesting cart entry");
         return  cartService.addToCart(bookCart);
    }
}
