package io.spring.websockets.demo.server.controllers;

import io.spring.websockets.demo.models.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

/**
 * Example of a controller which handles an event message.
 *
 * Clients should subscribe to topic /topic/events and receive event messages after some client
 * added new events to the topic by sending an event object to the destination /events/add
 *
 * This is similar to a Chat, were all clients can send and receive messages.
 */
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
