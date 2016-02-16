package com.poker.platform.protocol.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class AbstractMessage implements Serializable {
    private static final long serialVersionUID = 1L;
    @XmlElement(required = true)
    private final MessageCode messageCode;
    @XmlElement
    private int sender;
    @XmlElement
    private int receiver;
    @XmlElement
    private String serviceName;

    public AbstractMessage(MessageCode messageCode) {
        this.messageCode = messageCode;
    }

    public MessageCode getMessageCode() {
        return messageCode;
    }

    public Class<?> getMessageClass() {
        return messageCode.getClazz();
    }

    public int getSender() {
        return sender;
    }

    public void setSender(RouterType sender) {
        this.sender = sender.getCode();
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(RouterType receiver) {
        this.receiver = receiver.getCode();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }
}
