package com.example.springdeploy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /*
    Compiler -> *check* Build Project Automatically
    Advanced Settings -> Allow
     */
    @Value("${app.varexample}")
    String message;
    @GetMapping("/hello")
    public String helloWorld(){
        System.out.println(message);
        return "Hola Diego is Back!!";
    }
}