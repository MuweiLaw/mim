package com.murray.mim.ws.controller;

import com.murray.mim.commons.controller.BaseController;
import com.murray.mim.commons.controller.R;
import com.murray.mim.model.dto.IMMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebSocketBrokerController implements BaseController {

    @MessageMapping("/info")
    @SendTo("/topic/public")
    public R<IMMessage> sendMessage(@RequestParam("t") String msg) {
        System.out.println(msg);
        return R.success(new IMMessage().setBody(msg));
    }
}