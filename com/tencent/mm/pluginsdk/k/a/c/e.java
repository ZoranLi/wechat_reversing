package com.tencent.mm.pluginsdk.k.a.c;

import java.io.IOException;

public final class e extends IOException {
    public final int httpStatusCode;
    public final IOException sGp;

    public e(int i, IOException iOException) {
        this.httpStatusCode = i;
        this.sGp = iOException;
    }

    public final String toString() {
        return "UnknownConnectionError{httpStatusCode=" + this.httpStatusCode + ", realException=" + this.sGp + '}';
    }
}
