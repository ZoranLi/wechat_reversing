package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.protocal.c.vy;
import com.tencent.mm.protocal.c.vz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class y extends k implements j {
    private final b gUA;
    private e gUD;

    public y() {
        a aVar = new a();
        aVar.hsm = new vy();
        aVar.hsn = new vz();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardcount";
        aVar.hsl = 663;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
    }

    public final int getType() {
        return 663;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetCardCount", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            vz vzVar = (vz) this.gUA.hsk.hsr;
            w.i("MicroMsg.NetSceneGetCardCount", "has_card_item:" + vzVar.tCY + " has_share_card:" + vzVar.tCZ);
            if (vzVar.tCY > 0) {
                l.aiI();
                ap.yY();
                if (TextUtils.isEmpty((String) c.vr().get(com.tencent.mm.storage.w.a.uAE, null))) {
                    al.afZ();
                    com.tencent.mm.plugin.card.a.b.kn(1);
                }
            }
            if (vzVar.tCZ > 0) {
                l.aiK();
                ap.yY();
                Long l = (Long) c.vr().get(com.tencent.mm.storage.w.a.uAO, Long.valueOf(0));
                if (l != null && l.longValue() == 0) {
                    al.agh().agr();
                }
            }
        }
        ap.yY();
        c.vr().set(282882, Integer.valueOf((int) (System.currentTimeMillis() / 1000)));
        this.gUD.a(i2, i3, str, this);
    }
}
