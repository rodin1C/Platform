package com.poker.platform.channel;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import com.poker.platform.channel.actors.PingPongActor;
import com.poker.platform.communication.TCPServer;

import java.util.ArrayList;
import java.util.List;

public class ChannelServer {
    public static void main(String[] args) {
        ActorSystem system = ActorSystem.create("poker");
//        List<ActorRef> actors = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            ActorRef actorRef = system.actorOf(Props.create(ChannelActor.class), ""+i);
//            actors.add(actorRef);
//            actorRef.tell("PING"+i, ActorRef.noSender());
//        }
//
//        try {
//            Thread.sleep(500L);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        for (ActorRef actor : actors) {
//            actor.tell("PONG", ActorRef.noSender());
//        }

        ActorRef pingPong = system.actorOf(Props.create(PingPongActor.class), "PingPong");

        TCPServer server = new TCPServer(24333);
        server.start();

    }
}
