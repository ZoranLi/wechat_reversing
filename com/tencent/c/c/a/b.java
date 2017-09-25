package com.tencent.c.c.a;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;

public final class b extends JceStruct {
    public int wQT = 0;
    public int wQU = 0;
    public int wQV = 0;

    public final void writeTo(JceOutputStream jceOutputStream) {
        jceOutputStream.write(this.wQT, 1);
        jceOutputStream.write(this.wQU, 2);
        jceOutputStream.write(this.wQV, 3);
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.wQT = jceInputStream.read(this.wQT, 1, true);
        this.wQU = jceInputStream.read(this.wQU, 2, true);
        this.wQV = jceInputStream.read(this.wQV, 3, true);
    }
}
