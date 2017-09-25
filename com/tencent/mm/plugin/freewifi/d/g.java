package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.plugin.freewifi.m;
import com.tencent.mm.protocal.c.yv;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.y.b.a;

public final class g extends c {
    protected final void awJ() {
        a aVar = new a();
        aVar.hsm = new yv();
        aVar.hsn = new yw();
        aVar.uri = "/cgi-bin/mmo2o-bin/getprotocol31schemaurl";
        aVar.hsl = 1746;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int getType() {
        return 1746;
    }

    public g(String str, String str2, String str3) {
        awJ();
        yv yvVar = (yv) this.gUA.hsj.hsr;
        yvVar.lTm = str;
        yvVar.lTn = str2;
        yvVar.lTo = str3;
        yvVar.tcy = m.awh();
    }

    public final String awT() {
        return ((yw) this.gUA.hsk.hsr).tFc;
    }
}
