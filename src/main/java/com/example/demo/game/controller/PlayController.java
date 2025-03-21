package com.example.demo.game.controller;

import com.example.demo.game.dto.PlayMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;


@Slf4j
@Controller
@RequiredArgsConstructor
public class PlayController {

    private final SimpMessagingTemplate messagingTemplate;

    //윳 던지기
    @MessageMapping("/throw-yut")// 클라이언트가 "/app/throw-yut"로 메시지를 보내면 실행됨
    @SendTo("/topic/play")// "/topic/play"을 구독한 모든 클라이언트에게 메시지 전달
    public PlayMessage throwYut(PlayMessage message) {
        System.out.println("Received move: " + message);
        return message;
    }

    //윷판의 말 옮기기
    @MessageMapping("/move")// 클라이언트가 "/app/move"로 메시지를 보내면 실행됨
    @SendTo("/topic/play")// "/topic/play"을 구독한 모든 클라이언트에게 메시지 전달
    public PlayMessage move(PlayMessage message){
        log.info("Received move: " + message);
        System.out.println("Received move: " + message);
        return message;
    }

}
