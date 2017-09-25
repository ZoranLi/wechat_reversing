package com.tencent.mm.plugin.exdevice.b;

import com.tencent.mm.bd.a;
import com.tencent.mm.plugin.exdevice.e.e;

public abstract class c {
    public long jUL = -1;
    public short lax = (short) -1;
    public e lay = null;
    protected a laz = null;

    public abstract short aoP();

    public abstract short aoQ();

    public abstract byte[] aoR();

    protected final e J(int i, String str) {
        this.lay = new e();
        this.lay.leR = i;
        this.lay.leS = str;
        return this.lay;
    }
}
