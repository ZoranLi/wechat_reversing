package com.tencent.mm.plugin.h.a.b.a;

import com.tencent.mm.plugin.h.a.b.h;

public class e extends a {
    static final String TAG = e.class.getName();
    public static final String jTD = h.jSv;
    public static final String jTE = h.jSw;
    public static final String jTF = h.jSx;
    public static final String jTG = h.jSy;
    public byte jTH;
    public byte jTI;
    public byte jTJ;
    public byte jTK;
    public byte[] jTL;
    public int jTM;
    public byte jTN;
    public byte jTO;
    public byte[] jTP;

    public e() {
        this.jSL = null;
        this.jSM = 8;
        this.jSe = 16;
        this.jTH = (byte) 0;
        this.jTI = (byte) 0;
        this.jTJ = (byte) 0;
        this.jTK = (byte) 0;
        this.jTL = new byte[]{(byte) 0, (byte) 0};
        this.jTM = -1;
        this.jTN = (byte) 0;
        this.jTO = (byte) 0;
        this.jTP = null;
    }

    public final byte[] adj() {
        if (this.jSL.equalsIgnoreCase(jTD)) {
            Object obj = new byte[3];
            System.arraycopy(Byte.valueOf(this.jTH), 0, obj, 0, 1);
            System.arraycopy(Byte.valueOf(this.jTI), 0, obj, 1, 1);
            System.arraycopy(Byte.valueOf(this.jTJ), 0, obj, 2, 1);
            return obj;
        } else if (this.jSL.equalsIgnoreCase(jTE)) {
            r0 = new byte[1];
            System.arraycopy(Byte.valueOf(this.jTK), 0, r0, 0, 1);
            return r0;
        } else if (!this.jSL.equalsIgnoreCase(jTG)) {
            return null;
        } else {
            r0 = new byte[this.jTM];
            byte b = (byte) ((this.jTM >> 8) & 255);
            System.arraycopy(Byte.valueOf((byte) (this.jTM & 255)), 0, r0, 0, 1);
            System.arraycopy(Byte.valueOf(b), 0, r0, 1, 1);
            System.arraycopy(Byte.valueOf(this.jTN), 0, r0, 2, 1);
            if (this.jTM <= 3) {
                return r0;
            }
            System.arraycopy(this.jTP, 0, r0, 3, this.jTM - 3);
            return r0;
        }
    }
}
