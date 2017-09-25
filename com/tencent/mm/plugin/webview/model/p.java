package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.agb;
import com.tencent.mm.protocal.c.ahs;
import com.tencent.mm.protocal.c.aht;
import com.tencent.mm.protocal.c.aif;
import com.tencent.mm.protocal.c.aig;
import com.tencent.mm.protocal.d;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.List;

public final class p extends k implements j {
    private final b gUA;
    private e gUD;

    public p(List<aig> list) {
        a aVar = new a();
        aVar.hsm = new ahs();
        aVar.hsn = new aht();
        aVar.uri = "/cgi-bin/mmux-bin/jslog";
        aVar.hsl = 1803;
        this.gUA = aVar.BE();
        ahs com_tencent_mm_protocal_c_ahs = (ahs) this.gUA.hsj.hsr;
        aif com_tencent_mm_protocal_c_aif = new aif();
        com_tencent_mm_protocal_c_aif.tlu = d.sYH;
        com_tencent_mm_protocal_c_aif.tlv = d.sYG;
        com_tencent_mm_protocal_c_aif.tlw = d.sYJ;
        com_tencent_mm_protocal_c_aif.tlx = d.sYK;
        com_tencent_mm_protocal_c_aif.tly = v.bIN();
        com_tencent_mm_protocal_c_aif.tMo = (int) (System.currentTimeMillis() / 1000);
        com_tencent_mm_protocal_c_ahs.teG = com_tencent_mm_protocal_c_aif;
        com_tencent_mm_protocal_c_ahs.teH.addAll(list);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneJsLog", "onGYNetEnd, netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (i2 == 0 && i3 == 0) {
            aht com_tencent_mm_protocal_c_aht = (aht) ((b) pVar).hsk.hsr;
            w.i("MicroMsg.NetSceneJsLog", "received InvalidLogList: ");
            StringBuilder stringBuilder = new StringBuilder("{ ");
            if (bg.bV(com_tencent_mm_protocal_c_aht.tMa)) {
                stringBuilder.append("{  }");
            } else {
                Iterator it = com_tencent_mm_protocal_c_aht.tMa.iterator();
                while (it.hasNext()) {
                    agb com_tencent_mm_protocal_c_agb = (agb) it.next();
                    stringBuilder.append(String.format(" { logId(%d), interval(%d) },", new Object[]{Integer.valueOf(com_tencent_mm_protocal_c_agb.tLf), Integer.valueOf(com_tencent_mm_protocal_c_agb.tLg)}));
                }
            }
            stringBuilder.append(" }");
            w.i("MicroMsg.NetSceneJsLog", stringBuilder.toString());
            e eVar = a.rWC;
            e.bL(com_tencent_mm_protocal_c_aht.tMa);
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1803;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.d("MicroMsg.NetSceneJsLog", "doScene");
        return a(eVar, this.gUA, this);
    }
}
