package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aot;
import com.tencent.mm.protocal.c.aux;
import com.tencent.mm.protocal.c.auy;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class ah extends k implements j {
    private final b gUA;
    private e gUD;

    public ah(LinkedList<aot> linkedList) {
        a aVar = new a();
        aVar.hsm = new aux();
        aVar.hsn = new auy();
        aVar.uri = "/cgi-bin/micromsg-bin/reportdynamiccardcodeaction";
        aVar.hsl = 1275;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((aux) this.gUA.hsj.hsr).tYx = linkedList;
        if (linkedList != null) {
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                aot com_tencent_mm_protocal_c_aot = (aot) it.next();
                w.d("MicroMsg.NetSceneReportDynamicCardCodeAction", "ReportDynamicCardCodeActionReq operate card_id=%s,code_id=%s,operate_timestamp=%d,operate_type=%d", new Object[]{com_tencent_mm_protocal_c_aot.fVl, com_tencent_mm_protocal_c_aot.kfv, Integer.valueOf(com_tencent_mm_protocal_c_aot.tTQ), Integer.valueOf(com_tencent_mm_protocal_c_aot.tTR)});
            }
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneReportDynamicCardCodeAction", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1275;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
