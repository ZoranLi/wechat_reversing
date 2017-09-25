package com.tencent.mm.bd;

import java.io.UnsupportedEncodingException;

public final class b {
    public byte[] sYA;

    private b() {
    }

    public b(byte[] bArr) {
        this(bArr, 0, bArr.length);
    }

    public b(byte[] bArr, int i, int i2) {
        this.sYA = new byte[i2];
        System.arraycopy(bArr, i, this.sYA, 0, i2);
    }

    public static b h(byte[] bArr, int i, int i2) {
        return new b(bArr, i, i2);
    }

    public static b aU(byte[] bArr) {
        if (bArr == null) {
            bArr = new byte[0];
        }
        return new b(bArr);
    }

    public static b NG(String str) {
        try {
            b bVar = new b();
            bVar.sYA = str.getBytes("UTF-8");
            return bVar;
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public final b xV(int i) {
        Object obj = new byte[i];
        if (this.sYA.length >= i) {
            System.arraycopy(this.sYA, 0, obj, 0, i - 1);
            this.sYA = obj;
        } else {
            System.arraycopy(this.sYA, 0, obj, 0, this.sYA.length);
            this.sYA = obj;
        }
        return this;
    }

    public final byte[] toByteArray() {
        int length = this.sYA.length;
        Object obj = new byte[length];
        System.arraycopy(this.sYA, 0, obj, 0, length);
        return obj;
    }

    public final String bGX() {
        int i = 0;
        while (i < this.sYA.length && this.sYA[i] != (byte) 0) {
            try {
                i++;
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException("UTF-8 not supported?");
            }
        }
        return new String(this.sYA, 0, i, "UTF-8");
    }
}
