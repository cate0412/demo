package com.example.demo.config.listener;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

@Slf4j
@Component
public class WebSocketEventListener {

    @EventListener // 연결 성공 이벤트
    public void handleWebSocketConnectListener(SessionConnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        String destination = headerAccessor.getDestination(); // 구독하려는 채널
        log.warn("User with sessionId {} subscribed to {}", headerAccessor.getSessionId(), destination);
        log.warn("사용자 연결 성공: {}", headerAccessor.getSessionId());
    }

        @EventListener //연결 종료 이벤트
    public void handleWebSocketConnectListener(SessionDisconnectEvent event) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
        log.warn("사용자 연결 종료: {}", headerAccessor.getSessionId());
    }
}
