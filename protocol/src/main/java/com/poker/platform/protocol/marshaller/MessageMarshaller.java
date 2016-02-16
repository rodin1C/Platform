package com.poker.platform.protocol.marshaller;

import com.poker.platform.protocol.model.MessageCode;

/**
 *
 * @param <M> source Message
 * @param <S> Stream, byte, string e.g.
 */
public interface MessageMarshaller<M, S> {

    S marshall(M message);

    M unmarshall(S stream, MessageCode messageCode);
}
