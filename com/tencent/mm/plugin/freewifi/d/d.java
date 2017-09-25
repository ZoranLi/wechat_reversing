package com.tencent.mm.plugin.freewifi.d;

import com.tencent.mm.protocal.c.kn;
import com.tencent.mm.protocal.c.ko;
import com.tencent.mm.y.b.a;

public final class d extends c {
    protected final void awJ() {
        a aVar = new a();
        aVar.hsm = new kn();
        aVar.hsn = new ko();
        aVar.uri = "/cgi-bin/mmo2o-bin/checkifcallup";
        aVar.hsl = 1155;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int getType() {
        return 1155;
    }

    public d(String str, String str2, String str3, String str4, String str5, long j, String str6, String str7) {
        awJ();
        kn knVar = (kn) this.gUA.hsj.hsr;
        knVar.tqK = str;
        knVar.tqL = str2;
        knVar.tqM = str3;
        knVar.tqN = str4;
        knVar.tqO = str5;
        knVar.tqP = j;
        knVar.tqQ = str6;
        knVar.tqR = str7;
    }

    public final ko awR() {
        return (ko) this.gUA.hsk.hsr;
    }
}
