package com.example.demo.game.controller;

import com.example.demo.game.domain.Player;
import com.example.demo.game.service.GameService;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class GameController extends TextWebSocketHandler {

    private final GameService gameService = new GameService();
    private final ConcurrentHashMap<String, Player> players = new ConcurrentHashMap<>();

    /**
     * [연결 성공] WebSocket 협상이 성공적으로 완료되고 WebSocket 연결이 열려 사용할 준비가 된 후 호출됩니다.
     * - 성공을 하였을 경우 session 값을 추가합니다.
     */

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        log.warn("[+] afterConnectionEstablished :: " + session.getId());

        if (players.size() < 2) {
            Player player = new Player(session.getId(), session);
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

    /**
     * [메시지 전달] 새로운 WebSocket 메시지가 도착했을 때 호출됩니다.
     * - 전달 받은 메시지를 순회하면서 메시지를 전송합니다.
     * - message.getPayload()를 통해 메시지가 전달이 됩니다.
     */
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        log.warn("[+] handleTextMessage :: " + session);
        log.warn("[+] handleTextMessage :: " + message.getPayload());

        try {
            String msg = message.getPayload();
            if (msg.equals("THROW_YUT")) {
                String result = gameService.throwYut(session.getId());
                broadcast("YUT_RESULT:" + result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void broadcast(String message) throws IOException {
        try {
            for (Player player : players.values()) {
                player.getSession().sendMessage(new TextMessage(message));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * [소켓 종료 및 전송 오류] WebSocket 연결이 어느 쪽에서든 종료되거나 전송 오류가 발생한 후 호출됩니다.
     * - 종료 및 실패하였을 경우 해당 세션을 제거합니다.
     */
    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws IOException {
        players.remove(session.getId());
        log.warn("[+] afterConnectionClosed - Session: " + session.getId() + ", CloseStatus: " + status);
    }
}
