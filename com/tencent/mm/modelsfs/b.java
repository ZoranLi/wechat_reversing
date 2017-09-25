package com.tencent.mm.modelsfs;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.FileInputStream;

public final class b extends FileInputStream {
    private boolean hRa = false;
    private a hRe;
    private long hRf = 0;

    public b(String str, long j) {
        super(str);
        this.hRe = new a(j);
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (this.hRa) {
            w.i("MicroMsg.EncInputStream", "read buffer  hashcode " + hashCode() + " " + bg.bJZ().toString());
        }
        int read = super.read(bArr, i, i2);
        if (read >= 0) {
            this.hRe.j(bArr, i2);
        }
        return read;
    }

    public final long skip(long j) {
        long skip = super.skip(j);
        this.hRe.seek(j);
        return skip;
    }

    public final void close() {
        super.close();
        if (this.hRe != null) {
            this.hRe.free();
        }
        w.i("MicroMsg.EncInputStream", "close  hashcode " + hashCode());
    }

    public final void mark(int i) {
        this.hRf = this.hRe.IJ();
    }

    public final void reset() {
        getChannel().position(this.hRf);
        this.hRe.reset();
    }

    public final boolean markSupported() {
        return true;
    }
}
