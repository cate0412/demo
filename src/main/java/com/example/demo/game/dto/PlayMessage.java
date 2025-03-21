package com.example.demo.game.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor // 기본 생성자 자동 생성
@AllArgsConstructor // 모든 필드를 포함한 생성자 자동 생성
public class PlayMessage {
    private String type;
    private String player;
    private int position;

}
