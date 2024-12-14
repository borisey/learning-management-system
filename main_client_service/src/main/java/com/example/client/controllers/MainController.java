package com.example.client.controllers;

import com.example.client.service.HelloClientService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

    @PostMapping("/user/add")
    public String userAdd(
            HttpServletRequest request,
            @RequestParam String name
    ) {

        grpcClient.sayHello(name);

        String referrer = request.getHeader("Referer");

        return "redirect:" + referrer;
    }
}
