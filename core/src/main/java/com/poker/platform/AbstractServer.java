package com.poker.platform;


import akka.actor.ActorSystem;
import akka.actor.Props;

public abstract class AbstractServer {
    private final ActorSystem actorSystem;
    private final String name;
    private final ServerType serverType;
    private final String host;
    private final int port;

    protected AbstractServer(ActorSystem system, String name, ServerType serverType, String host, int port) {
        this.actorSystem = system;
        this.name = name;
        this.serverType = serverType;
        this.host = host;
        this.port = port;
    }
}
