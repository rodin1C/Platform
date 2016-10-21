package com.poker.platform.message;

import org.jboss.netty.channel.Channel;

public class CreateUserSession {
    private final Channel channel;
    private final String userName;

    public CreateUserSession(Channel channel, String userName) {
        this.channel = channel;
        this.userName = userName;
    }

    public Channel getChannel() {
        return channel;
    }

    public String getUserName() {
        return userName;
    }

    @Override
    public String toString() {
        return "CreateUserSession{" +
                "channel=" + channel +
                ", userName='" + userName + '\'' +
                '}';
    }
}
