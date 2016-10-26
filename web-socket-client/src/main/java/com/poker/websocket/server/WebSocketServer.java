package com.poker.websocket.server;


import akka.actor.*;
import akka.remote.RemoteScope;
import com.poker.platform.channel.actors.PingPongActor;
import com.poker.platform.message.CreateUserSession;
import com.poker.websocket.session.SM;
import com.poker.websocket.session.SessionManagerActor;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.ssl.SslContext;
import org.jboss.netty.handler.ssl.util.SelfSignedCertificate;

import javax.net.ssl.SSLException;
import java.net.InetSocketAddress;
import java.security.cert.CertificateException;
import java.util.concurrent.Executors;

public class WebSocketServer {
    static final boolean SSL = System.getProperty("ssl") != null;
    static final int PORT = Integer.parseInt(System.getProperty("port", SSL ? "8443" : "8080"));
    static ActorSystem app;

    public static void main(String[] args) throws SSLException, CertificateException {
        app = ActorSystem.create("poker");
        ActorRef actorRef = app.actorOf(Props.create(SM.class).withDeploy(new Deploy(new RemoteScope(new Address("akka.tcp", "poker", "localhost", 1234)))), "ws-session-manager");

        final SslContext sslCtx;
        if (SSL) {
            SelfSignedCertificate ssc = new SelfSignedCertificate();
            sslCtx = SslContext.newServerContext(ssc.certificate(), ssc.privateKey());
        } else {
            sslCtx = null;
        }

        // Configure the server.
        ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()),
                Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2)));

        // Set up the event pipeline factory.
        bootstrap.setPipelineFactory(new WebSocketServerPipelineFactory(app, sslCtx));

        // Bind and start to accept incoming connections.
        bootstrap.bind(new InetSocketAddress(PORT));

        System.err.println("Web socket server started at port " + PORT + '.');
        System.err.println("Open your browser and navigate to http://localhost:" + PORT + '/');
        System.out.printf(actorRef.path().toString());
        actorRef.tell("Hello", ActorRef.noSender());
    }
}
