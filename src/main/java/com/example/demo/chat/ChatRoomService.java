package com.example.demo.chat;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ChatRoomService {

    private List<ChatRoom> chatRooms = new ArrayList<>();

    public ChatRoom createRoom(String name, String owner) {
        ChatRoom chatRoom = ChatRoom.create(name, owner);
        chatRooms.add(chatRoom);
        addUserToRoom(chatRoom.getId(), chatRoom.getOwner());
        return chatRoom;
    }

    public List<ChatRoom> findAllRooms() {
        return chatRooms;
    }

    public ChatRoom findRoomById(String roomId) {
        return chatRooms.stream()
                .filter(room -> room.getId().equals(roomId))
                .findFirst()
                .orElse(null);
    }
    public void addUserToRoom(String roomId, String username) {
        ChatRoom chatRoom = findRoomById(roomId);
        if (chatRoom != null) {
            // 방에 유저를 추가하는 로직 (필요시 확장 가능)
            System.out.println(username + " has joined the room: " + chatRoom.getName());
        }
    }
}


