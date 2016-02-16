package com.poker.platform.communication.decoder;


import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;

public class JsonBinaryDecoder extends OneToOneDecoder {


    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, Object msg) throws Exception {
        System.out.println(msg);
        return msg;
    }
}
