package com.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model) {
        RestTemplate restTemplate = new RestTemplate();
        String apiUrl = "https://myappfb-4718b.firebaseio.com/campeche/produccion.json";
        String response = restTemplate.getForObject(apiUrl, String.class);
        model.addAttribute("apiResponse", response);
        return "home";
    }
}
