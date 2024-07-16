package com.murray.mim.ws.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.server.HandshakeInterceptor;

/**
 * TODO 存在跨域问题
 */
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketBrokerConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        // 配置消息代理，用于处理前缀为"/mim4j"的消息
        config.enableSimpleBroker("/topic");
                //.setHeartbeatValue(new long[]{10000, 10000}); 心跳机制,添加代码提示配置异常 TODO
        config.setApplicationDestinationPrefixes("/mim4j");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个名为"/websocket"的端点，客户端将通过这个端点与服务器进行WebSocket通信
        registry.addEndpoint("/wsSockJS").withSockJS().setInterceptors(customHandshakeInterceptor());
    }

    @Bean
    public HandshakeInterceptor customHandshakeInterceptor() {
        return new CustomHandshakeInterceptor();
    }
}