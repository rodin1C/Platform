package com.poker.platform.protocol;


import com.poker.platform.protocol.model.Protocols;
import com.poker.platform.protocol.model.RouterType;

import java.io.Serializable;

public class BinaryMessagePacket implements Serializable {
    private static final long serialVersionUID = 1L;
    private Protocols protocol;
    private int messageLength;
    private RouterType sender;
    private RouterType receiver;
    private String serviceName;
}
