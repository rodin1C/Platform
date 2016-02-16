package com.poker.platform.communication;

import com.poker.platform.communication.decoder.JsonBinaryDecoder;
import com.poker.platform.communication.decoder.MultiProtocolDecoder;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class TCPServer {
    private int port;
    private int bossThreadCount;
    private int workerThreadCount;

    public TCPServer(int port) {
        this.port = port;
        this.bossThreadCount = Runtime.getRuntime().availableProcessors();
        this.workerThreadCount = bossThreadCount * 2;

    }

    public TCPServer(int port, int bossThreadCount, int workerThreadCount) {
        this.port = port;
        this.bossThreadCount = bossThreadCount;
        this.workerThreadCount = workerThreadCount;
    }

    public void start() {
        ServerBootstrap bootstrap = new ServerBootstrap(new NioServerSocketChannelFactory(Executors.newFixedThreadPool(bossThreadCount),
                Executors.newFixedThreadPool(workerThreadCount)));
        bootstrap.setPipelineFactory(new ChannelPipelineFactory() {
            @Override
            public ChannelPipeline getPipeline() throws Exception {
                return Channels.pipeline(new MultiProtocolDecoder(), new JsonBinaryDecoder());
            }
        });

        bootstrap.setOption("tcpNoDelay", true);
        bootstrap.setOption("keepAlive", true);
        bootstrap.bind(new InetSocketAddress(port));
    }
}
