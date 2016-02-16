package com.poker.platform.channel.session;

import akka.actor.UntypedActor;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;

public class UserSession extends UntypedActor{
    private final Channel channel;
    private String userName;

    public UserSession(Channel channel) {
        this.channel = channel;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        ChannelFuture future = channel.write(message);

    }
}
