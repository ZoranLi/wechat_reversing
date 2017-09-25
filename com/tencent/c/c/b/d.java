package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class d extends JceStruct {
    public int czn = 0;
    public String hwe = "";
    public String model = "";
    public String platform = "";
    public String wSc = "";
    public String wSd = "";
    public int wSe = 0;
    public String wSf = "";

    public final JceStruct newInit() {
        return new d();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.wSc != null) {
            jceOutputStream.write(this.wSc, 0);
        }
        if (this.wSd != null) {
            jceOutputStream.write(this.wSd, 1);
        }
        if (this.hwe != null) {
            jceOutputStream.write(this.hwe, 2);
        }
        if (this.model != null) {
            jceOutputStream.write(this.model, 3);
        }
        if (this.wSe != 0) {
            jceOutputStream.write(this.wSe, 4);
        }
        if (this.wSf != null) {
            jceOutputStream.write(this.wSf, 5);
        }
        if (this.platform != null) {
            jceOutputStream.write(this.platform, 6);
        }
        if (this.czn != 0) {
            jceOutputStream.write(this.czn, 7);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.wSc = jceInputStream.readString(0, false);
        this.wSd = jceInputStream.readString(1, false);
        this.hwe = jceInputStream.readString(2, false);
        this.model = jceInputStream.readString(3, false);
        this.wSe = jceInputStream.read(this.wSe, 4, false);
        this.wSf = jceInputStream.readString(5, false);
        this.platform = jceInputStream.readString(6, false);
        this.czn = jceInputStream.read(this.czn, 7, false);
    }
}
