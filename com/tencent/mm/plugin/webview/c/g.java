package com.tencent.mm.plugin.webview.c;

import com.tencent.mm.as.i;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avb;
import com.tencent.mm.protocal.c.avc;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class g extends k implements j {
    private e gUD;
    private b hKp;
    private String rWn;
    private int scene;

    public g(avb com_tencent_mm_protocal_c_avb) {
        a aVar = new a();
        aVar.hsl = 1134;
        aVar.uri = "/cgi-bin/mmsearch-bin/searchreport";
        aVar.hsm = com_tencent_mm_protocal_c_avb;
        aVar.hsn = new avc();
        this.hKp = aVar.BE();
        this.scene = com_tencent_mm_protocal_c_avb.tdM;
        this.rWn = com_tencent_mm_protocal_c_avb.tYG;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.FTS.NetSceneWebSearchReport", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            this.gUD.a(i2, i3, str, this);
            i.gs(6);
            i.a(this.scene, 5, i2, i3, this.rWn);
            return;
        }
        this.gUD.a(i2, i3, str, this);
        i.gs(7);
    }

    public final int getType() {
        return 1134;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.FTS.NetSceneWebSearchReport", "doScene %d", new Object[]{Integer.valueOf(this.scene)});
        i.gs(5);
        i.b(this.scene, 4, this.rWn);
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }
}
