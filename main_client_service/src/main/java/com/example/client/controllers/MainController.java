package com.example.client.controllers;

import com.example.client.models.User;
import com.example.client.service.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.http.HttpServletRequest;
import org.json.JSONException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class MainController {
    private final ClientService grpcClient;

    public MainController(ClientService grpcClient) {
        this.grpcClient = grpcClient;
    }

    @GetMapping(value = "/")
    public String getMain(Model model) throws JsonProcessingException, JSONException {
        String users = grpcClient.getUsers();

        ArrayList<User> list = new Gson().fromJson(users, new TypeToken<ArrayList<User>>(){}.getType());

        model.addAttribute("users", list);

        return "main";
    }

    @PostMapping("/user/add")
    public String userAdd(
            HttpServletRequest request,
            @RequestParam String name
    ) {

        grpcClient.saveUser(name);

        String referrer = request.getHeader("Referer");

        return "redirect:" + referrer;
    }
}
