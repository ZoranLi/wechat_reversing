package com.tencent.mm.modelsfs;

import java.io.File;
import java.io.FileOutputStream;

public final class c extends FileOutputStream {
    private a hRe;

    public c(File file, long j) {
        super(file);
        this.hRe = new a(j);
    }

    public c(String str, String str2) {
        super(str);
        this.hRe = new a(str2);
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
}
