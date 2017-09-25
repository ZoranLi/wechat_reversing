package com.tencent.mm.plugin.webview.wepkg.c;

import java.io.InputStream;

public final class a extends c {
    int count;

    public a(InputStream inputStream) {
        super(inputStream);
    }

    public final int read(byte[] bArr) {
        int read = super.read(bArr);
        this.count = (read >= 0 ? read : 0) + this.count;
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        this.count = (read >= 0 ? read : 0) + this.count;
        return read;
    }

    public final int read() {
        int read = super.read();
        this.count = (read >= 0 ? 1 : 0) + this.count;
        return read;
    }

    public final long skip(long j) {
        long skip = super.skip(j);
        this.count = (int) (((long) this.count) + skip);
        return skip;
    }

    public final synchronized int bAC() {
        int i;
        i = this.count;
        this.count = 0;
        return i;
    }
}
