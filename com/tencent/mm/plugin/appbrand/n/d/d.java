package com.tencent.mm.plugin.appbrand.n.d;

import java.nio.ByteBuffer;

public interface d {

    public enum a {
        CONTINUOUS,
        TEXT,
        BINARY,
        PING,
        PONG,
        CLOSING
    }

    ByteBuffer XW();

    boolean XX();

    boolean XY();

    a XZ();

    void e(d dVar);
}
