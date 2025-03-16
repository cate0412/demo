package com.example.demo.game.service;

import com.example.demo.game.domain.GameState;
import com.example.demo.game.domain.Player;
import com.example.demo.game.domain.YutResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class GameService {
    private final Random random = new Random();
    private GameState gameState;

    public void startGame(Map<String, Player> players) {
        List<Player> playerList = new ArrayList<>(players.values());

        gameState = new GameState(playerList.get(0), playerList.get(1));
    }

    public String throwYut(String playerId) {
        if (!gameState.isPlayerTurn(playerId)) {
            return "NOT_YOUR_TURN";
        }

        YutResult result = YutResult.throwYut();
        gameState.switchTurn();
        return result.name();

    }
}
