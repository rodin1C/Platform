package com.poker.platform.protocol.model.network;

import com.poker.platform.protocol.model.AbstractMessage;
import com.poker.platform.protocol.model.MessageCode;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Ping extends AbstractMessage {

    public Ping() {
        super(MessageCode.PING);
    }

}
