package com.poker.platform.botclient;

public interface ClientListener<T> {

    void onMessage(T msg);
}
