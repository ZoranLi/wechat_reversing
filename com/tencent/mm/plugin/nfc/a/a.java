package com.tencent.mm.plugin.nfc.a;

import java.io.Serializable;
import java.util.Arrays;

public final class a implements Serializable {
    private byte[] nYV;
    private transient int nYW;
    private transient int nYX;
    private transient int nYY;

    public a(byte[] bArr) {
        this.nYV = (byte[]) bArr.clone();
        aOW();
    }

    public a(String str) {
        this.nYV = com.tencent.mm.plugin.nfc.c.a.BL(str);
        aOW();
    }

    private void aOW() {
        int i = 65536;
        int i2 = 256;
        if (this.nYV.length < 4) {
            throw new IllegalArgumentException("apdu must be at least 4 bytes long");
        } else if (this.nYV.length != 4) {
            int i3 = this.nYV[4] & 255;
            if (this.nYV.length == 5) {
                if (i3 != 0) {
                    i2 = i3;
                }
                this.nYX = i2;
            } else if (i3 != 0) {
                if (this.nYV.length == i3 + 5) {
                    this.nYW = i3;
                    this.nYY = 5;
                } else if (this.nYV.length == i3 + 6) {
                    this.nYW = i3;
                    this.nYY = 5;
                    i3 = this.nYV[this.nYV.length - 1] & 255;
                    if (i3 != 0) {
                        i2 = i3;
                    }
                    this.nYX = i2;
                } else {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.nYV.length + ", b1=" + i3);
                }
            } else if (this.nYV.length < 7) {
                throw new IllegalArgumentException("Invalid APDU: length=" + this.nYV.length + ", b1=" + i3);
            } else {
                i2 = ((this.nYV[5] & 255) << 8) | (this.nYV[6] & 255);
                if (this.nYV.length == 7) {
                    if (i2 == 0) {
                        i2 = 65536;
                    }
                    this.nYX = i2;
                } else if (i2 == 0) {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.nYV.length + ", b1=" + i3 + ", b2||b3=" + i2);
                } else if (this.nYV.length == i2 + 7) {
                    this.nYW = i2;
                    this.nYY = 7;
                } else if (this.nYV.length == i2 + 9) {
                    this.nYW = i2;
                    this.nYY = 7;
                    i2 = this.nYV.length - 2;
                    i2 = (this.nYV[i2 + 1] & 255) | ((this.nYV[i2] & 255) << 8);
                    if (i2 != 0) {
                        i = i2;
                    }
                    this.nYX = i;
                } else {
                    throw new IllegalArgumentException("Invalid APDU: length=" + this.nYV.length + ", b1=" + i3 + ", b2||b3=" + i2);
                }
            }
        }
    }

    public final void qv(int i) {
        this.nYX = i;
        this.nYV[this.nYV.length - 1] = (byte) i;
    }

    public final byte[] getBytes() {
        return (byte[]) this.nYV.clone();
    }

    public final String toString() {
        return com.tencent.mm.plugin.nfc.c.a.aB(this.nYV);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return Arrays.equals(this.nYV, ((a) obj).nYV);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.nYV);
    }
}
