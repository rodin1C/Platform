package com.poker.websocket.session;

import akka.actor.*;
import akka.japi.pf.ReceiveBuilder;
import akka.remote.RemoteScope;
import com.poker.platform.channel.session.UserSession;
import com.poker.platform.message.BasicMessage;
import com.poker.platform.message.CreateUserSession;
import scala.PartialFunction;
import scala.runtime.BoxedUnit;


public class SM extends AbstractActor {

    @Override
    public PartialFunction<Object, BoxedUnit> receive() {
        return ReceiveBuilder.match(CreateUserSession.class, m -> {
            CreateUserSession msg = (CreateUserSession) m;
            ActorRef userActor = getContext().actorOf(Props.create(UserSession.class, msg.getChannel(), msg.getUserName()).withDeploy(new Deploy(new RemoteScope(new Address("akka.tcp", "poker", "localhost", 1234)))),
                    "user-session-id-" + ((CreateUserSession) m).getChannel().getId());

            userActor.tell(msg, self());
        }).match(BasicMessage.class, m -> {
            BasicMessage basicMessage = (BasicMessage) m;
            Integer to = basicMessage.getTo();
            ActorRef userActor = getContext().actorOf(Props.create(UserSession.class).withDeploy(new Deploy(new RemoteScope(new Address("akka.tcp", "poker", "localhost", 1234)))),
                    "user-session-id-" + to);
            userActor.tell(basicMessage.getMessage(), self());
        }).matchAny(m -> {
            System.out.println(m.toString());
        }).build();
    }
}
