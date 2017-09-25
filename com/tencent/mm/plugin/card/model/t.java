package com.tencent.mm.plugin.card.model;

import android.text.TextUtils;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.card.b.f;
import com.tencent.mm.plugin.card.b.l;
import com.tencent.mm.protocal.c.bde;
import com.tencent.mm.protocal.c.ew;
import com.tencent.mm.protocal.c.ex;
import com.tencent.mm.protocal.c.jc;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Collection;
import java.util.LinkedList;

public final class t extends k implements j {
    private final b gUA;
    private e gUD;
    public LinkedList<CardInfo> kfN = new LinkedList();

    public t(LinkedList<jc> linkedList, bde com_tencent_mm_protocal_c_bde, int i) {
        a aVar = new a();
        aVar.hsm = new ew();
        aVar.hsn = new ex();
        aVar.uri = "/cgi-bin/micromsg-bin/batchgetcarditembytpinfo";
        aVar.hsl = 699;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ew ewVar = (ew) this.gUA.hsj.hsr;
        ewVar.hkm = linkedList;
        ewVar.tcS = com_tencent_mm_protocal_c_bde;
        ewVar.fVn = i;
    }

    public final int getType() {
        return 699;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            Object obj = ((ex) this.gUA.hsk.hsr).kfG;
            if (TextUtils.isEmpty(obj)) {
                w.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd fail, resp json_ret is null");
                this.gUD.a(4, -1, null, this);
                return;
            }
            Collection sT = f.sT(obj);
            if (sT != null) {
                l.aiI();
                this.kfN.addAll(sT);
            }
            this.gUD.a(0, 0, str, this);
            return;
        }
        w.e("MicroMsg.NetSceneBatchGetCardItem", "onGYNetEnd, batch get fail, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gUD.a(i2, i3, str, this);
    }
}
