package com.poker.platform.botclient;

import com.google.gson.Gson;
import com.poker.platform.protocol.MessagePacket;
import com.poker.platform.protocol.builder.BinaryMessageBuilder;
import com.poker.platform.protocol.marshaller.BinaryMessageMarshaller;
import com.poker.platform.protocol.model.Protocols;

import java.io.*;
import java.net.Socket;
import java.util.Optional;

public class TCPClient {
    private final String host;
    private final int port;
    private ClientListener<?> clientListener;
    private Socket socket;
    private DataOutputStream writer;
    private DataInputStream reader;

    public TCPClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void connect() throws IOException {
        socket = new Socket(host, port);
        writer = new DataOutputStream(socket.getOutputStream());
        reader = new DataInputStream(socket.getInputStream());
        new Thread(new ReaderHandler(reader)).start();
    }

    public void registerListener(ClientListener<?> clientListener) {
        this.clientListener = clientListener;
    }

    private static class ReaderHandler implements Runnable {
        private DataInputStream reader;
        private Gson marshaller;

        public ReaderHandler(DataInputStream reader) {
            this.reader = reader;
            marshaller = new Gson();
        }

        @Override
        public void run() {
            try {
                int protocol = reader.readInt();
                if (protocol > 0) {
                    Optional<Protocols> protocols = Protocols.getByCode(protocol);
                    int lengthMsg = reader.readInt();
                    byte[] msgArray = new byte[lengthMsg];
                    reader.readFully(msgArray, 0, msgArray.length);
                    if (protocols.isPresent()) {
                        if (protocols.get() == Protocols.JSON_BINARY) {
                            String msg = new String(msgArray);

                            System.out.println("Receive: "+msg);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void writeMessage(MessagePacket packet) {
        try {
            writer.write(BinaryMessageMarshaller.marshall(packet));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeMessage(byte[] msg) {
        try {
            writer.write(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeMessage(BinaryMessageBuilder builder) {
        try {
            writer.write(builder.build());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
