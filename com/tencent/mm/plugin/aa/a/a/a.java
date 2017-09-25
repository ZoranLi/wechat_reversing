package com.tencent.mm.plugin.aa.a.a;

import com.tencent.mm.protocal.c.p;
import com.tencent.mm.protocal.c.q;
import com.tencent.mm.sdk.platformtools.w;

public final class a extends com.tencent.mm.y.a<q> {
    public a(String str, long j, int i, String str2, String str3, String str4) {
        com.tencent.mm.bd.a pVar = new p();
        pVar.tbh = str;
        pVar.tbA = j;
        pVar.scene = i;
        pVar.tbi = str2;
        pVar.tbC = str3;
        pVar.oQK = str4;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = pVar;
        aVar.hsn = new q();
        aVar.hsl = 1344;
        aVar.uri = "/cgi-bin/mmpay-bin/newaapaysucc";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        w.i("MicroMsg.CgiAAPaySucc", "CgiAAPaySucc, bill_no: %s, pay_amount: %s, scene: %s, groupid: %s, out_trade_no: %s, trans_id: %s", new Object[]{pVar.tbh, Long.valueOf(pVar.tbA), Integer.valueOf(pVar.scene), pVar.tbi, pVar.tbC, pVar.oQK});
    }
}
