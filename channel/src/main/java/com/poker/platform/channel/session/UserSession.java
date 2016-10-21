package com.poker.platform.channel.session;

import akka.actor.UntypedActor;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;

public class UserSession extends UntypedActor{
    private final Channel channel;
    private final String userName;

    public UserSession(Channel channel, String userName) {
        this.channel = channel;
        this.userName = userName;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        ChannelFuture future = channel.write(message);

    }

    public Channel getChannel() {
        return channel;
    }

    public String getUserName() {
        return userName;
    }
}
