package com.poker.platform.protocol.builder;


import com.poker.platform.protocol.MessagePacket;
import com.poker.platform.protocol.marshaller.BinaryMessageMarshaller;
import com.poker.platform.protocol.model.AbstractMessage;
import com.poker.platform.protocol.model.Protocols;
import com.poker.platform.protocol.model.RouterType;

public class BinaryMessageBuilder {
    private final RouterType sender;
    private final RouterType receiver;
    private Protocols protocols;
    private AbstractMessage message;
    private String serviceName = "";

    public BinaryMessageBuilder(RouterType sender, RouterType receiver) {
        this.sender = sender;
        this.receiver = receiver;
    }

    public BinaryMessageBuilder addProtocol(Protocols protocols) {
        this.protocols = protocols;
        return this;
    }

    public BinaryMessageBuilder addServiceName(String serviceName) {
        this.serviceName = serviceName;
        return this;
    }

    public BinaryMessageBuilder addMessage(AbstractMessage message) {
        this.message = message;
        return this;
    }

    public byte[] build() {
        MessagePacket messagePacket = new MessagePacket(sender, receiver, serviceName , protocols, message);
        messagePacket.getMessage().setSender(sender);
        messagePacket.getMessage().setReceiver(receiver);
        messagePacket.getMessage().setServiceName(serviceName);
        return BinaryMessageMarshaller.marshall(messagePacket);
    }
}
