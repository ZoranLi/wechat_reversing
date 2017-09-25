package com.tencent.mm.plugin.webview.wepkg.c;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class b extends InputStream {
    private long size;
    private a srs;

    public b(File file, long j, long j2) {
        this.size = j2;
        this.srs = new a(new FileInputStream(file));
        dZ(j);
        this.srs.bAC();
    }

    public final int read() {
        if ((bAD() <= 0 ? 1 : null) != null) {
            return -1;
        }
        return this.srs.read();
    }

    public final int read(byte[] bArr) {
        return read(bArr, 0, bArr.length);
    }

    public final int read(byte[] bArr, int i, int i2) {
        long dY = dY((long) i2);
        if (dY != 0 || i2 <= 0) {
            return this.srs.read(bArr, i, (int) dY);
        }
        return -1;
    }

    public final long skip(long j) {
        return this.srs.skip(dY(j));
    }

    public final int available() {
        return (int) dY((long) this.srs.available());
    }

    private long dY(long j) {
        return Math.min(bAD(), j);
    }

    private long bAD() {
        return this.size - ((long) this.srs.count);
    }

    private void dZ(long j) {
        long j2 = 0;
        while (j2 < j) {
            long skip = this.srs.skip(j - j2);
            if (skip <= 0) {
                break;
            }
            j2 += skip;
        }
        if (j2 < j) {
            throw new IOException("could not seek pos " + j);
        }
    }
}
