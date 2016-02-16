package com.poker.platform.protocol.marshaller;

import com.google.gson.Gson;
import com.poker.platform.protocol.MessagePacket;
import com.poker.platform.protocol.model.MessageCode;
import com.poker.platform.protocol.model.network.Ping;
import com.poker.platform.protocol.model.Protocols;
import com.poker.platform.protocol.util.ByteArrayUtil;

import java.lang.reflect.Type;
import java.nio.ByteBuffer;
import java.util.EnumMap;
import java.util.Optional;

public class BinaryMessageMarshaller {

    private static JsonBinaryMarshaller jsonBinaryMarshaller = new JsonBinaryMarshaller();


    /**
     * 4 - protocol, 4 - message code, 4 - length
     * @param packet
     * @return
     */
    public static byte[] marshall(MessagePacket<?> packet) {
        byte[] msg = null;
        switch (packet.getProtocol()) {
            case JSON_BINARY:
                msg = jsonBinaryMarshaller.toByteArray(packet.getMessage());
            case BINARY:
        }
        ByteBuffer buffer = ByteBuffer.allocate(msg.length + 12);
        buffer.putInt(packet.getProtocol().getCode());
        buffer.putInt(packet.getMessage().getMessageCode().getCode());
        buffer.putInt(msg.length);
        buffer.put(msg);
        return buffer.array();
    }

    public static MessagePacket<?> unmarshall(byte[] array) {
        ByteBuffer buffer = ByteBuffer.wrap(array);
        int protocol = buffer.getInt();
        Optional<Protocols> protocols = Protocols.getByCode(protocol);
        int code = buffer.getInt();
        Optional<MessageCode> messageCode = MessageCode.getByCode(code);
        int length = buffer.getInt();
        byte[] newMsg = ByteArrayUtil.extractSubArray(buffer, 0, length);
//        byte[] newMsg = new byte[length];
//        System.arraycopy(buffer.array(), buffer.position(), newMsg, 0, length);
        String msg = new String(newMsg);
        Gson gson = new Gson();
        return new MessagePacket(protocols.get(), gson.fromJson(msg, (Type) messageCode.get().getClazz()));
    }
}
