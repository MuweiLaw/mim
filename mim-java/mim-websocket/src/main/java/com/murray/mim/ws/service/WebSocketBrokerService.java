package com.murray.mim.ws.service;

import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class WebSocketBrokerService {
    private final SimpMessagingTemplate simpMessagingTemplate;

    public WebSocketBrokerService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void sendMessage(String destination, String message) {
        simpMessagingTemplate.convertAndSend(destination, message);
    }
}