package com.tencent.c.c.b;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class a extends JceStruct {
    static c wRr = new c();
    static ArrayList<b> wRs = new ArrayList();
    static d wRt = new d();
    public c wRo = null;
    public ArrayList<b> wRp = null;
    public d wRq = null;

    public final JceStruct newInit() {
        return new a();
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.wRo != null) {
            jceOutputStream.write(this.wRo, 0);
        }
        if (this.wRp != null) {
            jceOutputStream.write(this.wRp, 1);
        }
        if (this.wRq != null) {
            jceOutputStream.write(this.wRq, 2);
        }
    }

    static {
        wRs.add(new b());
    }

    public final void readFrom(JceInputStream jceInputStream) {
        this.wRo = (c) jceInputStream.read(wRr, 0, false);
        this.wRp = (ArrayList) jceInputStream.read(wRs, 1, false);
        this.wRq = (d) jceInputStream.read(wRt, 2, false);
    }
}
