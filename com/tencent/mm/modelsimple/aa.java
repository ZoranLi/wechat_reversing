package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.awp;
import com.tencent.mm.protocal.c.awq;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.x.h;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;

public final class aa extends k implements j {
    private final b gUA;
    private e gUD;
    public final boolean hSZ;

    public aa(String str) {
        this(str, 0);
    }

    public aa(String str, int i) {
        this(str, i, (byte) 0);
    }

    private aa(String str, int i, byte b) {
        this(str, 1, i, false);
    }

    public aa(String str, int i, int i2, boolean z) {
        this.hSZ = z;
        a aVar = new a();
        aVar.hsm = new awq();
        aVar.hsn = new awr();
        aVar.uri = "/cgi-bin/micromsg-bin/searchcontact";
        aVar.hsl = MMGIFException.D_GIF_ERR_NO_COLOR_MAP;
        aVar.hso = 34;
        aVar.hsp = 1000000034;
        this.gUA = aVar.BE();
        w.d("MicroMsg.NetSceneSearchContact", "search username [%s]", str);
        awq com_tencent_mm_protocal_c_awq = (awq) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_awq.ttp = new avx().OV(str);
        com_tencent_mm_protocal_c_awq.tVA = i;
        com_tencent_mm_protocal_c_awq.tZF = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return MMGIFException.D_GIF_ERR_NO_COLOR_MAP;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        awr com_tencent_mm_protocal_c_awr = (awr) this.gUA.hsk.hsr;
        h hVar;
        if (com_tencent_mm_protocal_c_awr != null && com_tencent_mm_protocal_c_awr.tDR > 0) {
            Iterator it = com_tencent_mm_protocal_c_awr.tDS.iterator();
            while (it.hasNext()) {
                awp com_tencent_mm_protocal_c_awp = (awp) it.next();
                w.d("MicroMsg.NetSceneSearchContact", "search RES username [%s]", com_tencent_mm_protocal_c_awp.ttp);
                hVar = new h();
                hVar.username = n.a(com_tencent_mm_protocal_c_awp.ttp);
                hVar.hrB = com_tencent_mm_protocal_c_awp.tqb;
                hVar.hrA = com_tencent_mm_protocal_c_awp.tqc;
                hVar.fRW = -1;
                w.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", hVar.getUsername(), hVar.Bs(), hVar.Bt());
                hVar.gkq = 3;
                hVar.aV(true);
                com.tencent.mm.x.n.Bm().a(hVar);
            }
        } else if (!(com_tencent_mm_protocal_c_awr == null || bg.mA(n.a(com_tencent_mm_protocal_c_awr.ttp)))) {
            String a = n.a(com_tencent_mm_protocal_c_awr.ttp);
            hVar = new h();
            hVar.username = a;
            hVar.hrB = com_tencent_mm_protocal_c_awr.tqb;
            hVar.hrA = com_tencent_mm_protocal_c_awr.tqc;
            hVar.fRW = -1;
            w.d("MicroMsg.NetSceneSearchContact", "dkhurl search %s b[%s] s[%s]", hVar.getUsername(), hVar.Bs(), hVar.Bt());
            hVar.gkq = 3;
            hVar.aV(true);
            com.tencent.mm.x.n.Bm().a(hVar);
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final awr Jx() {
        awr com_tencent_mm_protocal_c_awr = (awr) this.gUA.hsk.hsr;
        if (com_tencent_mm_protocal_c_awr != null) {
            Iterator it = com_tencent_mm_protocal_c_awr.tDS.iterator();
            while (it.hasNext()) {
                awp com_tencent_mm_protocal_c_awp = (awp) it.next();
                ap.yY();
                c.xB().eI(com_tencent_mm_protocal_c_awp.ttp.tZr, com_tencent_mm_protocal_c_awp.tBM);
            }
        }
        return com_tencent_mm_protocal_c_awr;
    }
}
