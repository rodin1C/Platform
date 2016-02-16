package com.poker.platform.communication.decoder;

import com.poker.platform.protocol.marshaller.MessageMarshaller;
import com.poker.platform.protocol.model.AbstractMessage;
import com.poker.platform.protocol.model.MessageCode;
import com.poker.platform.protocol.model.Protocols;
import com.poker.platform.protocol.util.ByteArrayUtil;
import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.frame.FrameDecoder;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class MultiProtocolDecoder extends FrameDecoder{
    private Map<Protocols, MessageMarshaller<AbstractMessage, byte[]>> marshallers = new EnumMap<Protocols, MessageMarshaller<AbstractMessage, byte[]>>(Protocols.class);


    @Override
    protected Object decode(ChannelHandlerContext ctx, Channel channel, ChannelBuffer buffer) throws Exception {
        if (buffer.readableBytes() < 4) {
            return null;
        }

        int protocol = buffer.readInt();
        Optional<Protocols> protocols = Protocols.getByCode(protocol);
        int code = buffer.readInt();
        Optional<MessageCode> messageCode = MessageCode.getByCode(code);
        int length = buffer.readInt();
        byte[] msg = ByteArrayUtil.extractSubArray(buffer.toByteBuffer(), 0, length);
        return new String(msg);
//        return new MessagePacket<Pong>(protocols.get(), new Pong());
    }
}
