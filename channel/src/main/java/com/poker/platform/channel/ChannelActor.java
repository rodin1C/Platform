package com.poker.platform.channel;

import akka.actor.UntypedActor;

public class ChannelActor extends UntypedActor {
    private Integer state = 0;

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            state ++;
            System.out.println(message + " State: "+state);
        }
    }
}
