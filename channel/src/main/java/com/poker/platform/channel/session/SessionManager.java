package com.poker.platform.channel.session;

import java.util.concurrent.ConcurrentHashMap;

public class SessionManager {
    private ConcurrentHashMap<String, UserSession> userSession = new ConcurrentHashMap<>();

}
