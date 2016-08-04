package com.poker.websocket.server;


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

    public static void main(String[] args) throws SSLException, CertificateException {
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
        bootstrap.setPipelineFactory(new WebSocketServerPipelineFactory(sslCtx));

        // Bind and start to accept incoming connections.
        bootstrap.bind(new InetSocketAddress(PORT));

        System.err.println("Web socket server started at port " + PORT + '.');
        System.err.println("Open your browser and navigate to http://localhost:" + PORT + '/');
    }
}
