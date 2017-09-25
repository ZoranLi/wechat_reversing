package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.vm;
import com.tencent.mm.protocal.c.vn;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Map;

public final class i extends k implements j {
    public b gUA;
    private e gUD;

    public i(String str, String str2, Map<String, Object> map) {
        a aVar = new a();
        aVar.hsm = new vm();
        aVar.hsn = new vn();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizjsapiredirecturl";
        aVar.hsl = 1393;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        vm vmVar = (vm) this.gUA.hsj.hsr;
        vmVar.tsS = str;
        vmVar.tCP = str2;
        vmVar.tCO = (String) map.get("groupId");
        vmVar.rEK = (String) map.get("timestamp");
        vmVar.knP = (String) map.get("nonceStr");
        vmVar.signature = (String) map.get("signature");
        vmVar.tCQ = map.get("params").toString();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1393;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.NetSceneGetBizJsApiRedirectUrl", "do scene");
        return a(eVar, this.gUA, this);
    }

    public final vn bwf() {
        if (this.gUA == null || this.gUA.hsk.hsr == null) {
            return null;
        }
        return (vn) this.gUA.hsk.hsr;
    }
}
