package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.a;
import com.tencent.mm.plugin.webview.ui.tools.jsapi.c.b;
import com.tencent.mm.protocal.c.agt;
import com.tencent.mm.protocal.c.agu;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class m extends k implements j, b {
    public final com.tencent.mm.y.b gUA;
    private e gWW;
    public String mkT;
    public a rWD;
    private final int rWF;

    public m(a aVar, String str, String str2, LinkedList<String> linkedList, String str3, String str4, String str5, String str6, int i, String str7, int i2) {
        w.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "NetSceneJSAPIPreVerify doScene url[%s], appid[%s], [%s], [%s], [%s], [%s]", new Object[]{str, str2, str3, str4, str5, str6});
        this.rWD = aVar;
        this.mkT = str;
        this.rWF = i2;
        com.tencent.mm.y.b.a aVar2 = new com.tencent.mm.y.b.a();
        aVar2.hsm = new agt();
        aVar2.hsn = new agu();
        aVar2.uri = "/cgi-bin/mmbiz-bin/jsapi-preverify";
        aVar2.hsl = 1093;
        aVar2.hso = 0;
        aVar2.hsp = 0;
        this.gUA = aVar2.BE();
        agt com_tencent_mm_protocal_c_agt = (agt) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_agt.url = str;
        com_tencent_mm_protocal_c_agt.fTO = str2;
        com_tencent_mm_protocal_c_agt.tLC = linkedList;
        com_tencent_mm_protocal_c_agt.lUw = str3;
        com_tencent_mm_protocal_c_agt.tLo = str4;
        com_tencent_mm_protocal_c_agt.signature = str5;
        com_tencent_mm_protocal_c_agt.tLp = str6;
        com_tencent_mm_protocal_c_agt.scene = i;
        com_tencent_mm_protocal_c_agt.tLD = str7;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1093;
    }

    public final agu bwj() {
        if (this.gUA == null) {
            return null;
        }
        return (agu) this.gUA.hsk.hsr;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.webview.NetSceneJSAPIPreVerify", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int bwi() {
        return this.rWF;
    }
}
