package com.example.demo.config.websocket;


import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
@RequiredArgsConstructor
public class WebSocketConfig  {//implements WebSocketConfigurer

    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        //최초 소켓 연결 시에 사용할 웹소켓 핸들러를 등록합니다.
        //registry.addHandler(new GameController(), "/game").setAllowedOrigins("*");

    }
}
