package com.example.client.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(value = "/")
    public String getMain() {
        return "Hello World, Docker!";
    }
}
