package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aas;
import com.tencent.mm.protocal.c.aat;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class j extends k implements com.tencent.mm.network.j {
    public final b gUA;
    private e gWW;

    public j(String str, String str2, int i, int i2) {
        w.d("MicroMsg.NetSceneGetReadingModeInfoProxy", "NetSceneSetOAuthScope doScene url[%s], userAgent[%s], width[%d], height[%d]", new Object[]{str, str2, Integer.valueOf(i), Integer.valueOf(i2)});
        a aVar = new a();
        aVar.hsm = new aas();
        aVar.hsn = new aat();
        aVar.uri = "/cgi-bin/micromsg-bin/getreadingmodeinfo";
        aVar.hsl = 673;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aas com_tencent_mm_protocal_c_aas = (aas) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aas.URL = str;
        com_tencent_mm_protocal_c_aas.tGF = str2;
        com_tencent_mm_protocal_c_aas.Width = i;
        com_tencent_mm_protocal_c_aas.Height = i2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i2 + ", errCode = " + i3);
        this.gWW.a(i2, i3, str, this);
        if (i2 != 0 || i3 != 0) {
            w.e("MicroMsg.NetSceneGetReadingModeInfoProxy", "errType = " + i2 + ", errCode = " + i3);
        }
    }

    public final int getType() {
        return 673;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.NetSceneGetReadingModeInfoProxy", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
