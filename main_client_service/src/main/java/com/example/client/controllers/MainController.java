package com.example.client.controllers;

import com.example.client.service.HelloClientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    private final HelloClientService grpcClient;

    public MainController(HelloClientService grpcClient) {
        this.grpcClient = grpcClient;
    }

    @GetMapping(value = "/")
    public String getMain(Model model) {
        String users = grpcClient.getUsers();

        model.addAttribute("users", users);

        return "main";
    }
}
