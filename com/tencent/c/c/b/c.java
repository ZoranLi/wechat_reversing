package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c extends JceStruct {
    static byte[] wSa;
    static byte[] wSb;
    public int hzR = 0;
    public int requestType = 0;
    public int wRR = 0;
    public int wRS = 0;
    public int wRT = 0;
    public byte[] wRU = null;
    public int wRV = 0;
    public long wRW = 0;
    public byte[] wRX = null;
    public int wRY = 0;
    public int wRZ = 0;
    public int wRi = 0;

    public final JceStruct newInit() {
        return new c();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.wRR != 0) {
            jceOutputStream.write(this.wRR, 0);
        }
        jceOutputStream.write(this.wRi, 1);
        jceOutputStream.write(this.requestType, 2);
        if (this.wRS != 0) {
            jceOutputStream.write(this.wRS, 3);
        }
        if (this.wRT != 0) {
            jceOutputStream.write(this.wRT, 4);
        }
        if (this.wRU != null) {
            jceOutputStream.write(this.wRU, 5);
        }
        if (this.wRV != 0) {
            jceOutputStream.write(this.wRV, 6);
        }
        if (this.hzR != 0) {
            jceOutputStream.write(this.hzR, 7);
        }
        if (this.wRW != 0) {
            jceOutputStream.write(this.wRW, 8);
        }
        if (this.wRX != null) {
            jceOutputStream.write(this.wRX, 9);
        }
        if (this.wRY != 0) {
            jceOutputStream.write(this.wRY, 10);
        }
        if (this.wRZ != 0) {
            jceOutputStream.write(this.wRZ, 11);
        }
    }

    static {
        byte[] bArr = new byte[1];
        wSa = bArr;
        bArr[0] = (byte) 0;
        bArr = new byte[1];
        wSb = bArr;
        bArr[0] = (byte) 0;
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.wRR = jceInputStream.read(this.wRR, 0, false);
        this.wRi = jceInputStream.read(this.wRi, 1, false);
        this.requestType = jceInputStream.read(this.requestType, 2, false);
        this.wRS = jceInputStream.read(this.wRS, 3, false);
        this.wRT = jceInputStream.read(this.wRT, 4, false);
        this.wRU = jceInputStream.read(wSa, 5, false);
        this.wRV = jceInputStream.read(this.wRV, 6, false);
        this.hzR = jceInputStream.read(this.hzR, 7, false);
        this.wRW = jceInputStream.read(this.wRW, 8, false);
        this.wRX = jceInputStream.read(wSb, 9, false);
        this.wRY = jceInputStream.read(this.wRY, 10, false);
        this.wRZ = jceInputStream.read(this.wRZ, 11, false);
    }
}
