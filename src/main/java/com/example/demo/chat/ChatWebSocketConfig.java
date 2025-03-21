package com.example.demo.chat;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class ChatWebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/chat") // 엔드포인트 설정
                .setAllowedOriginPatterns("*")
                .withSockJS(); // SockJS 지원
    }

    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        registry.enableSimpleBroker("/topic"); // 메시지 브로커 설정
        registry.setApplicationDestinationPrefixes("/app");

        //메세지 구독요청 URL -> SUBSCRIBE하는 클라이언트에게 메세지 전달
        //registry.enableSimpleBroker("/sub");
        //메세지 발행요청 URL -> 클라이언트에서 SEND 요청 처리
        //registry.setApplicationDestinationPrefixes("/pub");
    }
}