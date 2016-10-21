package com.poker.websocket.session;

import akka.actor.UntypedActor;
import com.poker.platform.channel.session.UserSession;
import com.poker.platform.message.CreateUserSession;

import java.util.HashMap;
import java.util.Map;

public class SessionManagerActor extends UntypedActor{
    private Map<Integer, UserSession> sessionMap = new HashMap<>();

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof CreateUserSession) {
            CreateUserSession msg = (CreateUserSession) message;
            addSession(new UserSession(msg.getChannel(), msg.getUserName()));
        } else {

        }
    }

    public UserSession getSessionById(Integer id) {
        return sessionMap.get(id);
    }

    private void addSession(UserSession session) {
        sessionMap.putIfAbsent(session.getChannel().getId(), session);
    }
}
