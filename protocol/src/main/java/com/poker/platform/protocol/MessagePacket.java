package com.poker.platform.protocol;

import com.poker.platform.protocol.model.AbstractMessage;
import com.poker.platform.protocol.model.Protocols;
import com.poker.platform.protocol.model.RouterType;

import java.io.Serializable;

public class MessagePacket<M extends AbstractMessage> implements Serializable {
    private static final long serialVersionUID = 1L;
    private int sender;
    private int receiver;
    private String serviceName;
    private Protocols protocol;
    private M message;

    public MessagePacket() {
    }

    public MessagePacket(Protocols protocol, M message) {
        this.protocol = protocol;
        this.message = message;
    }

    public MessagePacket(RouterType sender, RouterType receiver, String serviceName, Protocols protocol, M message) {
        this.sender = sender.getCode();
        this.receiver = receiver.getCode();
        this.serviceName = serviceName;
        this.protocol = protocol;
        this.message = message;
    }

    public void setProtocol(Protocols protocol) {
        this.protocol = protocol;
    }

    public M getMessage() {
        return message;
    }

    public void setMessage(M message) {
        this.message = message;
    }

    public Protocols getProtocol() {
        return protocol;
    }

}
