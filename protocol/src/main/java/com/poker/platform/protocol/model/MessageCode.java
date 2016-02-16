package com.poker.platform.protocol.model;

import com.poker.platform.protocol.model.network.Ping;
import com.poker.platform.protocol.model.network.Pong;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@XmlRootElement
public enum MessageCode {
    PING(1, Ping.class),
    PONG(2, Pong.class),
    HANDSHAKE_REQUEST(1000, HandshakeRequest.class),
    HANDSHAKE_RESPONSE(1001, HandshakeResponse.class),
    ;

    private int code;
    private Class<?> clazz;

    MessageCode(int code, Class<?> clazz) {
        this.code = code;
        this.clazz = clazz;
    }

    public int getCode() {
        return code;
    }

    public Class<?> getClazz() {
        return clazz;
    }

    public static Optional<MessageCode> getByCode(int code) {
        List<MessageCode> messageCodes = Arrays.asList(values());
        return messageCodes.stream().filter(i -> i.code == code).findFirst();
    }
}
