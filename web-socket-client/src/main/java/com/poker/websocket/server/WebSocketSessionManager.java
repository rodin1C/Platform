package com.poker.websocket.server;

import org.jboss.netty.channel.Channel;
import org.jboss.netty.handler.codec.http.websocketx.TextWebSocketFrame;

import java.util.HashMap;
import java.util.Map;

public final class WebSocketSessionManager {

    private static Map<Integer, Channel> sessionMap = new HashMap<>();

    private WebSocketSessionManager() {
    }

    public static void addSession(Channel channel) {
        System.out.println(" Created session id: " + channel.getId());
        sessionMap.putIfAbsent(channel.getId(), channel);
    }

    public static Channel getSessionById(Integer id) {
        return sessionMap.get(id);
    }

    public static void broadcast(String message) {
        for (Map.Entry<Integer, Channel> entry : sessionMap.entrySet()) {
            System.out.println("Broadcasting to: " + entry.getKey() + " message: " + message);
            entry.getValue().write(new TextWebSocketFrame(message));
        }
    }
}
