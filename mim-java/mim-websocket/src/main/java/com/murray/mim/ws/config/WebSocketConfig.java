package com.murray.mim.ws.config;

import com.murray.mim.ws.dto.SessionDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Murray Law
 */
@Configuration
public class WebSocketConfig {

    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }

    /**
     * WebSocket的Session映射
     */
    public final static ConcurrentHashMap<String, Map<String, SessionDto>> SESSION_MAP = new ConcurrentHashMap<>();


}