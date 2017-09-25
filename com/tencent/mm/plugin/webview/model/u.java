package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.awj;
import com.tencent.mm.protocal.c.awk;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class u extends k implements j {
    public final b gUA;
    private e gWW;

    public u(int i, String str, String str2, String str3, LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.hsm = new awj();
        aVar.hsn = new awk();
        aVar.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize_confirm ";
        aVar.hsl = 1346;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        awj com_tencent_mm_protocal_c_awj = (awj) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_awj.tTe = i;
        com_tencent_mm_protocal_c_awj.fTO = str;
        com_tencent_mm_protocal_c_awj.tTf = linkedList;
        com_tencent_mm_protocal_c_awj.state = str2;
        com_tencent_mm_protocal_c_awj.tZC = str3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1346;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
