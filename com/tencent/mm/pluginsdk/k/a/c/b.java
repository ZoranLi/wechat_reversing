package com.tencent.mm.pluginsdk.k.a.c;

import java.io.IOException;

public final class b extends IOException {
    private final long gan;
    private final long sGo;

    public b() {
        this(0, 0);
    }

    public b(long j, long j2) {
        super(String.format("contentLength: %d, requestRange:%d", new Object[]{Long.valueOf(j), Long.valueOf(j2)}));
        this.gan = j;
        this.sGo = j2;
    }

    public final String toString() {
        return "FileSizeOutOfRangeException{contentLength=" + this.gan + ", requestRange=" + this.sGo + '}';
    }
}
