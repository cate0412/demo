package com.example.demo.chat;

import lombok.Data;

import java.util.UUID;

@Data
public class ChatRoom {
    private String id;
    private String name;
    private String owner;

    public static ChatRoom create(String name, String owner) {
        ChatRoom chatRoom = new ChatRoom();
        chatRoom.id = UUID.randomUUID().toString();
        chatRoom.name = name;
        chatRoom.owner = owner;
        return chatRoom;
    }
}

