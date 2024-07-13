package org.example.securitydemo.controller;

import org.example.securitydemo.data.Message;
import org.example.securitydemo.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MessageController {
    @Autowired
    private ContactService service;


    @RequestMapping("/message")
    public String displayMessage(){
        return "message.html";
    }
    @PostMapping("/saveMessage")
    public String displayHome(Message message){
        service.saveMessage(message);
        return "redirect:/message";
    }
}
