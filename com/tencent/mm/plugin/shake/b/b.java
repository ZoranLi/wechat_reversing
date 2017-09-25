package com.tencent.mm.plugin.shake.b;

import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.normsg.a.d;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.azn;
import com.tencent.mm.protocal.c.azo;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    byte[] fYC;
    private final com.tencent.mm.y.b gUA;
    private e gUD;
    int ret;

    public b(float f, float f2, int i, int i2, String str, String str2) {
        a aVar = new a();
        aVar.hsm = new azn();
        aVar.hsn = new azo();
        aVar.uri = "/cgi-bin/micromsg-bin/shakereport";
        aVar.hsl = JsApiOperateBackgroundAudio.CTRL_INDEX;
        aVar.hso = 56;
        aVar.hsp = 1000000056;
        this.gUA = aVar.BE();
        azn com_tencent_mm_protocal_c_azn = (azn) this.gUA.hsj.hsr;
        w.i("MicroMsg.NetSceneShakeReport", "share reprot %f %f", new Object[]{Float.valueOf(f2), Float.valueOf(f)});
        com_tencent_mm_protocal_c_azn.tce = 0;
        com_tencent_mm_protocal_c_azn.tmZ = f;
        com_tencent_mm_protocal_c_azn.tna = f2;
        com_tencent_mm_protocal_c_azn.twQ = i;
        com_tencent_mm_protocal_c_azn.twR = str;
        com_tencent_mm_protocal_c_azn.twS = str2;
        com_tencent_mm_protocal_c_azn.twT = i2;
        ap.yY();
        com_tencent_mm_protocal_c_azn.uaX = bg.a((Integer) c.vr().get(4107, null), 0);
        ap.yY();
        int f3 = bg.f((Integer) c.vr().get(4106, null));
        com_tencent_mm_protocal_c_azn.uaY = f3;
        f3++;
        ap.yY();
        c.vr().set(4106, Integer.valueOf(f3));
        com_tencent_mm_protocal_c_azn.tNc = new avw().bb(d.nZC.aPl());
        n.a(MMBitmapFactory.ERROR_ILLEGAL_NPTC_CHUNK, f, f2, i);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.NetSceneShakeReport", "doScene");
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return JsApiOperateBackgroundAudio.CTRL_INDEX;
    }

    public final int baD() {
        return ((azn) this.gUA.hsj.hsr).twT;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneShakeReport", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        azo com_tencent_mm_protocal_c_azo = (azo) this.gUA.hsk.hsr;
        this.ret = pVar.zg().sZC;
        if (i2 == 0 && i3 == 0) {
            this.fYC = com.tencent.mm.platformtools.n.a(com_tencent_mm_protocal_c_azo.tij);
        }
        this.gUD.a(i2, i3, str, this);
    }
}
