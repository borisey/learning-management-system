package com.example.client.controllers;

import com.example.client.models.User;
import com.example.client.service.HelloClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.connector.Response;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Controller
public class MainController {
    private final HelloClientService grpcClient;

    public MainController(HelloClientService grpcClient) {
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

        grpcClient.sayHello(name);

        String referrer = request.getHeader("Referer");

        return "redirect:" + referrer;
    }
}
