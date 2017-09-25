package com.tencent.mm.ah.a.d;

import android.graphics.Bitmap;

public final class b {
    public Bitmap bitmap;
    public byte[] data;
    public int fFr;
    public String gam;
    public int status;

    public b() {
        this.status = -1;
    }

    public b(Bitmap bitmap) {
        this.status = 0;
        this.fFr = 0;
        this.bitmap = bitmap;
    }

    public b(byte[] bArr, String str) {
        this.data = bArr;
        this.gam = str;
    }

    public b(byte[] bArr, String str, byte b) {
        this.data = bArr;
        this.fFr = 2;
        this.gam = str;
    }
}
