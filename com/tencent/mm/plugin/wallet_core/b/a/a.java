package com.tencent.mm.plugin.wallet_core.b.a;

import com.tencent.mm.R;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.apn;
import com.tencent.mm.protocal.c.apo;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;

public final class a extends k {
    private b gUA;
    private e gUD;
    public String jumpUrl;
    public int rCo = 0;

    public a() {
        boolean booleanValue;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_apn = new apn();
        ap.yY();
        Object obj = c.vr().get(com.tencent.mm.storage.w.a.uCV, Boolean.valueOf(false));
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        com_tencent_mm_protocal_c_apn.tUv = booleanValue ? 1 : 0;
        aVar.hsm = com_tencent_mm_protocal_c_apn;
        aVar.hsn = new apo();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetjumpurl";
        aVar.hsl = 1564;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final void d(int i, int i2, String str, p pVar) {
        w.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg jump url raw net errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), str});
        apo com_tencent_mm_protocal_c_apo = (apo) ((b) pVar).hsk.hsr;
        if (i == 0 && i2 == 0) {
            w.i("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url. biz_errcode: %d, biz_errmsg: %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_apo.leR), com_tencent_mm_protocal_c_apo.leS});
            str = com_tencent_mm_protocal_c_apo.leS;
            i2 = com_tencent_mm_protocal_c_apo.leR;
            this.jumpUrl = com_tencent_mm_protocal_c_apo.msF;
            this.rCo = com_tencent_mm_protocal_c_apo.tUw;
        } else {
            w.e("MicroMsg.NetSceneIbgPayGetJumpUrl", "hy: get ibg pay jump url failed");
            this.jumpUrl = null;
        }
        if (bg.mA(str)) {
            str = ab.getContext().getString(R.l.ffj);
        }
        this.gUD.a(i, i2, str, this);
    }

    public final int getType() {
        return 1564;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
