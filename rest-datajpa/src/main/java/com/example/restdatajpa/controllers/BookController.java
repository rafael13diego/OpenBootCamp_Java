package com.example.restdatajpa.controllers;

import com.example.restdatajpa.models.Book;
import com.example.restdatajpa.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
@AllArgsConstructor
public class BookController {

    private final BookRepository repository;

    @GetMapping
    public List<Book> findAll(){
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findOneById(@PathVariable Long id){
        Optional<Book> bookOpt = repository.findById(id);
        return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Book> save(@RequestBody Book book){
        return ResponseEntity.ok(repository.save(book));
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Book> update(@RequestBody Book book){
        if (book.getId() ==null){
            return ResponseEntity.badRequest().build();
        }
        if (!repository.existsById(book.getId())){
            return ResponseEntity.notFound().build();
        }
        var newBook = repository.save(book);
        return ResponseEntity.ok(newBook);
    }
    //Cabeceras para enviar información de la petición Paginación

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        if (id ==null){
            return ResponseEntity.badRequest().build();
        }
        if (!repository.existsById(id)){
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}