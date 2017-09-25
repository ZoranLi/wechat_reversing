package com.tencent.mm.plugin.mall.a;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.protocal.c.app;
import com.tencent.mm.protocal.c.apq;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    private com.tencent.mm.y.b gUA;
    private e gUD;

    public b() {
        boolean booleanValue;
        a aVar = new a();
        aVar.hsm = new app();
        aVar.hsn = new apq();
        aVar.uri = "/cgi-bin/mmpay-bin/payibggetoverseawallet";
        aVar.hsl = 1577;
        this.gUA = aVar.BE();
        app com_tencent_mm_protocal_c_app = (app) this.gUA.hsj.hsr;
        ap.yY();
        Object obj = c.vr().get(w.a.uCV, Boolean.valueOf(false));
        if (obj != null) {
            booleanValue = ((Boolean) obj).booleanValue();
        } else {
            booleanValue = false;
        }
        com_tencent_mm_protocal_c_app.tUv = booleanValue ? 1 : 0;
        com_tencent_mm_protocal_c_app.aQd = v.bIN();
        com_tencent_mm_protocal_c_app.tUy = VERSION.RELEASE;
        com_tencent_mm_protocal_c_app.tUx = f.Z(null, d.sYN);
        com_tencent_mm_protocal_c_app.tUz = Build.MANUFACTURER;
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "req IsShowTips %s language %s os_ver %s wxg_ver %s phone_type %s", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_app.tUv), com_tencent_mm_protocal_c_app.aQd, com_tencent_mm_protocal_c_app.tUy, com_tencent_mm_protocal_c_app.tUx, com_tencent_mm_protocal_c_app.tUz});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "errCode " + i3 + ", errMsg " + str);
        if (i2 == 0 && i3 == 0) {
            apq com_tencent_mm_protocal_c_apq = (apq) ((com.tencent.mm.y.b) pVar).hsk.hsr;
            if (com_tencent_mm_protocal_c_apq.tUC == null || com_tencent_mm_protocal_c_apq.tUD == null) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd other is null " + com_tencent_mm_protocal_c_apq.nvk);
            } else {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetScenePayIBGGetOverseaWallet", "onGYNetEnd " + com_tencent_mm_protocal_c_apq.nvk + " wallet_gray_area: " + com_tencent_mm_protocal_c_apq.tUC.tCt.size() + " wallet_threepoint_area: " + com_tencent_mm_protocal_c_apq.tUD.tCt.size());
            }
            ap.yY();
            c.vr().a(w.a.uDY, Integer.valueOf(com_tencent_mm_protocal_c_apq.nvk));
            m.btY().a(com_tencent_mm_protocal_c_apq.nvk, com_tencent_mm_protocal_c_apq);
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1577;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
