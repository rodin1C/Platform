package com.poker.platform.protocol;

import com.google.gson.Gson;
import com.poker.platform.protocol.marshaller.BinaryMessageMarshaller;
import com.poker.platform.protocol.model.network.Ping;
import com.poker.platform.protocol.model.Protocols;
import org.junit.Test;

public class BinaryMessageMarshallerTest {

    @Test
    public void test() {
        Gson gson = new Gson();
        Ping ping = new Ping();
        MessagePacket<Ping> packet = new MessagePacket(Protocols.JSON_BINARY, ping);
        byte[] bytes = BinaryMessageMarshaller.marshall(packet);
        MessagePacket<?> unmarshall = BinaryMessageMarshaller.unmarshall(bytes);


    }
}
