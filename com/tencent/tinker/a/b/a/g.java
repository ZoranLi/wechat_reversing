package com.tencent.tinker.a.b.a;

import java.io.EOFException;

public final class g extends a {
    final short[] xdt;

    public g(short[] sArr) {
        if (sArr == null) {
            throw new NullPointerException("array == null");
        }
        this.xdt = sArr;
    }

    public final int read() {
        try {
            short s = this.xdt[this.xdl];
            cgI();
            return s & 65535;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new EOFException();
        }
    }

    public final int readInt() {
        return read() | (read() << 16);
    }

    public final long readLong() {
        return ((((long) read()) | (((long) read()) << 16)) | (((long) read()) << 32)) | (((long) read()) << 48);
    }
}
