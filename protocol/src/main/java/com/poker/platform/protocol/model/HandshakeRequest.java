package com.poker.platform.protocol.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class HandshakeRequest extends AbstractMessage {
    private static final long serialVersionUID = 1L;
    private String ipAddress;
    private String userName;

    public HandshakeRequest() {
        super(MessageCode.HANDSHAKE_REQUEST);
    }

    public HandshakeRequest(MessageCode messageCode, String ipAddress, String userName) {
        super(messageCode);
        this.ipAddress = ipAddress;
        this.userName = userName;
    }

    @XmlElement
    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    @XmlElement
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
