package com.example.demo.chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@RestController
public class UserController {
    private final Set<String> users = ConcurrentHashMap.newKeySet();
    private final Map<String, Set<String>> chatRooms = new ConcurrentHashMap<>();

    @GetMapping("/createRoom")
    public Set<String> createRoom(@RequestParam String roomName) {
        chatRooms.putIfAbsent(roomName, ConcurrentHashMap.newKeySet());
        return chatRooms.get(roomName);
    }

    @GetMapping("/joinRoom")
    public Set<String> joinRoom(@RequestParam String roomName, @RequestParam String username) {
        chatRooms.putIfAbsent(roomName, ConcurrentHashMap.newKeySet());
        chatRooms.get(roomName).add(username);
        return chatRooms.get(roomName);
    }

    @GetMapping("/rooms")
    public Map<String, Set<String>> getRooms() {
        return chatRooms;
    }

    // 방 나가기 메서드 추가
    @GetMapping("/leaveRoom")
    public Set<String> leaveRoom(@RequestParam String roomName, @RequestParam String username) {
        if (chatRooms.containsKey(roomName)) {
            chatRooms.get(roomName).remove(username);
        }
        return chatRooms.get(roomName);
    }

    @GetMapping("/addUser")
    public Set<String> addUser(@RequestParam String username) {
        users.add(username);
        return users;
    }

    @GetMapping("/users")
    public Set<String> getUsers() {
        return users;
    }
}
