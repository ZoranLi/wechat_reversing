package com.tencent.mm.aw.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOpenWeRunSetting;
import com.tencent.mm.protocal.c.avd;
import com.tencent.mm.protocal.c.ave;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class a extends k implements j {
    private b gUA;
    private e gUD;

    public a(int i, LinkedList<avx> linkedList, avx com_tencent_mm_protocal_c_avx, avx com_tencent_mm_protocal_c_avx2) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new avd();
        aVar.hsn = new ave();
        aVar.uri = "/cgi-bin/micromsg-bin/reportvoiceresult";
        aVar.hsl = JsApiOpenWeRunSetting.CTRL_INDEX;
        this.gUA = aVar.BE();
        avd com_tencent_mm_protocal_c_avd = (avd) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_avd.tYH = i;
        com_tencent_mm_protocal_c_avd.tYI = linkedList;
        com_tencent_mm_protocal_c_avd.tYJ = com_tencent_mm_protocal_c_avx;
        com_tencent_mm_protocal_c_avd.tYK = com_tencent_mm_protocal_c_avx2;
    }

    public final int getType() {
        return JsApiOpenWeRunSetting.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneNewVoiceInputReport", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gUD.a(i2, i3, str, this);
    }
}
