package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.protocal.c.r;
import com.tencent.mm.protocal.c.s;
import com.tencent.mm.y.a;
import com.tencent.pb.common.c.d;

public final class b extends a<s> {
    public b(String str, String str2, int i) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        com.tencent.mm.bd.a rVar = new r();
        rVar.tbh = str;
        rVar.tbi = str2;
        rVar.scene = i;
        aVar.hsm = rVar;
        aVar.hsn = new s();
        aVar.uri = "/cgi-bin/mmpay-bin/newaapayurge";
        aVar.hsl = 1644;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        d.j("MicroMsg.CgiAAPayUrge", new Object[]{"CgiAAPayUrge, billNo: %s, chatroom: %s, scene: %s", str, str2, Integer.valueOf(i)});
    }
}
