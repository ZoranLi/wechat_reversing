package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.protocal.c.c;
import com.tencent.mm.y.a;
import com.tencent.mm.y.b;

public final class d extends a<c> {
    public d(String str, String str2) {
        b.a aVar = new b.a();
        com.tencent.mm.bd.a bVar = new com.tencent.mm.protocal.c.b();
        bVar.tbh = str;
        bVar.tbi = str2;
        aVar.hsm = bVar;
        aVar.hsn = new c();
        aVar.uri = "/cgi-bin/mmpay-bin/newaaclosenotify";
        aVar.hsl = 1672;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        com.tencent.pb.common.c.d.j("MicroMsg.CgiCloseAAUrgeNotify", "CgiCloseAAUrgeNotify, billNo: %s, chatroom: %s", str, str2);
    }
}
