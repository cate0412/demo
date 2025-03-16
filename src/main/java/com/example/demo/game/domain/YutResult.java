package com.example.demo.game.domain;

import java.util.Random;

public enum YutResult {
    DO, GAE, GIRL, YUT, MO;

    private static final Random random = new Random();

    public static YutResult throwYut() {
        return values()[random.nextInt(values().length)];
    }
}
