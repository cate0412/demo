package com.example.demo.game.service;

import com.example.demo.game.domain.Room;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class RoomService {
    private Map<String, Room> roomMap = new ConcurrentHashMap<>();

    @PostConstruct
    private void init() {
        roomMap = new LinkedHashMap<>();
    }

    public List<Room> findAllRoom() {
        //방 생성순서 최근 순으로 반환
        List<Room> rooms = new ArrayList<>(roomMap.values());
        Collections.reverse(rooms);
        return rooms;
    }

    //방 찾기 - 빠른 매칭을 위한 방id로 방 찾기 : 방상태가 READY인 방만 반환
    public Room findRoomById(String id) {

        //[TODO]방상태 확인 로직 필요

        return roomMap.get(id);
    }

    public Room createRoom(String hostId) {
        String id = UUID.randomUUID().toString();

        Room room = Room.builder()
                .id(id)
                .roomCode((int)(Math.random()*1000000))
                .hostId(hostId)
                .build();

        roomMap.put(room.getId(), room);

        log.info("Room created: {}", room.getId());
        log.info("Room Code: {}", room.getRoomCode());

        return room;
    }
}
