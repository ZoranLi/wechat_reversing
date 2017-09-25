package com.tencent.mm.plugin.wallet.balance.a.a;

import com.tencent.mm.protocal.c.lr;
import com.tencent.mm.protocal.c.ls;
import com.tencent.mm.y.b;

public final class a extends com.tencent.mm.y.a<ls> {
    public a(String str) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new lr();
        aVar.hsn = new ls();
        aVar.hsl = 1386;
        aVar.uri = "/cgi-bin/mmpay-bin/closefundaccount";
        aVar.hso = 0;
        aVar.hsp = 0;
        b BE = aVar.BE();
        ((lr) BE.hsj.hsr).trZ = str;
        this.gUA = BE;
    }
}
