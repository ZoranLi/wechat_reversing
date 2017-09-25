package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.awl;
import com.tencent.mm.protocal.c.awm;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class t extends k implements j {
    public final b gUA;
    private e gWW;

    public t(String str, String str2, String str3, String str4, String str5) {
        a aVar = new a();
        aVar.hsm = new awl();
        aVar.hsn = new awm();
        aVar.uri = "/cgi-bin/mmbiz-bin/sdk_oauth_authorize";
        aVar.hsl = 1388;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        awl com_tencent_mm_protocal_c_awl = (awl) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_awl.fTO = str;
        com_tencent_mm_protocal_c_awl.scope = str2;
        com_tencent_mm_protocal_c_awl.state = str3;
        com_tencent_mm_protocal_c_awl.tZD = str4;
        com_tencent_mm_protocal_c_awl.tZE = str5;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1388;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
