package com.poker.websocket.server;


import akka.actor.ActorSystem;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.handler.codec.http.HttpChunkAggregator;
import org.jboss.netty.handler.codec.http.HttpRequestDecoder;
import org.jboss.netty.handler.codec.http.HttpResponseEncoder;
import org.jboss.netty.handler.ssl.SslContext;

public class WebSocketServerPipelineFactory implements ChannelPipelineFactory {

    private final SslContext sslCtx;
    private final ActorSystem actorSystem;

    public WebSocketServerPipelineFactory(ActorSystem app, SslContext sslCtx) {
        this.actorSystem = app;
        this.sslCtx = sslCtx;
    }

    @Override
    public ChannelPipeline getPipeline() throws Exception {
        ChannelPipeline pipeline = Channels.pipeline();
        if (sslCtx != null) {
            pipeline.addLast("ssl", sslCtx.newHandler());
        }
        pipeline.addLast("decoder", new HttpRequestDecoder());
        pipeline.addLast("aggregator", new HttpChunkAggregator(65536));
        pipeline.addLast("encoder", new HttpResponseEncoder());
        pipeline.addLast("handler", new WebSocketServerHandler(actorSystem));
        return pipeline;
    }
}
