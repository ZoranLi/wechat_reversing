package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.mm.R;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.Orders;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.protocal.c.apr;
import com.tencent.mm.protocal.c.aps;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import java.util.ArrayList;

public final class b extends k {
    private com.tencent.mm.y.b gUA;
    private e gUD;
    public Orders rCc;

    public b(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        a aVar = new a();
        aVar.hsm = new apr();
        aVar.hsn = new aps();
        aVar.uri = "/cgi-bin/mmpay-bin/payibgjsgettransaction";
        aVar.hsl = 1565;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        apr com_tencent_mm_protocal_c_apr = (apr) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_apr.mtb = str;
        com_tencent_mm_protocal_c_apr.trg = str4;
        com_tencent_mm_protocal_c_apr.trf = str2;
        com_tencent_mm_protocal_c_apr.trh = str5;
        com_tencent_mm_protocal_c_apr.tri = str6;
        com_tencent_mm_protocal_c_apr.tju = str3;
        com_tencent_mm_protocal_c_apr.tqx = str7;
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.i("MicroMsg.NetSceneIbgGetTransaction", "hy: get h5 transaction: errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        aps com_tencent_mm_protocal_c_aps = (aps) ((com.tencent.mm.y.b) pVar).hsk.hsr;
        if (i2 == 0 && i == 0) {
            i2 = com_tencent_mm_protocal_c_aps.leR;
            str = com_tencent_mm_protocal_c_aps.leS;
        }
        this.rCc = new Orders();
        this.rCc.rBY = 1;
        if (com_tencent_mm_protocal_c_aps == null || com_tencent_mm_protocal_c_aps.tUG == null) {
            w.e("MicroMsg.NetSceneIbgGetTransaction", "hy: info not valid");
        } else {
            this.rCc.rFM = (double) com_tencent_mm_protocal_c_aps.tUG.tUL;
            Commodity commodity = new Commodity();
            commodity.fTA = com_tencent_mm_protocal_c_aps.tUG.oQK;
            commodity.desc = com_tencent_mm_protocal_c_aps.tUG.hHt;
            commodity.kBc = ((double) com_tencent_mm_protocal_c_aps.tUG.tUL) / 100.0d;
            commodity.ofT = String.valueOf(com_tencent_mm_protocal_c_aps.tUG.tUN);
            commodity.ofU = com_tencent_mm_protocal_c_aps.tUG.tUO;
            commodity.ofY = com_tencent_mm_protocal_c_aps.tUG.tUJ;
            commodity.ofW = com_tencent_mm_protocal_c_aps.tUG.tUI;
            commodity.oga = com_tencent_mm_protocal_c_aps.tUG.oga;
            commodity.ofP = com_tencent_mm_protocal_c_aps.tUG.tUM;
            if (com_tencent_mm_protocal_c_aps.tUH != null) {
                commodity.ogb = com_tencent_mm_protocal_c_aps.tUH.tog;
                com.tencent.mm.plugin.wallet_core.model.Orders.b bVar = new com.tencent.mm.plugin.wallet_core.model.Orders.b();
                bVar.name = com_tencent_mm_protocal_c_aps.tUH.tUt;
                bVar.ogb = com_tencent_mm_protocal_c_aps.tUH.tog;
                commodity.rGt = com_tencent_mm_protocal_c_aps.tUH.tog;
                bVar.oqk = com_tencent_mm_protocal_c_aps.tUH.kdG;
                commodity.rFV = com_tencent_mm_protocal_c_aps.tUH.tUr;
                if (!bg.mA(bVar.name)) {
                    commodity.rGz.add(bVar);
                }
                this.rCc.rFV = com_tencent_mm_protocal_c_aps.tUH.tUr;
            } else {
                w.i("MicroMsg.NetSceneIbgGetTransaction", "hy: no biz info");
                this.rCc.rFV = 0;
            }
            this.rCc.rGe = new ArrayList();
            this.rCc.rGe.add(commodity);
            this.rCc.rFX = com_tencent_mm_protocal_c_aps.tUG.tUO;
        }
        if (bg.mA(str)) {
            str = ab.getContext().getString(R.l.ffj);
        }
        this.gUD.a(i, i2, str, this);
    }

    public final int getType() {
        return 1565;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
