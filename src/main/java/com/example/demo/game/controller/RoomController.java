package com.example.demo.game.controller;

import com.example.demo.game.domain.Room;
import com.example.demo.game.domain.RoomState;
import com.example.demo.game.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping("/room")
public class RoomController {
    private final RoomService roomService;
    private final SimpMessageSendingOperations messagingTemplate;

    // 모든 방 목록 반환
    @GetMapping("/list")
    @ResponseBody
    public List<Room> room() {
        return roomService.findAllRoom();
    }

    // 방 찾기 - 빠른 매칭을 위한 방id로 방 찾기
    @GetMapping("/{id}")
    public ResponseEntity<Room> findRoom(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(roomService.findRoomById(id));
    }

    //방생성
    @PostMapping("/create/{host-id}")
    public ResponseEntity<Room> createRoom(@PathVariable ("host-id") String hostId) {
         Room newRoom = roomService.createRoom(hostId);
        return ResponseEntity.status(HttpStatus.OK).body(newRoom);
    }

    //방입장
    @MessageMapping("{room_id}/join") //클라이언트에서 /pub/room/join으로 메세지 전송
    public void sendMessage(RoomState state) {
        messagingTemplate.convertAndSend
                ("/sub/room/" + state.getRoomId(), state);
        log.info("Room : {}", state.getRoomId());
        log.info("Join : {}", state.getSender());
    }
}

