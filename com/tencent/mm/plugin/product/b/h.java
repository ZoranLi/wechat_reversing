package com.tencent.mm.plugin.product.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aag;
import com.tencent.mm.protocal.c.aah;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.List;

public final class h extends k implements j {
    private b gUA;
    private e gUD;
    public String opq;
    public m opr;
    public List<n> ops;

    public h(m mVar, String str) {
        a aVar = new a();
        aVar.hsm = new aag();
        aVar.hsn = new aah();
        aVar.uri = "/cgi-bin/micromsg-bin/getproductdetail";
        aVar.hsl = 553;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aag com_tencent_mm_protocal_c_aag = (aag) this.gUA.hsj.hsr;
        this.opq = str;
        com_tencent_mm_protocal_c_aag.tGj = str;
        w.d("MicroMsg.NetSceneMallGetProductDetail", "pid " + str);
        com_tencent_mm_protocal_c_aag.jOb = 0;
        this.opr = mVar;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        aah com_tencent_mm_protocal_c_aah = (aah) ((b) pVar).hsk.hsr;
        if (!bg.mA(com_tencent_mm_protocal_c_aah.tGl)) {
            w.d("MicroMsg.NetSceneMallGetProductDetail", "resp.ProductInfo " + com_tencent_mm_protocal_c_aah.tGl);
            this.opr = m.a(this.opr, com_tencent_mm_protocal_c_aah.tGl);
        }
        if (i3 == 0 && com_tencent_mm_protocal_c_aah.tnr != 0) {
            i3 = com_tencent_mm_protocal_c_aah.tnr;
            str = com_tencent_mm_protocal_c_aah.tns;
        }
        if (!bg.mA(com_tencent_mm_protocal_c_aah.tGm)) {
            w.d("MicroMsg.NetSceneMallGetProductDetail", "resp.RecommendInfo " + com_tencent_mm_protocal_c_aah.tGm);
            this.ops = n.parse(com_tencent_mm_protocal_c_aah.tGm);
        }
        w.d("MicroMsg.NetSceneMallGetProductDetail", "errCode " + i3 + ", errMsg " + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 553;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
