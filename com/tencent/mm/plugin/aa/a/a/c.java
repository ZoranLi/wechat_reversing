package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.protocal.c.w;
import com.tencent.mm.protocal.c.x;
import com.tencent.mm.y.a;
import com.tencent.mm.y.b;

public final class c extends a<x> {
    public c(int i, int i2, int i3, String str, int i4, int i5, String str2) {
        b.a aVar = new b.a();
        com.tencent.mm.bd.a wVar = new w();
        wVar.aIo = i;
        wVar.offset = i2;
        wVar.type = i3;
        wVar.tbU = str;
        wVar.tbV = i4;
        wVar.tbW = i5;
        wVar.tbX = str2;
        aVar.hsm = wVar;
        aVar.hsn = new x();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
        aVar.hsl = 1676;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s, bill_id: %s, trans_id: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str, str2});
    }

    public c(int i, int i2, int i3) {
        b.a aVar = new b.a();
        com.tencent.mm.bd.a wVar = new w();
        wVar.aIo = i;
        wVar.offset = i2;
        wVar.type = i3;
        aVar.hsm = wVar;
        aVar.hsn = new x();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaquerylist";
        aVar.hsl = 1676;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CgiAAQueryList", "CgiAAQueryList, limit: %s, offset: %s, type: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
    }
}
