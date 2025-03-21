package com.example.demo.game.controller;

import com.example.demo.game.dto.RoomMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RoomMessageController {

    private final SimpMessagingTemplate messagingTemplate;

    //방입장
    @MessageMapping("{room_id}/join")// 클라이언트가 "/app/{room_id}/join"로 메시지를 보내면 실행됨
    @SendTo("/topic/room/")// "/topic/room"을 구독한 모든 클라이언트에게 메시지 전달
    public RoomMessage sendMessage(RoomMessage message) {

        System.out.println("Room : " + message.getRoomId());
        System.out.println("Join : " + message.getSender());
        log.info("Received message: {}", message);

        return message;
    }
}
