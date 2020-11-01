package io.spring.websockets.demo.server.controllers;

import io.spring.websockets.demo.models.HelloWorld;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.security.Principal;

@Controller
@MessageMapping("/echo")
public class EchoController {
    private final SimpMessagingTemplate simpMessagingTemplate;


    @Autowired
    public EchoController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }


    @MessageMapping("/message")
    public void message(Principal principal, String message) {
        simpMessagingTemplate.convertAndSendToUser(principal.getName(), "/echo/message", "Returning from server " + message);
    }

    @MessageMapping("/object")
    public void object(Principal principal, HelloWorld helloWorld) {
        simpMessagingTemplate.convertAndSendToUser(principal.getName(), "/echo/object", new HelloWorld("Returning from server " + helloWorld.message));
    }

}
