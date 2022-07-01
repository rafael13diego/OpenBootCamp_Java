package com.example;

import org.springframework.stereotype.Component;

@Component
public class Calculadora {

    public Calculadora(){
        System.out.println("Ejecutanto constructor calculadora");
    }
    public String helloWorld(){

        return "Hello world";
    }
}
