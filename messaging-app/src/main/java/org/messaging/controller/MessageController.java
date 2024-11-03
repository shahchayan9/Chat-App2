package org.messaging.controller;

import org.messaging.model.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class MessageController {

    @Autowired
    private SimpMessagingTemplate template;

    @MessageMapping("/send")
    public void sendMessage(@Payload Message message) {
        System.out.println("Sender: " + message.getSender());
        template.convertAndSend("/topic/messages", message);
    }

}
