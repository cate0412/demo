package com.example.demo.game.domain;

public class GameState {

    private Player currentTurn;
    private final Player player1;
    private final Player player2;

    public GameState(Player p1, Player p2) {
        this.player1 = p1;
        this.player2 = p2;
        this.currentTurn = p1;
    }

    public boolean isPlayerTurn(String playerId) {
        return currentTurn.getId().equals(playerId);
    }

    public void switchTurn() {
        currentTurn = (currentTurn == player1) ? player2 : player1;
    }
}