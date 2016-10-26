package com.poker.platform.channel.session;

import akka.actor.UntypedActor;
import com.poker.platform.message.CreateUserSession;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelFuture;
import org.jboss.netty.handler.codec.http.websocketx.TextWebSocketFrame;

public class UserSession extends UntypedActor{
    private final Channel channel;
    private final String userName;

    public UserSession(Channel channel, String userName) {
        this.channel = channel;
        this.userName = userName;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof CreateUserSession) {
            System.out.println("UserSession income msg [CreateUserSession] " + message.toString());
        }
        ChannelFuture future = channel.write(new TextWebSocketFrame("Hello@@@@"));
        if (future.isSuccess()) {
            System.out.println("Success");
        } else {
            System.out.println("Fail");
        }

    }

    public Channel getChannel() {
        return channel;
    }

    public String getUserName() {
        return userName;
    }
}
