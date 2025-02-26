package com.example.demo.game.controller;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class GameController {

/*
package com.game.yutnori.controller;

import com.game.yutnori.model.GameState;
import com.game.yutnori.model.Player;
import com.game.yutnori.service.GameService;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.*;

public class GameController extends TextWebSocketHandler {
    private final GameService gameService = new GameService();
    private final Map<String, Player> players = new HashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        if (players.size() < 2) {
            Player player = new Player(session.getId());
            players.put(session.getId(), player);
            session.sendMessage(new TextMessage("CONNECTED: " + player.getId()));

            if (players.size() == 2) {
                gameService.startGame(players);
                broadcast("GAME_START");
            }
        } else {
            session.sendMessage(new TextMessage("ROOM_FULL"));
            session.close();
        }
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws IOException {
        String msg = message.getPayload();
        if (msg.equals("THROW_YUT")) {
            String result = gameService.throwYut(session.getId());
            broadcast("YUT_RESULT:" + result);
        }
    }

    private void broadcast(String message) throws IOException {
        for (Player player : players.values()) {
            player.getSession().sendMessage(new TextMessage(message));
        }
    }
}

 */
}
