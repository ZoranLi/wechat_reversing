package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.c.agk;
import com.tencent.mm.protocal.c.agx;
import com.tencent.mm.protocal.c.agy;
import com.tencent.mm.protocal.c.ahl;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class o extends k implements j, b {
    public final com.tencent.mm.y.b gUA;
    private e gWW;
    private final int rWF;
    public agk rWG;

    public o(agk com_tencent_mm_protocal_c_agk, String str, String str2, String str3, String str4, String str5, String str6, String str7, com.tencent.mm.bd.b bVar, int i, LinkedList<ahl> linkedList, int i2) {
        w.i("MicroMsg.webview.NetSceneJSAPISetAuth", "NetSceneJSAPISetAuth doScene url[%s], appid[%s], jsapiName[%s], [%s], [%s], [%s], [%s], [%s]", new Object[]{str, str2, str3, str4, str5, str6, str7, Integer.valueOf(i)});
        this.rWG = com_tencent_mm_protocal_c_agk;
        this.rWF = i2;
        a aVar = new a();
        aVar.hsm = new agx();
        aVar.hsn = new agy();
        aVar.uri = "/cgi-bin/mmbiz-bin/jsapi-setauth";
        aVar.hsl = 1096;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        agx com_tencent_mm_protocal_c_agx = (agx) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_agx.url = str;
        com_tencent_mm_protocal_c_agx.fTO = str2;
        com_tencent_mm_protocal_c_agx.tLm = str3;
        com_tencent_mm_protocal_c_agx.lUw = str4;
        com_tencent_mm_protocal_c_agx.tLo = str5;
        com_tencent_mm_protocal_c_agx.signature = str6;
        com_tencent_mm_protocal_c_agx.tLp = str7;
        com_tencent_mm_protocal_c_agx.tLr = i;
        com_tencent_mm_protocal_c_agx.tLq = bVar;
        com_tencent_mm_protocal_c_agx.tLv = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.webview.NetSceneJSAPISetAuth", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1096;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.webview.NetSceneJSAPISetAuth", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int bwi() {
        return this.rWF;
    }
}
