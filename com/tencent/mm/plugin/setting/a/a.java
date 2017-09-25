package com.tencent.mm.plugin.setting.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bfv;
import com.tencent.mm.protocal.c.bw;
import com.tencent.mm.protocal.c.bx;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public final class a extends k implements j {
    private e gUD;
    private List<String> lqW;

    public a(List<String> list) {
        this.lqW = list;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.hsF = i;
        if (!(i2 == 0 && i3 == 0)) {
            w.e("MicroMsg.NetSceneGetTrustedFriends", "errType:%d, errCode:%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 583;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        com.tencent.mm.bd.a bwVar = new bw();
        Collection arrayList = new ArrayList();
        if (this.lqW != null) {
            for (int i = 0; i < this.lqW.size(); i++) {
                bfv com_tencent_mm_protocal_c_bfv = new bfv();
                com_tencent_mm_protocal_c_bfv.jNj = (String) this.lqW.get(i);
                arrayList.add(com_tencent_mm_protocal_c_bfv);
            }
        }
        bwVar.tfq.addAll(arrayList);
        aVar.hsm = bwVar;
        aVar.hsn = new bx();
        aVar.uri = "/cgi-bin/micromsg-bin/addtrustedfriends";
        aVar.hsl = 583;
        aVar.hso = 0;
        aVar.hso = 0;
        return a(eVar, aVar.BE(), this);
    }
}
