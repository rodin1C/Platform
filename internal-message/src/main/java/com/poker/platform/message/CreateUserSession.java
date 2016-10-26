package com.poker.platform.message;

import org.jboss.netty.channel.Channel;

import java.io.Serializable;

public class CreateUserSession implements Serializable{
    private static final long serialVersionUID = 1L;
    private Channel channel;
    private String userName;

    public CreateUserSession() {
    }

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
