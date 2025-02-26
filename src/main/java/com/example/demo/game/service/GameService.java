package com.example.demo.game.service;

import org.springframework.stereotype.Service;

@Service
public class GameService {

    /*
    package com.game.yutnori.service;

import com.game.yutnori.model.GameState;
import com.game.yutnori.model.Player;
import com.game.yutnori.model.YutResult;

import java.util.*;

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

     */


}
