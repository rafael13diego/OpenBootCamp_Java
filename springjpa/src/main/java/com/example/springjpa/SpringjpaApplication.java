package com.example.springjpa;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringjpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringjpaApplication.class, args);

        CocheRepository repository = context.getBean(CocheRepository.class);

        System.out.println("El num de coches en base de datos es: " + repository.count());

        // crear y almacenar un coche en base de datos
        Coche toyota = new Coche(null, "Toyota", "Prius", 2010);
        repository.save(toyota);

        System.out.println("El num de coches en base de datos es: " + repository.count());

        // recuperar todos
        System.out.println(repository.findAll());
		/*
		guardar H2 en disco

		En caso de querer que la base de datos se guarde en disco habrá que añadir las siguientes propiedades en el archivo application.properties:

        spring.jpa.show-sql=true

        spring.datasource.url=jdbc:h2:file:C:/data/sample

        spring.datasource.username=sa

        spring.datasource.password=

        spring.datasource.driverClassName=org.h2.Driver

        #spring.jpa.hibernate.ddl-auto=creat

        spring.jpa.hibernate.ddl-auto=update

        spring.sql.init.mode=always

        spring.jpa.defer-datasource-initialization=true
		 */
    }


}
