package com.tencent.mm.z;

import com.tencent.mm.a.o;
import com.tencent.mm.e.a.rb;
import com.tencent.mm.e.a.rc;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.appbrand.jsapi.map.f;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.protocal.c.gf;
import com.tencent.mm.protocal.c.gg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    private String fMK;
    private String fMM;
    public final b gUA;
    private e gUD;
    public long hud;

    public a(long j, String str, String str2, String str3, String str4, int i, boolean z) {
        byte[] b;
        this.hud = 0;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new gf();
        aVar.hsn = new gg();
        aVar.uri = "/cgi-bin/micromsg-bin/bindqq";
        aVar.hsl = f.CTRL_INDEX;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.hud = j;
        gf gfVar = (gf) this.gUA.hsj.hsr;
        gfVar.tjT = new o(j).intValue();
        gfVar.tjK = "";
        gfVar.tjU = "";
        gfVar.tjV = "";
        gfVar.tjW = "";
        gfVar.tjY = new avx().OV("");
        gfVar.tjX = 1;
        if (z) {
            b = ap.yV().b(j, str3);
        } else {
            b = ap.yV().a(j, bg.PS(str), true);
        }
        gfVar.tit = new avw().bb(b);
        ap.yY();
        gfVar.tjZ = new avw().bb(bg.PT(bg.mz((String) c.vr().get(47, null))));
        w.i("MicroMsg.NetSceneBindQQ", "init opcode:%d qq:%d  wtbuf:%d img[%s,%s,%s] ksid:%s", Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(bg.bn(b)), str3, str2, str4, r1);
    }

    public a(long j, String str, String str2, String str3, String str4, String str5, String str6, boolean z) {
        this(j, str, str2, str3, str4, 1, z);
        this.fMK = str5;
        this.fMM = str6;
        gf gfVar = (gf) this.gUA.hsj.hsr;
        gfVar.tjD = str5;
        gfVar.tjE = str6;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return f.CTRL_INDEX;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        gf gfVar = (gf) this.gUA.hsj.hsr;
        gg ggVar = (gg) this.gUA.hsk.hsr;
        byte[] a = n.a(ggVar.thh);
        boolean z = false;
        if (!bg.bm(a)) {
            z = ap.yV().a(new o(gfVar.tjT).longValue(), a);
        }
        w.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd[%d,%d] wtret:%b wtRespBuf:%d imgsid:%s", Integer.valueOf(i2), Integer.valueOf(i3), Boolean.valueOf(z), Integer.valueOf(bg.bn(a)), ggVar.tjV);
        if (i2 == 0 && i3 == 0) {
            ap.yY();
            c.vr().set(9, Integer.valueOf(gfVar.tjT));
            if (gfVar.tjX == 1) {
                ap.yY();
                c.vr().set(17, Integer.valueOf(ggVar.tdH));
            }
            ap.yY();
            c.wZ().ab(ggVar.tkc, ggVar.tkb == 1);
            int i4 = gfVar.tjT;
            if (i4 != 0) {
                ap.yY();
                c.wZ().bo(new o(i4) + "@qqim", 3);
            }
            com.tencent.mm.x.b.d((long) i4, 3);
            ap.yY();
            c.vr().set(32, gfVar.tjK);
            ap.yY();
            c.vr().set(33, gfVar.tjU);
            w.i("MicroMsg.NetSceneBindQQ", "onGYNetEnd wtret:%b newa2key:%s ", Boolean.valueOf(z), bg.Qj(bg.bo(ap.yV().S(new o(gfVar.tjT).longValue()))));
            ap.yY();
            c.vr().set(72, r3);
            ap.yY();
            c.vr().set(46, bg.bo(n.a(ggVar.thn)));
            String bo = bg.bo(n.a(gfVar.tjZ));
            ap.yY();
            c.vr().set(47, bo);
            ap.yW().set(18, bo);
            ap.yY();
            c.vr().set(-1535680990, ggVar.tkd);
            if (!(bg.mA(this.fMK) || bg.mA(this.fMM))) {
                ap.yY();
                c.vr().set(64, Integer.valueOf(ggVar.tdE));
                com.tencent.mm.sdk.b.b rbVar = new rb();
                rbVar.fYa.fYb = ggVar;
                com.tencent.mm.sdk.b.a.urY.m(rbVar);
                com.tencent.mm.sdk.b.b rcVar = new rc();
                rcVar.fYc.fYd = true;
                rcVar.fYc.fYe = true;
                com.tencent.mm.sdk.b.a.urY.m(rcVar);
            }
        } else if (i2 == 4) {
            ap.yY();
            c.vr().set(32, "");
            ap.yY();
            c.vr().set(33, "");
        }
        if (gfVar.tjX == 3 && i3 == -3) {
            i3 = 10000;
            w.d("MicroMsg.NetSceneBindQQ", new StringBuilder("onGYNetEnd : retCode = 10000").toString());
        }
        this.gUD.a(i2, i3, str, this);
    }
}
