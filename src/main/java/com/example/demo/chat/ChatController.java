package com.example.demo.chat;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final SimpMessagingTemplate messagingTemplate;
    private final ChatRoomService chatRoomService;

    /*
    @PostMapping("/chat/room")
    public ChatRoom createRoom(@RequestParam String name, @RequestParam String owner) {
        return chatRoomService.createRoom(name, owner);
    }
     */

    /*
    @GetMapping("/chat/rooms")
    public List<ChatRoom> findAllRooms() {
        return chatRoomService.findAllRooms();
    }
     */

    @MessageMapping("/enterRoom")
    public void enterRoom(ChatMessage message) {
        //if (message.getType() == ChatMessage.MessageType.ENTER){}
        message.setContent(message.getSender() + "님이 입장하셨습니다.");
        messagingTemplate.convertAndSend("/topic/" + message.getRoom(), message);
    }

    @MessageMapping("/leaveRoom")
    public void leaveRoom(ChatMessage message) {
        message.setContent(message.getSender() + "님이 퇴장하셨습니다.");
        messagingTemplate.convertAndSend("/topic/" + message.getRoom(), message);
    }

    @MessageMapping("/send")
    public void sendMessage(@Payload ChatMessage message) {
        messagingTemplate.convertAndSend("/topic/chat" + message.getRoom(), message);
    }
}