package com.poker.platform.protocol.marshaller;


import com.google.gson.Gson;
import com.poker.platform.protocol.model.AbstractMessage;
import com.poker.platform.protocol.model.MessageCode;

import java.lang.reflect.Type;

public class JsonBinaryMarshaller implements MessageMarshaller<AbstractMessage, byte[]> {
    private Gson gson = new Gson();

    public byte[] toByteArray(Object message) {
        String json = gson.toJson(message);
        return json.getBytes();
    }

    public String toJson(Object message) {
        return gson.toJson(message);
    }


    @Override
    public byte[] marshall(AbstractMessage message) {
        String json = gson.toJson(message);
        return json.getBytes();
    }

    @Override
    public AbstractMessage unmarshall(byte[] stream, MessageCode code) {
        String msg = new String(stream);
        return gson.fromJson(msg, (Type) code.getClazz());
    }
}
