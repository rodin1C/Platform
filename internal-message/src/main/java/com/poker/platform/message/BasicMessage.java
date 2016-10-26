package com.poker.platform.message;

import java.io.Serializable;

public class BasicMessage<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer to;
    private T message;

    public BasicMessage() {
    }

    public BasicMessage(Integer to, T message) {
        this.to = to;
        this.message = message;
    }

    public Integer getTo() {
        return to;
    }

    public T getMessage() {
        return message;
    }

    public void setTo(Integer to) {
        this.to = to;
    }

    public void setMessage(T message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "BasicMessage{" +
                "to=" + to +
                ", message=" + message +
                '}';
    }
}
