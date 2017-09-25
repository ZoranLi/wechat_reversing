package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.protocal.c.wp;
import com.tencent.mm.protocal.c.wq;
import com.tencent.mm.y.a;
import com.tencent.mm.y.b;

public final class c extends a<wq> {
    public c(String str) {
        b.a aVar = new b.a();
        com.tencent.mm.bd.a wpVar = new wp();
        wpVar.ttq = str;
        aVar.hsm = wpVar;
        aVar.hsn = new wq();
        aVar.uri = "/cgi-bin/micromsg-bin/getchatroominfodetail";
        aVar.hsl = 223;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }
}
