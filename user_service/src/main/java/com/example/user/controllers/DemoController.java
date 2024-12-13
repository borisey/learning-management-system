package com.example.user.controllers;

import org.springframework.web.bind.annotation.GetMapping;

public class DemoController {
    @GetMapping(value = "/hello")
    public String getHello() {
        return "Hello World, Docker!";
    }
}
