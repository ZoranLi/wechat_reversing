package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.azp;
import com.tencent.mm.protocal.c.azq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class g extends e {
    private final b gUA;
    private e gUD;

    public g(byte[] bArr, int i, long j, int i2, boolean z, int i3) {
        float f;
        float f2;
        int i4 = 1;
        int i5 = 0;
        super(j);
        a aVar = new a();
        aVar.hsm = new azp();
        aVar.hsn = new azq();
        aVar.uri = "/cgi-bin/micromsg-bin/shaketv";
        aVar.hsl = 408;
        aVar.hso = i5;
        aVar.hsp = i5;
        this.gUA = aVar.BE();
        azp com_tencent_mm_protocal_c_azp = (azp) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_azp.tsk = new avw().bb(bArr);
        com_tencent_mm_protocal_c_azp.uaL = i2;
        com_tencent_mm_protocal_c_azp.tiL = z ? 1 : i5;
        com_tencent_mm_protocal_c_azp.uaM = (float) i;
        if (!aa.bn(ab.getContext())) {
            i4 = 2;
        }
        com_tencent_mm_protocal_c_azp.trD = i4;
        com_tencent_mm_protocal_c_azp.tfT = i3;
        try {
            ap.yY();
            float f3 = bg.getFloat((String) c.vr().get(w.a.uAx, null), 0.0f);
            try {
                ap.yY();
                f = bg.getFloat((String) c.vr().get(w.a.uAy, null), 0.0f);
                try {
                    ap.yY();
                    i5 = bg.PY((String) c.vr().get(w.a.uCN, null));
                    f2 = f;
                    f = f3;
                } catch (Exception e) {
                    f2 = f;
                    f = f3;
                }
            } catch (Exception e2) {
                f2 = 0.0f;
                f = f3;
            }
        } catch (Exception e3) {
            f2 = 0.0f;
            f = 0.0f;
        }
        com_tencent_mm_protocal_c_azp.tna = f;
        com_tencent_mm_protocal_c_azp.uaN = f2;
        n.a(2009, com_tencent_mm_protocal_c_azp.uaN, com_tencent_mm_protocal_c_azp.tna, i5);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        azp com_tencent_mm_protocal_c_azp = (azp) this.gUA.hsj.hsr;
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_azp.uaL), Integer.valueOf(com_tencent_mm_protocal_c_azp.tsk.tZn), Integer.valueOf(com_tencent_mm_protocal_c_azp.tiL), Float.valueOf(com_tencent_mm_protocal_c_azp.uaM), Integer.valueOf(com_tencent_mm_protocal_c_azp.trD), Integer.valueOf(com_tencent_mm_protocal_c_azp.tfT)});
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        azp com_tencent_mm_protocal_c_azp = (azp) this.gUA.hsj.hsr;
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneShakeTV", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(com_tencent_mm_protocal_c_azp.uaL), Integer.valueOf(((azq) this.gUA.hsk.hsr).tiL)});
        if (i2 == 0 && i3 == 0 && r1.tiL == 1) {
            this.pqi = true;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final avp bbu() {
        return (azq) this.gUA.hsk.hsr;
    }

    public final int getType() {
        return 408;
    }
}
