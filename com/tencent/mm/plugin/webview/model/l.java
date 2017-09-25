package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.c.agl;
import com.tencent.mm.protocal.c.agm;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class l extends k implements j, b {
    private final com.tencent.mm.y.b gUA;
    private e gWW;
    public a rWD;
    public String rWE;
    private final int rWF;
    public String url;

    public l(a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, byte[] bArr, int i, String str8, int i2) {
        w.i("MicroMsg.webview.NetSceneJSAPIAuth", "NetSceneJSAPIAuth doScene appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s], [%s]", new Object[]{str2, str3, str4, str5, str6, str7, Integer.valueOf(i), str8});
        this.rWD = aVar;
        this.rWE = str3;
        this.url = str;
        this.rWF = i2;
        com.tencent.mm.y.b.a aVar2 = new com.tencent.mm.y.b.a();
        aVar2.hsm = new agl();
        aVar2.hsn = new agm();
        aVar2.uri = "/cgi-bin/mmbiz-bin/jsapi-auth";
        aVar2.hsl = 1095;
        aVar2.hso = 0;
        aVar2.hsp = 0;
        this.gUA = aVar2.BE();
        agl com_tencent_mm_protocal_c_agl = (agl) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_agl.url = str;
        com_tencent_mm_protocal_c_agl.msh = str2;
        com_tencent_mm_protocal_c_agl.tLm = str3;
        com_tencent_mm_protocal_c_agl.lUw = str4;
        com_tencent_mm_protocal_c_agl.tLo = str5;
        com_tencent_mm_protocal_c_agl.signature = str6;
        com_tencent_mm_protocal_c_agl.tLp = str7;
        com_tencent_mm_protocal_c_agl.tLq = com.tencent.mm.bd.b.aU(bArr);
        com_tencent_mm_protocal_c_agl.tLr = i;
        com_tencent_mm_protocal_c_agl.scope = str8;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.webview.NetSceneJSAPIAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1095;
    }

    public final agl bwg() {
        if (this.gUA == null) {
            return null;
        }
        return (agl) this.gUA.hsj.hsr;
    }

    public final agm bwh() {
        if (this.gUA == null) {
            return null;
        }
        return (agm) this.gUA.hsk.hsr;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.webview.NetSceneJSAPIAuth", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int bwi() {
        return this.rWF;
    }
}
