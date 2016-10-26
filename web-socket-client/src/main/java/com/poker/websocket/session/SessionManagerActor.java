package com.poker.websocket.session;

import akka.actor.*;
import akka.japi.pf.ReceiveBuilder;
import akka.remote.RemoteScope;
import com.poker.platform.channel.session.UserSession;
import com.poker.platform.message.BasicMessage;
import com.poker.platform.message.CreateUserSession;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;

import java.util.HashMap;
import java.util.Map;

public class SessionManagerActor extends UntypedActor {
    private Map<Integer, UserSession> sessionMap = new HashMap<>();

    @Override
    public void onReceive(Object message) throws Exception {

        PartialFunction<Object, BoxedUnit> partialFunction = ReceiveBuilder.match(CreateUserSession.class, m -> {
            CreateUserSession msg = (CreateUserSession) message;
            ActorRef userActor = getContext().actorOf(Props.create(UserSession.class, msg.getChannel(), msg.getUserName()).withDeploy(new Deploy(new RemoteScope(new Address("akka.tcp", "poker", "localhost", 1234)))),
                    "user-session-id-" + ((CreateUserSession) message).getChannel().getId());

            userActor.tell(msg, getSelf());
        }).match(BasicMessage.class, m -> {
            BasicMessage basicMessage = (BasicMessage) m;
            Integer to = basicMessage.getTo();
            ActorRef userActor = getContext().actorOf(Props.create(UserSession.class).withDeploy(new Deploy(new RemoteScope(new Address("akka.tcp", "poker", "localhost", 1234)))),
                    "user-session-id-" + to);
            userActor.tell(basicMessage.getMessage(), getSelf());
        }).matchAny(m -> {
            System.out.println(m.toString());
        }).build();


//        if (message instanceof CreateUserSession) {
//            CreateUserSession msg = (CreateUserSession) message;
//            ActorRef userActor = getContext().actorOf(Props.create(UserSession.class, msg.getChannel(), msg.getUserName()).withDeploy(new Deploy(new RemoteScope(new Address("akka.tcp", "poker", "localhost", 1234)))),
//                    "user-session-id-" + ((CreateUserSession) message).getChannel().getId());
//
//            userActor.tell(msg, getSelf());
//        } else if (){
//
//        }
    }

    public UserSession getSessionById(Integer id) {
        return sessionMap.get(id);
    }

    private void addSession(UserSession session) {
        sessionMap.putIfAbsent(session.getChannel().getId(), session);
    }
}
