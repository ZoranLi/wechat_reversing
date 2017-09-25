package com.tencent.mm.ag;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.agg;
import com.tencent.mm.protocal.c.agh;
import com.tencent.mm.protocal.c.agi;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.LinkedList;

public final class b extends k implements j {
    private final com.tencent.mm.y.b gUA;
    private e gUD;
    private LinkedList<agg> hEj;
    public String hEk;

    public b(ArrayList<String> arrayList) {
        a aVar = new a();
        aVar.hsm = new agh();
        aVar.hsn = new agi();
        aVar.uri = "/cgi-bin/micromsg-bin/invitegooglecontact";
        this.gUA = aVar.BE();
        this.hEj = new LinkedList();
        if (arrayList.size() > 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                agg com_tencent_mm_protocal_c_agg = new agg();
                com_tencent_mm_protocal_c_agg.tjl = (String) arrayList.get(i);
                this.hEj.add(com_tencent_mm_protocal_c_agg);
            }
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "doScene");
        this.gUD = eVar2;
        agh com_tencent_mm_protocal_c_agh = (agh) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_agh.jNd = this.hEj.size();
        com_tencent_mm_protocal_c_agh.jNe = this.hEj;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.GoogleContact.NetSceneInviteGoogleContact", "NetId:%d, ErrType:%d, ErrCode:%d, errMsg:%s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        if (i2 == 0 && i3 == 0) {
            this.gUD.a(i2, i3, str, this);
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final agi Gu() {
        return (agi) this.gUA.hsk.hsr;
    }

    public final int getType() {
        return 489;
    }
}
