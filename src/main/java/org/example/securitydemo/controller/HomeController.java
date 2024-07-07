package org.example.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @PostMapping("/saveMessage")
    public void displayHome(){

    }
}
