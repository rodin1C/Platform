package com.poker.websocket.server;


import akka.actor.ActorSystem;

public final class ActorApp {
    public static ActorSystem app = ActorSystem.create("poker");


}
