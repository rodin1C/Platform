package com.poker.platform.protocol.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum Protocols {
    BINARY(1),
    JSON_BINARY(2),
    JSON_BINARY_ZIPPED(3),
    ;

    private final int code;

    Protocols(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Optional<Protocols> getByCode(final int code) {
        List<Protocols> list = Arrays.asList(Protocols.values());
        return list.stream().filter(i -> i.code == code).findFirst();
    }
}
