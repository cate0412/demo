package com.example.demo.game.dto;

import lombok.Data;

@Data
public class RoomMessage {

    public enum RoomMessageType {
        ENTER, WAIT, PLAY, EXIT
    }

    private RoomMessageType type;
    private String roomId;
    private String sender;


}
