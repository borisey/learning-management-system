package com.example.client.controllers;

import com.example.client.service.HelloClientService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(value = "/")
    public String getMain() {

//        HelloClientService helloClientService = new HelloClientService();
//        String textMessage = helloClientService.sayHello("alex");

        return "textMessage";
    }
}
