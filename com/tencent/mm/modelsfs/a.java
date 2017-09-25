package com.tencent.mm.modelsfs;

import com.tencent.mm.plugin.imgenc.MMIMAGEENCJNI;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    private static boolean hRa = false;
    private long hRb = 0;
    private String hRc;
    private long hRd = 0;
    private long mNativePtr = 0;

    public a(long j) {
        this.hRc = String.valueOf(j);
        init();
    }

    public a(String str) {
        this.hRc = str;
        init();
    }

    private void init() {
        w.i("MicroMsg.EncEngine", "init  key  enckey " + this.hRc + "  hashcode " + hashCode());
        this.mNativePtr = MMIMAGEENCJNI.open(this.hRc);
        try {
            w.i("MicroMsg.EncEngine", "mNativePtr " + this.mNativePtr + " " + hashCode());
        } catch (Exception e) {
            w.e("MicroMsg.EncEngine", "exception " + e.getMessage());
        }
    }

    public final void reset() {
        w.i("MicroMsg.EncEngine", "reset " + bg.bJZ());
        free();
        if (this.hRd == 0) {
            init();
            this.hRb = 0;
            return;
        }
        init();
        MMIMAGEENCJNI.seek(this.mNativePtr, this.hRd, 1);
        this.hRb = this.hRd;
    }

    public final long IJ() {
        this.hRd = this.hRb;
        return this.hRd;
    }

    public final int j(byte[] bArr, int i) {
        if (this.mNativePtr == 0) {
            w.i("MicroMsg.EncEngine", "transFor " + bg.bJZ().toString());
        }
        if (hRa) {
            w.i("MicroMsg.EncEngine", "trans for  " + hashCode() + " " + bArr.length);
        }
        if (hRa && this.hRb < 64) {
            w.d("MicroMsg.EncEngine", "dump before _offset " + this.hRb + "  length:" + i + " " + bg.bl(bArr) + " hashcode " + hashCode());
        }
        MMIMAGEENCJNI.transFor(this.mNativePtr, bArr, this.hRb, (long) i);
        if (hRa && this.hRb < 64) {
            w.d("MicroMsg.EncEngine", "dump after _offset " + this.hRb + "  length:" + i + " " + bg.bl(bArr) + " hashcode " + hashCode());
        }
        this.hRb += (long) i;
        return i;
    }

    public final void seek(long j) {
        this.hRb = j;
        MMIMAGEENCJNI.seek(this.mNativePtr, j, 1);
    }

    public final void free() {
        w.i("MicroMsg.EncEngine", "free mNativePtr: " + this.mNativePtr + " hashcode " + hashCode());
        MMIMAGEENCJNI.free(this.mNativePtr);
        this.mNativePtr = 0;
    }
}
