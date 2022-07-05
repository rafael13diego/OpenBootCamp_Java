package com.example.restdatajpa.controllers;

import com.example.restdatajpa.models.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate restTemplate;
    @Autowired
    private RestTemplateBuilder builder;

    @LocalServerPort
    private int port;

    //setUp antes de cada método
    //beforeClass antes de ejecutar toda la clase
    @BeforeEach
    void setUp() {
        builder = builder.rootUri("http://localhost:"+port);
        restTemplate = new TestRestTemplate(builder);
    }

    @Test
    void hello() {

        ResponseEntity<String> response = restTemplate.getForEntity("/hello", String.class);
        System.out.println(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(200, response.getStatusCode().value());
    }

    @Test
    void findAll() {
        ResponseEntity<Book[]> response =
                restTemplate.getForEntity("/books", Book[].class);
        List<Book> books =Arrays.asList(response.getBody());
        System.out.println(books.size());
        //assertTrue();


    }

    @Test
    void findOneById() {

        ResponseEntity<Book> response = restTemplate.getForEntity("/books/1", Book.class);
        //System.out.println(response.getBody());
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    void save() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }


}