package com.murray.mim.ws.controller;

import com.murray.mim.commons.R;
import com.murray.mim.model.dto.IMMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;

public class WebSocketBrokerController {

    @MessageMapping("/chat")
    @SendTo("/topic/public")
    public R<IMMessage> sendMessage(IMMessage message) {
        return R.success(message);
    }
}