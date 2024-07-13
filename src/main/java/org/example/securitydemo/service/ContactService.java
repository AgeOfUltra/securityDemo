package org.example.securitydemo.service;

import org.example.securitydemo.data.Message;
import org.springframework.stereotype.Service;

@Service
public class ContactService {
    public void saveMessage(Message message){
        System.out.println("Message saved as "+message.toString());
    }
}
