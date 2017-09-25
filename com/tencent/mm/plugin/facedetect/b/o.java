package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.network.e;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.facedetect.b.j.a;
import com.tencent.mm.protocal.c.anj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;

public final class o extends p implements j, e {
    private final p htt = new f();
    private boolean lva = false;
    private String lvf = "";

    public final boolean arm() {
        return true;
    }

    public final String arn() {
        return this.lvf;
    }

    public o(long j, String str, String str2) {
        a aVar = (a) this.htt.BG();
        aVar.luT.tCE = p.lvg;
        aVar.luT.tCF = j;
        aVar.luT.tYe = str;
        aVar.luT.tYf = str2;
    }

    final int g(e eVar) {
        this.htt.BG();
        return a(eVar, this.htt, this);
    }

    protected final int ub() {
        return 3;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final void a(k.a aVar) {
    }

    public final int getType() {
        return 930;
    }

    public final void b(int i, int i2, String str, p pVar) {
        boolean z = true;
        w.d("MicroMsg.NetSceneFaceRegFaceRsa", "hy: onGYNetEnd  errType:" + i + " errCode:" + i2);
        j.b bVar = (j.b) pVar.zg();
        if (i == 0 && i2 == 0) {
            this.lva = bVar.luU.tYh == 0;
            this.lvf = bVar.luU.tYg;
            i2 = bVar.luU.tYh;
            String str2 = "MicroMsg.NetSceneFaceRegFaceRsa";
            String str3 = "hy: is verify ok: %b, youtuRet; %d, has random pwd: %b";
            Object[] objArr = new Object[3];
            objArr[0] = Boolean.valueOf(this.lva);
            objArr[1] = Integer.valueOf(bVar.luU.tYh);
            if (bg.mA(this.lvf)) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            w.i(str2, str3, objArr);
        } else if (!(bVar == null || bVar.luU == null || bVar.luU.tYh == 0)) {
            w.i("MicroMsg.NetSceneFaceRegFaceRsa", "hy: has detail ret. use");
            i2 = bVar.luU.tYh;
        }
        this.gUD.a(i, i2, str, this);
    }

    final void vE(String str) {
        ((a) this.htt.BG()).luT.tCE = str;
    }

    protected final anj f(p pVar) {
        return ((j.b) pVar.zg()).luU.tCH;
    }
}
