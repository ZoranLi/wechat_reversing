package com.tencent.c.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class a extends JceStruct {
    public int wQR = 0;
    public int wQS = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.wQR, 0);
        jceOutputStream.write(this.wQS, 1);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.wQR = jceInputStream.read(this.wQR, 0, true);
        this.wQS = jceInputStream.read(this.wQS, 1, false);
    }
}
