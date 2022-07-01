package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        CalculatorService service = (CalculatorService) context.getBean("calculatorService");
        System.out.println(service.helloWorld());

        CalculatorService service2 = (CalculatorService) context.getBean("calculatorService");
        System.out.println(service2.helloWorld());
    }
}
