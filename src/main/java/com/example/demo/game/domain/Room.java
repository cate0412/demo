package com.example.demo.game.domain;

import lombok.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Room {

    private String id;
    private Integer roomCode;
    private String hostId;

    @Builder
    public Room(String id, Integer roomCode, String hostId) {
        this.id = id;
        this.roomCode = roomCode;
        this.hostId = hostId;
    }
}
