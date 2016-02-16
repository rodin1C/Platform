package com.poker.platform.protocol.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HandshakeResponse extends AbstractMessage {
    private static final long serialVersionUID = 1L;

    private String serverTime;
    private STATUS status;

    public HandshakeResponse() {
        super(MessageCode.HANDSHAKE_RESPONSE);
    }

    public HandshakeResponse(MessageCode messageCode, String serverTime, STATUS status) {
        super(messageCode);
        this.serverTime = serverTime;
        this.status = status;
    }

    @XmlElement
    public String getServerTime() {
        return serverTime;
    }

    @XmlElement
    public STATUS getStatus() {
        return status;
    }

    @XmlRootElement
    public static enum STATUS {
        SUCCESS,
        REJECT,
        ;
    }
}
