package com.tencent.c.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class c extends JceStruct {
    static b wRn = new b();
    public String guid = "";
    public String imei = "";
    public String imsi = "";
    public String ip = "";
    public String kdW = "";
    public double latitude = 0.0d;
    public double longitude = 0.0d;
    public String mry = "";
    public String qdX = "";
    public String wQW = "";
    public String wQX = "";
    public String wQY = "";
    public int wQZ = 0;
    public int wRa = 0;
    public b wRb = null;
    public int wRc = 0;
    public int wRd = 0;
    public int wRe = 0;
    public int wRf = 0;
    public short wRg = (short) 0;
    public String wRh = "";
    public int wRi = 0;
    public String wRj = "";
    public String wRk = "";
    public String wRl = "";
    public String wRm = "";
    public String whm = "";

    public final JceStruct newInit() {
        return new c();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.imei, 0);
        if (this.whm != null) {
            jceOutputStream.write(this.whm, 1);
        }
        if (this.kdW != null) {
            jceOutputStream.write(this.kdW, 2);
        }
        if (this.ip != null) {
            jceOutputStream.write(this.ip, 3);
        }
        if (this.wQW != null) {
            jceOutputStream.write(this.wQW, 4);
        }
        if (this.wQX != null) {
            jceOutputStream.write(this.wQX, 5);
        }
        if (this.wQY != null) {
            jceOutputStream.write(this.wQY, 6);
        }
        if (this.wQZ != 0) {
            jceOutputStream.write(this.wQZ, 7);
        }
        if (this.wRa != 0) {
            jceOutputStream.write(this.wRa, 8);
        }
        if (this.wRb != null) {
            jceOutputStream.write(this.wRb, 9);
        }
        if (this.guid != null) {
            jceOutputStream.write(this.guid, 10);
        }
        if (this.imsi != null) {
            jceOutputStream.write(this.imsi, 11);
        }
        if (this.wRc != 0) {
            jceOutputStream.write(this.wRc, 12);
        }
        if (this.wRd != 0) {
            jceOutputStream.write(this.wRd, 13);
        }
        if (this.wRe != 0) {
            jceOutputStream.write(this.wRe, 14);
        }
        if (this.wRf != 0) {
            jceOutputStream.write(this.wRf, 15);
        }
        if (this.mry != null) {
            jceOutputStream.write(this.mry, 16);
        }
        if (this.wRg != (short) 0) {
            jceOutputStream.write(this.wRg, 17);
        }
        if (this.longitude != 0.0d) {
            jceOutputStream.write(this.longitude, 18);
        }
        if (this.latitude != 0.0d) {
            jceOutputStream.write(this.latitude, 19);
        }
        if (this.wRh != null) {
            jceOutputStream.write(this.wRh, 20);
        }
        if (this.wRi != 0) {
            jceOutputStream.write(this.wRi, 21);
        }
        if (this.wRj != null) {
            jceOutputStream.write(this.wRj, 22);
        }
        if (this.wRk != null) {
            jceOutputStream.write(this.wRk, 23);
        }
        if (this.qdX != null) {
            jceOutputStream.write(this.qdX, 24);
        }
        if (this.wRl != null) {
            jceOutputStream.write(this.wRl, 25);
        }
        if (this.wRm != null) {
            jceOutputStream.write(this.wRm, 26);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.imei = jceInputStream.readString(0, true);
        this.whm = jceInputStream.readString(1, false);
        this.kdW = jceInputStream.readString(2, false);
        this.ip = jceInputStream.readString(3, false);
        this.wQW = jceInputStream.readString(4, false);
        this.wQX = jceInputStream.readString(5, false);
        this.wQY = jceInputStream.readString(6, false);
        this.wQZ = jceInputStream.read(this.wQZ, 7, false);
        this.wRa = jceInputStream.read(this.wRa, 8, false);
        this.wRb = (b) jceInputStream.read(wRn, 9, false);
        this.guid = jceInputStream.readString(10, false);
        this.imsi = jceInputStream.readString(11, false);
        this.wRc = jceInputStream.read(this.wRc, 12, false);
        this.wRd = jceInputStream.read(this.wRd, 13, false);
        this.wRe = jceInputStream.read(this.wRe, 14, false);
        this.wRf = jceInputStream.read(this.wRf, 15, false);
        this.mry = jceInputStream.readString(16, false);
        this.wRg = jceInputStream.read(this.wRg, 17, false);
        this.longitude = jceInputStream.read(this.longitude, 18, false);
        this.latitude = jceInputStream.read(this.latitude, 19, false);
        this.wRh = jceInputStream.readString(20, false);
        this.wRi = jceInputStream.read(this.wRi, 21, false);
        this.wRj = jceInputStream.readString(22, false);
        this.wRk = jceInputStream.readString(23, false);
        this.qdX = jceInputStream.readString(24, false);
        this.wRl = jceInputStream.readString(25, false);
        this.wRm = jceInputStream.readString(26, false);
    }
}
