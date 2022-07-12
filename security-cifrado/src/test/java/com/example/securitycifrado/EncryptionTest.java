package com.example.securitycifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class EncryptionTest {

    /**
     * Bcrypt que genera su propio salt de 16bytes
     *
     * El resultado de cifrar con bcrypt será un string 60 caracteres:
     * $a version ejm: $2a
     * $10 fuerza (valor de 4 a 31, defecto = 10) example $10
     * Los 22 siguientes caracteres son el salt generado
     */

    @Test
    void bcryptTest(){
        //ctrl + P para ver los parametros de entrada
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        var uno= passwordEncoder.encode("admin");
        System.out.println(uno);

        //valor plano , valor cifrado de bd
        var dos = passwordEncoder.matches("admin","$2a$10$g9KlFSxa2NFzq1RkGXDJIeG6nfP18nnLEFhl.8GF2762LT62XJQRi");
        var tres = passwordEncoder.matches("admin",uno);
        var cuatro = passwordEncoder.matches("adminn",uno);
        System.out.println("Es verdadero: 1 = " +uno+ " \n  dos = "+dos);
        System.out.println("Es verdadero: tre = " +tres + " \n cuatro = "+cuatro);

    }

    @Test
    void bcryptCheckMultiplePasswords(){
        BCryptPasswordEncoder passwordEncoder= new BCryptPasswordEncoder();

        for (int i = 0; i<30; i++){
            System.out.println(i+") "+passwordEncoder.encode("admin"));
        }
    }

    @Test
    void pbkdf2() {
        Pbkdf2PasswordEncoder passwordEncoder= new Pbkdf2PasswordEncoder();

        for (int i = 0; i<30; i++){
            System.out.println(i+") "+passwordEncoder.encode("admin"));
        }
    }

    @Test
    void springPasswordEnconder(){
        String idForEnconde = "bcrypt";

        Map<String, PasswordEncoder> enconders = new HashMap<>();
        enconders.put("bcrypt", new BCryptPasswordEncoder());
        enconders.put("pbkdf2", new Pbkdf2PasswordEncoder());

        PasswordEncoder encoder = new DelegatingPasswordEncoder("bcrypt", enconders);
        encoder = new DelegatingPasswordEncoder("pbkdf2", enconders);
    }
}