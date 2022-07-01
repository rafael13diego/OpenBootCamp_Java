package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
        Calculadora service = (Calculadora) context.getBean("calculadora");
        System.out.println(service.helloWorld());

        Calculadora service2 = (Calculadora) context.getBean("calculadora");
        System.out.println(service2.helloWorld());

        //EJEMPLO 2

        GestorFacturas gestor = (GestorFacturas) context.getBean("gestorFacturas");
        System.out.println(gestor.calculadora.helloWorld() +" XD");

        //Los objetos Beans son sigleton por defecto, se crea 1 y se reutiliza (Clases DAO,Service, Controller)
        //Podemos cambiarlo con scope=prototype, si queremos generar uno cada vez que se invoca.

    }
}
