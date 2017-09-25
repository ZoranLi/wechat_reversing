package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.c.agv;
import com.tencent.mm.protocal.c.agw;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class n extends k implements j, b {
    private final com.tencent.mm.y.b gUA;
    private e gWW;
    public a rWD;
    private final int rWF;

    public n(a aVar, String str, String str2, String str3, String str4, String str5, String str6, String str7, byte[] bArr, int i) {
        w.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "NetSceneJSAPIRealtimeVerify doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s]", new Object[]{str, str2, str3, str4, str5, str6, str7});
        this.rWD = aVar;
        this.rWF = i;
        com.tencent.mm.y.b.a aVar2 = new com.tencent.mm.y.b.a();
        aVar2.hsm = new agv();
        aVar2.hsn = new agw();
        aVar2.uri = "/cgi-bin/mmbiz-bin/jsapi-realtimeverify";
        aVar2.hsl = 1094;
        aVar2.hso = 0;
        aVar2.hsp = 0;
        this.gUA = aVar2.BE();
        agv com_tencent_mm_protocal_c_agv = (agv) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_agv.url = str;
        com_tencent_mm_protocal_c_agv.fTO = str2;
        com_tencent_mm_protocal_c_agv.tLm = str3;
        com_tencent_mm_protocal_c_agv.lUw = str4;
        com_tencent_mm_protocal_c_agv.tLo = str5;
        com_tencent_mm_protocal_c_agv.signature = str6;
        com_tencent_mm_protocal_c_agv.tLp = str7;
        com_tencent_mm_protocal_c_agv.tLq = com.tencent.mm.bd.b.aU(bArr);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1094;
    }

    public final agw bwk() {
        if (this.gUA == null) {
            return null;
        }
        return (agw) this.gUA.hsk.hsr;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.webview.NetSceneJSAPIRealtimeVerify", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int bwi() {
        return this.rWF;
    }
}
