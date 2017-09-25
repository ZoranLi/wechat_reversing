package com.tencent.mm.plugin.wallet_core.model;

import com.tencent.mm.e.a.ru;
import com.tencent.mm.plugin.wallet_core.c.d;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import com.tencent.mm.y.n;
import java.util.Date;

public final class s extends c<ru> implements e {
    private ru rHF;
    private String rHG;

    public s() {
        this.rHG = null;
        this.usg = ru.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        long longValue;
        this.rHF = (ru) bVar;
        this.rHG = this.rHF.fYM.fYO;
        ap.yY();
        Object obj = com.tencent.mm.u.c.vr().get(a.uCW, Long.valueOf(0));
        long longValue2 = obj != null ? ((Long) obj).longValue() : 0;
        long time = new Date().getTime();
        ap.yY();
        obj = com.tencent.mm.u.c.vr().get(a.uCX, Long.valueOf(600000));
        if (obj != null) {
            longValue = ((Long) obj).longValue();
            if (longValue <= 0) {
                longValue = 600000;
            }
        } else {
            longValue = 600000;
        }
        if (time - longValue2 > longValue || bg.mA(this.rHG)) {
            w.i("MicroMsg.WalletGetBulletinEventListener", "data is out of date,do NetSceneGetBannerInfo for update");
            k cVar = new com.tencent.mm.plugin.wallet_core.b.c();
            n vd = ap.vd();
            vd.a(385, this);
            vd.a(cVar, 0);
        } else if (bg.mA(this.rHG)) {
            w.e("MicroMsg.WalletGetBulletinEventListener", "mScene is null");
            this.rHF.nFq.run();
            this.rHF = null;
        } else {
            w.i("MicroMsg.WalletGetBulletinEventListener", "get bulletin data from db");
            bub();
        }
        return true;
    }

    private void bub() {
        d btW = m.btW();
        com.tencent.mm.sdk.e.c pVar = new p();
        pVar.field_bulletin_scene = this.rHG;
        if (btW.b(pVar, new String[0])) {
            this.rHF.fYN.fYP = pVar.field_bulletin_scene;
            this.rHF.fYN.content = pVar.field_bulletin_content;
            this.rHF.fYN.url = pVar.field_bulletin_url;
        } else {
            w.i("MicroMsg.WalletGetBulletinEventListener", "not bulletin data ");
        }
        this.rHF.nFq.run();
        this.rHF = null;
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.WalletGetBulletinEventListener", "NetSceneGetBannerInfo resp,errType = " + i + ";errCode=" + i2);
        ap.vd().b(385, this);
        ap.yY();
        com.tencent.mm.u.c.vr().a(a.uCW, Long.valueOf(new Date().getTime()));
        bub();
    }
}
