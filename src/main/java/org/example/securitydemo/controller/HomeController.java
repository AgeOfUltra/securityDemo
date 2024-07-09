package org.example.securitydemo.controller;

import org.example.securitydemo.data.Message;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @PostMapping("/saveMessage")
    public String displayHome(Message message){
        System.out.println("Message from the frontend is : "+message.toString());
        return "redirect:/message";
    }
}
