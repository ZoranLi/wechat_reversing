package com.tencent.mm.aq;

import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.bw;
import com.tencent.mm.protocal.c.aaq;
import com.tencent.mm.protocal.c.aar;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    private final b gUA;
    private e gUD;
    public String hOB;
    public String hOC;
    public byte[] hOD;

    public a() {
        this(m.xL(), bg.f((Integer) h.vI().vr().get(66561, null)), 0);
    }

    public a(String str, int i) {
        this(str, i, 0);
    }

    public a(String str, int i, int i2) {
        this.gUD = null;
        this.hOB = null;
        this.hOC = null;
        this.hOD = null;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new aaq();
        aVar.hsn = new aar();
        aVar.uri = "/cgi-bin/micromsg-bin/getqrcode";
        aVar.hsl = bw.CTRL_INDEX;
        aVar.hso = 67;
        aVar.hsp = 1000000067;
        this.gUA = aVar.BE();
        aaq com_tencent_mm_protocal_c_aaq = (aaq) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aaq.ttp = n.mw(str);
        com_tencent_mm_protocal_c_aaq.tGA = i;
        com_tencent_mm_protocal_c_aaq.tce = i2;
        w.i("MicroMsg.NetSceneGetQRCode", "username:%s, style:%d, opcode:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return bw.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetQRCode", "onGYNetEnd errType:" + i2 + " errCode" + i3);
        if (i2 == 0 && i3 == 0) {
            aar com_tencent_mm_protocal_c_aar = (aar) this.gUA.hsk.hsr;
            String a = n.a(((aaq) this.gUA.hsj.hsr).ttp);
            this.hOD = n.a(com_tencent_mm_protocal_c_aar.tGB, new byte[0]);
            this.hOB = com_tencent_mm_protocal_c_aar.tGC;
            w.i("MicroMsg.NetSceneGetQRCode", "expiredWording:%s, revokeId:%s, revokeWording:%s", this.hOB, com_tencent_mm_protocal_c_aar.tGD, com_tencent_mm_protocal_c_aar.tGE);
            if (m.xL().equals(a)) {
                String str2 = com_tencent_mm_protocal_c_aar.tGD;
                a = (String) h.vI().vr().get(66563, (Object) "");
                if (!(str2 == null || a.equals(str2))) {
                    h.vI().vr().set(66563, str2);
                    this.hOC = com_tencent_mm_protocal_c_aar.tGE;
                }
                h.vI().vr().set(66561, Integer.valueOf(com_tencent_mm_protocal_c_aar.tGA));
            }
        }
        this.gUD.a(i2, i3, str, this);
    }
}
