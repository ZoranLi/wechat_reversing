package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class b extends JceStruct {
    static byte[] wRN;
    static byte[] wRO;
    static ArrayList<Integer> wRP = new ArrayList();
    static ArrayList<byte[]> wRQ = new ArrayList();
    public int wRA = 0;
    public String wRB = "";
    public int wRC = 0;
    public String wRD = "";
    public int wRE = 0;
    public int wRF = 0;
    public int wRG = 0;
    public ArrayList<Integer> wRH = null;
    public int wRI = 0;
    public boolean wRJ = false;
    public int wRK = 0;
    public int wRL = 0;
    public ArrayList<byte[]> wRM = null;
    public int wRu = 0;
    public byte[] wRv = null;
    public String wRw = "";
    public byte[] wRx = null;
    public long wRy = 0;
    public String wRz = "";

    public final JceStruct newInit() {
        return new b();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.wRu, 0);
        if (this.wRv != null) {
            jceOutputStream.write(this.wRv, 1);
        }
        if (this.wRw != null) {
            jceOutputStream.write(this.wRw, 2);
        }
        if (this.wRx != null) {
            jceOutputStream.write(this.wRx, 3);
        }
        if (this.wRy != 0) {
            jceOutputStream.write(this.wRy, 4);
        }
        if (this.wRz != null) {
            jceOutputStream.write(this.wRz, 5);
        }
        if (this.wRA != 0) {
            jceOutputStream.write(this.wRA, 6);
        }
        if (this.wRB != null) {
            jceOutputStream.write(this.wRB, 7);
        }
        if (this.wRC != 0) {
            jceOutputStream.write(this.wRC, 8);
        }
        if (this.wRD != null) {
            jceOutputStream.write(this.wRD, 9);
        }
        jceOutputStream.write(this.wRE, 10);
        if (this.wRF != 0) {
            jceOutputStream.write(this.wRF, 11);
        }
        if (this.wRG != 0) {
            jceOutputStream.write(this.wRG, 12);
        }
        if (this.wRH != null) {
            jceOutputStream.write(this.wRH, 13);
        }
        if (this.wRI != 0) {
            jceOutputStream.write(this.wRI, 14);
        }
        jceOutputStream.write(this.wRJ, 15);
        if (this.wRK != 0) {
            jceOutputStream.write(this.wRK, 16);
        }
        jceOutputStream.write(this.wRL, 17);
        if (this.wRM != null) {
            jceOutputStream.write(this.wRM, 18);
        }
    }

    static {
        byte[] bArr = new byte[1];
        wRN = bArr;
        bArr[0] = (byte) 0;
        bArr = new byte[1];
        wRO = bArr;
        bArr[0] = (byte) 0;
        wRP.add(Integer.valueOf(0));
        bArr = new byte[1];
        bArr[0] = (byte) 0;
        wRQ.add(bArr);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.wRu = jceInputStream.read(this.wRu, 0, true);
        this.wRv = jceInputStream.read(wRN, 1, false);
        this.wRw = jceInputStream.readString(2, false);
        this.wRx = jceInputStream.read(wRO, 3, false);
        this.wRy = jceInputStream.read(this.wRy, 4, false);
        this.wRz = jceInputStream.readString(5, false);
        this.wRA = jceInputStream.read(this.wRA, 6, false);
        this.wRB = jceInputStream.readString(7, false);
        this.wRC = jceInputStream.read(this.wRC, 8, false);
        this.wRD = jceInputStream.readString(9, false);
        this.wRE = jceInputStream.read(this.wRE, 10, false);
        this.wRF = jceInputStream.read(this.wRF, 11, false);
        this.wRG = jceInputStream.read(this.wRG, 12, false);
        this.wRH = (ArrayList) jceInputStream.read(wRP, 13, false);
        this.wRI = jceInputStream.read(this.wRI, 14, false);
        this.wRJ = jceInputStream.read(this.wRJ, 15, false);
        this.wRK = jceInputStream.read(this.wRK, 16, false);
        this.wRL = jceInputStream.read(this.wRL, 17, false);
        this.wRM = (ArrayList) jceInputStream.read(wRQ, 18, false);
    }
}
