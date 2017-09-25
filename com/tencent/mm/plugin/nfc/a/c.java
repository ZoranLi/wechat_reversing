package com.tencent.mm.plugin.nfc.a;

import com.tencent.mm.plugin.nfc.c.a;
import java.io.Serializable;
import java.util.Arrays;

public final class c implements Serializable {
    public byte[] nYV;

    public c(byte[] bArr) {
        if (bArr == null) {
            throw new IllegalArgumentException("apdu is null");
        }
        byte[] bArr2 = (byte[]) bArr.clone();
        if (bArr2.length < 2) {
            throw new IllegalArgumentException("apdu must be at least 2 bytes long");
        }
        this.nYV = bArr2;
    }

    public final short aOX() {
        return (short) (this.nYV[this.nYV.length - 2] & 255);
    }

    public final short aOY() {
        return (short) (this.nYV[this.nYV.length - 1] & 255);
    }

    public final String toString() {
        return a.aB(this.nYV);
    }

    public final void a(c cVar) {
        int length = this.nYV.length;
        this.nYV = Arrays.copyOf(this.nYV, (this.nYV.length + cVar.nYV.length) - 2);
        int i = length - 2;
        byte[] bArr = (byte[]) cVar.nYV.clone();
        int length2 = bArr.length;
        int i2 = 0;
        while (i2 < length2) {
            int i3 = i + 1;
            this.nYV[i] = bArr[i2];
            i2++;
            i = i3;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        return Arrays.equals(this.nYV, ((c) obj).nYV);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.nYV);
    }
}
