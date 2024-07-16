package com.murray.mim.ws.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.support.HttpSessionHandshakeInterceptor;

import java.util.Map;

public class CustomHandshakeInterceptor extends HttpSessionHandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response,
                                   WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {

        // 设置响应头以允许跨域请求
        response.getHeaders().set(HttpHeaders.ACCESS_CONTROL_ALLOW_ORIGIN, request.getHeaders().getFirst(HttpHeaders.ORIGIN));
        response.getHeaders().set(HttpHeaders.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        response.getHeaders().set(HttpHeaders.ACCESS_CONTROL_ALLOW_HEADERS, "*");
        response.getHeaders().set(HttpHeaders.ACCESS_CONTROL_MAX_AGE, "1728000");

        // 调用父类的 beforeHandshake 以继续握手过程
        return super.beforeHandshake(request, response, wsHandler, attributes);
    }
    // 你可以将 CustomHandshakeInterceptor 注册到 WebSocket 配置中
    // ...
}