package io.spring.websockets.demo.server.controllers;

import io.spring.websockets.demo.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
@MessageMapping("/events")
public class EventsTopicController {
    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public EventsTopicController(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }


    @MessageMapping("/add")
    public void addEvent(Event event) {
        simpMessagingTemplate.convertAndSend("/topic/events", event);
    }
}
