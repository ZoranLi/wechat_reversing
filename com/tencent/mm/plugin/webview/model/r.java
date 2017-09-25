package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aob;
import com.tencent.mm.protocal.c.aoc;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class r extends k implements j {
    public final b gUA;
    private e gWW;
    public String rWL;

    public r(String str, String str2, int i) {
        a aVar = new a();
        aVar.hsm = new aob();
        aVar.hsn = new aoc();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_authorize";
        aVar.hsl = 1254;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.rWL = str;
        this.gUA = aVar.BE();
        aob com_tencent_mm_protocal_c_aob = (aob) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aob.tTd = str;
        com_tencent_mm_protocal_c_aob.tTg = str2;
        com_tencent_mm_protocal_c_aob.scene = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1254;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
