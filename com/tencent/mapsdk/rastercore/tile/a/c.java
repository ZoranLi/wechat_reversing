package com.tencent.mapsdk.rastercore.tile.a;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public final class c {
    private String a = "md5";
    private byte[] b;
    private int c = -1;

    public c(byte[] bArr, int i) {
        this.b = bArr;
        this.c = i;
    }

    public c(byte[] bArr, int i, String str) {
        this.b = bArr;
        this.c = i;
        this.a = str;
    }

    public final String a() {
        return this.a;
    }

    public final Bitmap b() {
        return this.b == null ? null : BitmapFactory.decodeByteArray(this.b, 0, this.b.length);
    }

    public final byte[] c() {
        return this.b;
    }

    public final int d() {
        return this.c;
    }
}
