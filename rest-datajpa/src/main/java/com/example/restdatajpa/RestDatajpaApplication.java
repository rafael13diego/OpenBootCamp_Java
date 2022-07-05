package com.example.restdatajpa;

import com.example.restdatajpa.models.Book;
import com.example.restdatajpa.repositories.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class RestDatajpaApplication {

	public static void main(String[] args) {
		ApplicationContext context =  SpringApplication.run(RestDatajpaApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

		Book book = new Book(null,"El padrino","Mario Puzzo",500,55.50,
				LocalDate.of(1990,12,15), true);
		Book book2 = new Book(null,"Codigo Davinci","Dan Brown",150,100.50,
				LocalDate.of(2001,6,1), true);
		repository.save(book);
		repository.save(book2);

		System.out.println(repository.findAll());
		System.out.println("Cantidad inicial: "+repository.findAll().size());

		//repository.deleteById(1L);
		System.out.println("Cantidad_final: "+ repository.findAll().size());
		System.out.println("Cantidad_final: "+ repository.findAll().size());
	}

}