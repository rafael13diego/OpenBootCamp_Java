package com.example.restdatajpa.services;

import com.example.restdatajpa.models.Book;

public class BookPriceCalculator {


    public double calculatorPrice(Book book){
        double price = book.getPrice();

        if (book.getPages() > 300){
            price +=5;
        }
        //envio
        price += 10;
        return price;
    }
}