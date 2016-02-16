package com.poker.platform.botclient;

import com.poker.platform.protocol.MessagePacket;
import com.poker.platform.protocol.builder.BinaryMessageBuilder;
import com.poker.platform.protocol.model.RouterType;
import com.poker.platform.protocol.model.network.Ping;
import com.poker.platform.protocol.model.Protocols;

import java.io.*;

public class BotClient {
    public static void main(String[] args) {
        try {
            TCPClient client = new TCPClient("localhost", 24333);
            client.registerListener(new ClientListener<String>() {
                @Override
                public void onMessage(String msg) {

                }
            });
            client.connect();
            BinaryMessageBuilder builder = new BinaryMessageBuilder(RouterType.DESKTOP_CLIENT, RouterType.CHANNEL);
            builder.addProtocol(Protocols.JSON_BINARY);
            builder.addMessage(new Ping());

            client.writeMessage(builder);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
