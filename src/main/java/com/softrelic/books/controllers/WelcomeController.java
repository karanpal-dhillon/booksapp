package com.softrelic.books.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController{
    @GetMapping("/")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/message")
    public String sayMessage(){
        return "This is a message";
    }
}
