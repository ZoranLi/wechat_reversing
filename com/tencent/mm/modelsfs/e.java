package com.tencent.mm.modelsfs;

public final class e extends SFSOutputStream {
    private a hRe;

    public e(long j, String str) {
        super(j);
        this.hRe = new a(str);
    }

    public final void write(int i) {
        super.write(i);
    }

    public final void write(byte[] bArr, int i, int i2) {
        this.hRe.j(bArr, i2);
        super.write(bArr, i, i2);
    }

    public final void close() {
        super.close();
        if (this.hRe != null) {
            this.hRe.free();
        }
    }

    protected final void finalize() {
        super.finalize();
    }
}
