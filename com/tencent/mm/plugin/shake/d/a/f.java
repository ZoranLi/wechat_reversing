package com.tencent.mm.plugin.shake.d.a;

import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avp;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.azl;
import com.tencent.mm.protocal.c.azm;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class f extends e {
    private final b gUA;
    private e gUD;

    public f(byte[] bArr, int i, long j, int i2, boolean z, int i3) {
        float f;
        int PY;
        float f2;
        int i4 = 1;
        float f3 = 0.0f;
        super(j);
        a aVar = new a();
        aVar.hsm = new azl();
        aVar.hsn = new azm();
        aVar.uri = "/cgi-bin/micromsg-bin/shakemusic";
        aVar.hsl = 367;
        aVar.hso = 177;
        aVar.hsp = 1000000177;
        this.gUA = aVar.BE();
        azl com_tencent_mm_protocal_c_azl = (azl) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_azl.tsk = new avw().bb(bArr);
        com_tencent_mm_protocal_c_azl.uaL = i2;
        com_tencent_mm_protocal_c_azl.tiL = z ? 1 : 0;
        com_tencent_mm_protocal_c_azl.uaM = (float) i;
        com_tencent_mm_protocal_c_azl.trD = aa.bn(ab.getContext()) ? 1 : 2;
        com_tencent_mm_protocal_c_azl.tfT = i3;
        try {
            ap.yY();
            f = bg.getFloat((String) c.vr().get(w.a.uAx, null), 0.0f);
            try {
                ap.yY();
                f3 = bg.getFloat((String) c.vr().get(w.a.uAy, null), 0.0f);
                ap.yY();
                PY = bg.PY((String) c.vr().get(w.a.uCN, null));
            } catch (Exception e) {
                f2 = f3;
                f3 = f;
                f = f3;
                f3 = f2;
                PY = 0;
                com_tencent_mm_protocal_c_azl.tna = f;
                com_tencent_mm_protocal_c_azl.uaN = f3;
                com_tencent_mm_protocal_c_azl.tGv = com.tencent.mm.am.c.HS() ? 0 : 1;
                if (!com.tencent.mm.am.c.HR()) {
                    i4 = 0;
                }
                com_tencent_mm_protocal_c_azl.tGw = i4;
                n.a(2014, com_tencent_mm_protocal_c_azl.uaN, com_tencent_mm_protocal_c_azl.tna, PY);
            }
        } catch (Exception e2) {
            f2 = 0.0f;
            f = f3;
            f3 = f2;
            PY = 0;
            com_tencent_mm_protocal_c_azl.tna = f;
            com_tencent_mm_protocal_c_azl.uaN = f3;
            if (com.tencent.mm.am.c.HS()) {
            }
            com_tencent_mm_protocal_c_azl.tGv = com.tencent.mm.am.c.HS() ? 0 : 1;
            if (com.tencent.mm.am.c.HR()) {
                i4 = 0;
            }
            com_tencent_mm_protocal_c_azl.tGw = i4;
            n.a(2014, com_tencent_mm_protocal_c_azl.uaN, com_tencent_mm_protocal_c_azl.tna, PY);
        }
        com_tencent_mm_protocal_c_azl.tna = f;
        com_tencent_mm_protocal_c_azl.uaN = f3;
        if (com.tencent.mm.am.c.HS()) {
        }
        com_tencent_mm_protocal_c_azl.tGv = com.tencent.mm.am.c.HS() ? 0 : 1;
        if (com.tencent.mm.am.c.HR()) {
            i4 = 0;
        }
        com_tencent_mm_protocal_c_azl.tGw = i4;
        n.a(2014, com_tencent_mm_protocal_c_azl.uaN, com_tencent_mm_protocal_c_azl.tna, PY);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        azl com_tencent_mm_protocal_c_azl = (azl) this.gUA.hsj.hsr;
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder doscene dataid:%d data:%d endflag:%d voice:%f nettype:%d ver:%d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_azl.uaL), Integer.valueOf(com_tencent_mm_protocal_c_azl.tsk.tZn), Integer.valueOf(com_tencent_mm_protocal_c_azl.tiL), Float.valueOf(com_tencent_mm_protocal_c_azl.uaM), Integer.valueOf(com_tencent_mm_protocal_c_azl.trD), Integer.valueOf(com_tencent_mm_protocal_c_azl.tfT)});
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        azl com_tencent_mm_protocal_c_azl = (azl) this.gUA.hsj.hsr;
        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.NetSceneShakeMusic", "MusicFingerPrintRecorder onGYNetEnd [%d,%d] dataid:%d endflag:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(com_tencent_mm_protocal_c_azl.uaL), Integer.valueOf(((azm) this.gUA.hsk.hsr).tiL)});
        if (i2 == 0 && i3 == 0 && r1.tiL == 1) {
            this.pqi = true;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final avp bbu() {
        return (azm) this.gUA.hsk.hsr;
    }

    public final int getType() {
        return 367;
    }
}
