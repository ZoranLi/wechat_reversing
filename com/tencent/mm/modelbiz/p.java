package com.tencent.mm.modelbiz;

import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.ln;
import com.tencent.mm.protocal.c.lo;
import com.tencent.mm.protocal.c.lp;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ba;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class p extends k implements j {
    private b gUA;
    private e gUD;

    public p(String str, int i, String str2, LinkedList<ln> linkedList) {
        a aVar = new a();
        aVar.hsm = new lo();
        aVar.hsn = new lp();
        aVar.uri = "/cgi-bin/micromsg-bin/clickcommand";
        this.gUA = aVar.BE();
        lo loVar = (lo) this.gUA.hsj.hsr;
        loVar.trV = i;
        loVar.trW = str2;
        loVar.tkB = str;
        loVar.tfi = ba.zz();
        if (linkedList != null) {
            loVar.trX = linkedList;
        }
        w.i("MicroMsg.NetSceneBizClickCommand", "click command : %s, type: %s, info: %s, MsgSource : %s, MsgReport size %d", str, Integer.valueOf(i), str2, loVar.tfi, Integer.valueOf(loVar.trX.size()));
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 359;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
