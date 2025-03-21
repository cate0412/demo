package com.example.demo.game.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PlayService {

    //게임시작
    public void playStart() {
        log.info("Game Start!");
    }

    //윷 던지기
    public void throwYut(){
        log.info("Throw Yut!");
    }

    //말 이동
    public void movePiece(){
        log.info("Move Piece!");
    }



}
