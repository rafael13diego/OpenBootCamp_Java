package com.example.securitycifrado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SecurityCifradoApplication {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SecurityCifradoApplication.class, args);

        var repository = context.getBean(UserRepository.class);

        PasswordEncoder encoder = context.getBean(PasswordEncoder.class);

        User user = new User(null,"usuario","admin");
        User user2 = new User(null,"usuario2", encoder.encode("admin"));

        repository.save(user);
        repository.save(user2);

        System.out.println(repository.findAll().size());

    }

}