package com.example.restdatajpa.services;

import com.example.restdatajpa.models.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BookPriceCalculatorTest {


    @Test
    void calculatorPrice() {
        Book book = new Book(null,"Angelss&Demons","Dan Brown",400,50.00,
                LocalDate.of(1990,12,15), true);
        BookPriceCalculator calculator = new BookPriceCalculator();
        double price = calculator.calculatorPrice(book);
        System.out.println(price);
        assertTrue(price> 50);
        assertEquals(65,price);
    }
}