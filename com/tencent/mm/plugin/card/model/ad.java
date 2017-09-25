package com.tencent.mm.plugin.card.model;

import com.tencent.mars.smc.IDKey;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.c.jp;
import com.tencent.mm.protocal.c.wk;
import com.tencent.mm.protocal.c.wl;
import com.tencent.mm.protocal.c.wo;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class ad extends k implements j {
    private final b gUA;
    private e gUD;
    public boolean kfW = false;

    public ad(double d, double d2, int i) {
        a aVar = new a();
        aVar.hsm = new wk();
        aVar.hsn = new wl();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardslayout";
        aVar.hsl = 984;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        wk wkVar = (wk) this.gUA.hsj.hsr;
        wkVar.latitude = d;
        wkVar.longitude = d2;
        wkVar.scene = i;
        ap.yY();
        wkVar.tDe = (String) c.vr().get(w.a.uAE, null);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneGetCardsLayout", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        wl wlVar = (wl) this.gUA.hsk.hsr;
        com.tencent.mm.sdk.platformtools.w.v("MicroMsg.NetSceneGetCardsLayout", "json:" + wlVar.kfG);
        if (i2 == 0 && i3 == 0) {
            boolean z;
            ap.yY();
            c.vr().a(w.a.uAE, wlVar.tDe);
            String str2 = wlVar.kfG;
            long currentTimeMillis = System.currentTimeMillis();
            ap.yY();
            String str3 = (String) c.vr().get(w.a.uAD, null);
            if (!bg.mA(str3)) {
                str2 = str3;
            }
            wo sZ = com.tencent.mm.plugin.card.b.j.sZ(str2);
            al.aga().gUz.eE("UserCardInfo", "update UserCardInfo set stickyIndex=0, stickyEndTime=0 where stickyIndex>0");
            if (sZ == null) {
                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.CardStickyHelper", "[doUpdateStickyInfoLogic] resp null");
                z = false;
            } else {
                int i4;
                if (sZ.tDh != null) {
                    jp jpVar = sZ.tDh;
                    Map hashMap = new HashMap();
                    hashMap.put("expiring_list", Integer.valueOf(2));
                    hashMap.put("member_card_list", Integer.valueOf(2));
                    hashMap.put("nearby_list", Integer.valueOf(3));
                    if (sZ.tDk == 100) {
                        hashMap.put("expiring_list", Integer.valueOf(4));
                    } else if (sZ.tDk == 102) {
                        hashMap.put("member_card_list", Integer.valueOf(4));
                    } else if (sZ.tDk == 101) {
                        hashMap.put("nearby_list", Integer.valueOf(4));
                    }
                    ap.yY();
                    long cs = c.wO().cs(Thread.currentThread().getId());
                    if (sZ.tDh.tpA == null || sZ.tDh.tpA.tpz == null || sZ.tDh.tpA.tpz.size() <= 0) {
                        z = false;
                        i4 = 0;
                    } else {
                        com.tencent.mm.plugin.card.b.j.a(sZ.tDh.tpA.tpz, (((Integer) hashMap.get("expiring_list")).intValue() * 100000) + 3);
                        z = true;
                        i4 = sZ.tDh.tpA.tpz.size() + 0;
                    }
                    if (!(sZ.tDh.tpB == null || sZ.tDh.tpB.tpz == null || sZ.tDh.tpB.tpz.size() <= 0)) {
                        com.tencent.mm.plugin.card.b.j.a(sZ.tDh.tpB.tpz, (((Integer) hashMap.get("member_card_list")).intValue() * 100000) + 2);
                        i4 += sZ.tDh.tpB.tpz.size();
                        z = true;
                    }
                    if (!(sZ.tDh.tpC == null || sZ.tDh.tpC.tpz == null || sZ.tDh.tpC.tpz.size() <= 0)) {
                        com.tencent.mm.plugin.card.b.j.a(sZ.tDh.tpC.tpz, (((Integer) hashMap.get("nearby_list")).intValue() * 100000) + 1);
                        i4 += sZ.tDh.tpC.tpz.size();
                        z = true;
                    }
                    if (!(sZ.tDh.tpD == null || sZ.tDh.tpD.tpz == null || sZ.tDh.tpD.tpz.size() <= 0)) {
                        z = true;
                        i4 += sZ.tDh.tpD.tpz.size();
                        com.tencent.mm.plugin.card.b.j.F(sZ.tDh.tpD.tpz);
                    }
                    ap.yY();
                    c.wO().aD(cs);
                } else {
                    z = false;
                    i4 = 0;
                }
                al.agf().putValue("key_get_card_layout_resp", sZ);
                ap.yY();
                c.vr().a(w.a.uAM, str2);
                if (i4 > 0) {
                    long currentTimeMillis2 = System.currentTimeMillis();
                    ArrayList arrayList = new ArrayList();
                    IDKey iDKey = new IDKey();
                    iDKey.SetID(281);
                    iDKey.SetKey(36);
                    iDKey.SetValue(1);
                    IDKey iDKey2 = new IDKey();
                    iDKey2.SetID(281);
                    iDKey2.SetKey(37);
                    iDKey2.SetValue((int) (currentTimeMillis2 - currentTimeMillis));
                    IDKey iDKey3 = new IDKey();
                    iDKey3.SetID(281);
                    iDKey3.SetKey(38);
                    iDKey3.SetValue(i4);
                    IDKey iDKey4 = new IDKey();
                    iDKey4.SetID(281);
                    iDKey4.SetKey(40);
                    iDKey4.SetValue(((int) (currentTimeMillis2 - currentTimeMillis)) / i4);
                    arrayList.add(iDKey);
                    arrayList.add(iDKey2);
                    arrayList.add(iDKey3);
                    arrayList.add(iDKey4);
                    g.oUh.b(arrayList, true);
                }
            }
            this.kfW = z;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 984;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
