package com.poker.platform.protocol.util;

import java.nio.ByteBuffer;

public final class ByteArrayUtil {

    public static byte[] extractSubArray(ByteBuffer buffer, int offset, int length) {
        byte[] newArray = new byte[length];
        System.arraycopy(buffer.array(), buffer.position(), newArray, offset, length);
        return newArray;
    }
}
