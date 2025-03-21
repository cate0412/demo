package com.example.demo.chat;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessage {  //STOMP를 통해 주고받을 데이터 객체
    private String type; // "ENTER", "CHAT", "LEAVE"
    private String room;  // 채팅방 ID
    private String sender;  // 발신자
    private String content;  // 메시지 내용

    public enum MessageType {
        ENTER, CHAT, LEAVE
    }

}