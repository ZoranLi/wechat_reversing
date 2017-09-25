package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.axe;
import com.tencent.mm.protocal.c.axf;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.x.h;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class j extends k implements com.tencent.mm.network.j {
    private int fJA = 0;
    private b gUA;
    private e gUD;
    private String jZo;
    private int jZp;
    private avw jZq = new avw().bb(new byte[0]);
    public LinkedList<axg> jZr;

    public j(String str) {
        this.jZo = str;
        this.jZp = 0;
    }

    public final int getType() {
        return 455;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        a aVar = new a();
        aVar.hsm = new axe();
        aVar.hsn = new axf();
        aVar.uri = "/cgi-bin/micromsg-bin/searchorrecommendbiz";
        aVar.hsl = 455;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        axe com_tencent_mm_protocal_c_axe = (axe) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_axe.tLj = n.mw(this.jZo);
        com_tencent_mm_protocal_c_axe.tce = this.fJA;
        com_tencent_mm_protocal_c_axe.tZS = this.jZp;
        com_tencent_mm_protocal_c_axe.tfG = this.jZq;
        w.d("MicroMsg.BrandService.NetSceneSearchOrRecommendBiz", "doScene:" + this.jZo + "  :" + this.fJA + "  entryFlag:" + this.jZp);
        return a(eVar, this.gUA, this);
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }

    protected final int ub() {
        return 50;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.BrandService.NetSceneSearchOrRecommendBiz", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (i2 == 0 && i3 == 0) {
            axf com_tencent_mm_protocal_c_axf = (axf) this.gUA.hsk.hsr;
            this.jZq = com_tencent_mm_protocal_c_axf.tZG;
            this.jZr = com_tencent_mm_protocal_c_axf.tZU;
            Iterator it = this.jZr.iterator();
            while (it.hasNext()) {
                axg com_tencent_mm_protocal_c_axg = (axg) it.next();
                h hVar = new h();
                hVar.username = n.a(com_tencent_mm_protocal_c_axg.ttp);
                hVar.hrB = com_tencent_mm_protocal_c_axg.tqb;
                hVar.hrA = com_tencent_mm_protocal_c_axg.tqc;
                hVar.fRW = -1;
                hVar.gkq = 3;
                hVar.aV(true);
                com.tencent.mm.x.n.Bm().a(hVar);
            }
        } else {
            this.jZr = null;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
