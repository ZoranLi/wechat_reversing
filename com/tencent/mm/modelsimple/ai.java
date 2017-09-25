package com.tencent.mm.modelsimple;

import com.tencent.mm.a.o;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.an;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.biz;
import com.tencent.mm.protocal.c.bja;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class ai extends k implements j {
    public b gUA;
    private e gUD;
    public long hud;

    public ai(String str, String str2, String str3, String str4) {
        this(1, str, str2, str3, str4, false, 0);
    }

    public ai(int i, String str, String str2, String str3, String str4, boolean z, int i2) {
        this(i, str, str2, str3, str4, z, i2, true);
    }

    public ai(int i, String str, String str2, String str3, String str4, boolean z, int i2, boolean z2) {
        this.hud = 0;
        a aVar = new a();
        aVar.hsm = new biz();
        aVar.hsn = new bja();
        aVar.uri = "/cgi-bin/micromsg-bin/newverifypasswd";
        aVar.hsl = 384;
        aVar.hso = an.CTRL_BYTE;
        aVar.hsp = 1000000182;
        this.gUA = aVar.BE();
        biz com_tencent_mm_protocal_c_biz = (biz) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_biz.tce = i;
        com_tencent_mm_protocal_c_biz.uaK = i2;
        com_tencent_mm_protocal_c_biz.uiC = bg.PS(str);
        com_tencent_mm_protocal_c_biz.tjU = bg.PR(str);
        com_tencent_mm_protocal_c_biz.tIn = new avx().OV(str2);
        com_tencent_mm_protocal_c_biz.uiD = new avx().OV(str3);
        com_tencent_mm_protocal_c_biz.tjY = new avx().OV(str4);
        if (i == 5 || i == 2) {
            byte[] b;
            this.hud = new o(m.xK()).longValue();
            if (z) {
                b = h.vG().gXc.b(this.hud, str3);
            } else {
                b = h.vG().gXc.a(this.hud, bg.PS(str), z2);
            }
            com_tencent_mm_protocal_c_biz.tit = new avw().bb(b);
        }
        com_tencent_mm_protocal_c_biz.tjZ = new avw().bb(bg.PT(bg.mz((String) h.vI().vr().get(47, null))));
        String str5 = "MicroMsg.NetSceneVerifyPswd";
        String str6 = "summerauth opCode[%d], hasSecCode[%b], isManualAuth[%b], len:%d, content:[%s]";
        Object[] objArr = new Object[5];
        objArr[0] = Integer.valueOf(com_tencent_mm_protocal_c_biz.tce);
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = Boolean.valueOf(z2);
        objArr[3] = Integer.valueOf(com_tencent_mm_protocal_c_biz.tit == null ? -1 : com_tencent_mm_protocal_c_biz.tit.tZn);
        objArr[4] = com_tencent_mm_protocal_c_biz.tit == null ? "null" : bg.Qj(bg.bl(com_tencent_mm_protocal_c_biz.tit.tZp.sYA));
        w.i(str5, str6, objArr);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 384;
    }

    public final String Fu() {
        try {
            return ((bja) this.gUA.hsk.hsr).tuo;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneVerifyPswd", e, "", new Object[0]);
            return null;
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        biz com_tencent_mm_protocal_c_biz = (biz) this.gUA.hsj.hsr;
        bja com_tencent_mm_protocal_c_bja = (bja) this.gUA.hsk.hsr;
        if (com_tencent_mm_protocal_c_bja.thh != null && com_tencent_mm_protocal_c_bja.thh.tZn > 0) {
            boolean a = h.vG().gXc.a(this.hud, n.a(com_tencent_mm_protocal_c_bja.thh));
            w.i("MicroMsg.NetSceneVerifyPswd", "summerauth parseRet[%b], len[%d]", Boolean.valueOf(a), Integer.valueOf(com_tencent_mm_protocal_c_bja.thh.tZn));
        }
        if (i2 == 0 && i3 == 0) {
            h.vI().vr().set(77830, com_tencent_mm_protocal_c_bja.tuo);
            h.vI().vr().set(32, com_tencent_mm_protocal_c_biz.uiC);
            h.vI().vr().set(33, com_tencent_mm_protocal_c_biz.tjU);
            h.vI().vr().set(46, bg.bo(n.a(com_tencent_mm_protocal_c_bja.thn)));
            String bo = bg.bo(n.a(com_tencent_mm_protocal_c_biz.tjZ));
            h.vI().vr().set(47, bo);
            h.vI().gXW.set(18, bo);
            h.vI().vr().set(-1535680990, com_tencent_mm_protocal_c_bja.thm);
            int i4 = com_tencent_mm_protocal_c_bja.thn == null ? 0 : com_tencent_mm_protocal_c_bja.thn.tZn;
            int length = com_tencent_mm_protocal_c_bja.thm == null ? 0 : com_tencent_mm_protocal_c_bja.thm.length();
            int length2 = com_tencent_mm_protocal_c_bja.tuo == null ? 0 : com_tencent_mm_protocal_c_bja.tuo.length();
            w.i("MicroMsg.NetSceneVerifyPswd", "A2Key.len %d, authKey.len: %d, ticketLen:%d", Integer.valueOf(i4), Integer.valueOf(length), Integer.valueOf(length2));
        } else if (i2 == 4) {
            h.vI().vr().set(32, "");
            h.vI().vr().set(33, "");
        }
        this.gUD.a(i2, i3, str, this);
    }
}
