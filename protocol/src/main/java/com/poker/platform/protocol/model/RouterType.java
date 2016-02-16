package com.poker.platform.protocol.model;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public enum RouterType {
    DESKTOP_CLIENT(1),
    GAME(2),
    CHANNEL(3),
    ACCOUNT(4),
    ;

    private final int code;
    RouterType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Optional<RouterType> getByCode(final int code) {
        List<RouterType> list = Arrays.asList(RouterType.values());
        return list.stream().filter(i -> i.code == code).findFirst();
    }
}
