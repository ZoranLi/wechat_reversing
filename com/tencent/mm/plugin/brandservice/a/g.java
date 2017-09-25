package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.aej;
import com.tencent.mm.protocal.c.aek;
import com.tencent.mm.protocal.c.auf;
import com.tencent.mm.protocal.c.aug;
import com.tencent.mm.protocal.c.axg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.x.h;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class g extends k implements j {
    private static long jZj = 0;
    private b gUA;
    private e gUD;

    public static boolean aea() {
        return System.currentTimeMillis() - jZj > 3600000;
    }

    public final int getType() {
        return 456;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        jZj = System.currentTimeMillis();
        this.gUD = eVar2;
        a aVar = new a();
        aVar.hsm = new aej();
        aVar.hsn = new aek();
        aVar.uri = "/cgi-bin/micromsg-bin/grouprecommendbiz";
        aVar.hsl = 456;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        if (i2 == 0 && i3 == 0) {
            aek com_tencent_mm_protocal_c_aek = (aek) this.gUA.hsk.hsr;
            if (com_tencent_mm_protocal_c_aek.tJC.tSp > 0) {
                w.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount, %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aek.tJC.tSp)});
                try {
                    byte[] toByteArray = com_tencent_mm_protocal_c_aek.tJC.toByteArray();
                    StringBuilder stringBuilder = new StringBuilder();
                    ap.yY();
                    com.tencent.mm.a.e.b(stringBuilder.append(c.xv()).append("search_biz_recommend").toString(), toByteArray, toByteArray.length);
                    Iterator it = com_tencent_mm_protocal_c_aek.tJC.tXZ.iterator();
                    while (it.hasNext()) {
                        Iterator it2 = ((auf) it.next()).tXY.iterator();
                        while (it2.hasNext()) {
                            axg com_tencent_mm_protocal_c_axg = (axg) it2.next();
                            h hVar = new h();
                            hVar.username = n.a(com_tencent_mm_protocal_c_axg.ttp);
                            hVar.hrB = com_tencent_mm_protocal_c_axg.tqb;
                            hVar.hrA = com_tencent_mm_protocal_c_axg.tqc;
                            hVar.fRW = -1;
                            hVar.gkq = 3;
                            hVar.aV(true);
                            com.tencent.mm.x.n.Bm().a(hVar);
                        }
                    }
                } catch (Throwable e) {
                    w.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e.getMessage());
                    w.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e, "", new Object[0]);
                }
            } else {
                StringBuilder stringBuilder2 = new StringBuilder();
                ap.yY();
                com.tencent.mm.loader.stub.b.deleteFile(stringBuilder2.append(c.xv()).append("search_biz_recommend").toString());
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public static LinkedList<auf> aeb() {
        try {
            StringBuilder stringBuilder = new StringBuilder();
            ap.yY();
            byte[] d = com.tencent.mm.a.e.d(stringBuilder.append(c.xv()).append("search_biz_recommend").toString(), 0, Integer.MAX_VALUE);
            if (d != null) {
                aug com_tencent_mm_protocal_c_aug = new aug();
                com_tencent_mm_protocal_c_aug.aD(d);
                w.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", "GroupCount2: %d", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_aug.tSp)});
                return com_tencent_mm_protocal_c_aug.tXZ;
            }
        } catch (Throwable e) {
            w.d("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e.getMessage());
            w.printErrStackTrace("MicroMsg.BrandService.NetSceneGroupRecommendBiz", e, "", new Object[0]);
        }
        return new LinkedList();
    }
}
