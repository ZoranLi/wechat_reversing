package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.anz;
import com.tencent.mm.protocal.c.aoa;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class s extends k implements j {
    public final b gUA;
    private e gWW;

    public s(String str, int i, LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.hsm = new anz();
        aVar.hsn = new aoa();
        aVar.uri = "/cgi-bin/mmbiz-bin/oauth_authorize_confirm";
        aVar.hsl = 1373;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        anz com_tencent_mm_protocal_c_anz = (anz) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_anz.tTd = str;
        com_tencent_mm_protocal_c_anz.tTe = i;
        com_tencent_mm_protocal_c_anz.tTf = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1373;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
