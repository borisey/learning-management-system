package com.example.client.controllers;

import com.example.client.service.HelloClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    private final HelloClientService grpcClient;

    public DemoController(HelloClientService grpcClient) {
        this.grpcClient = grpcClient;
    }

    @GetMapping("/hello")
    public String hello(@RequestParam String name) {
        return grpcClient.sayHello(name);
    }
}
