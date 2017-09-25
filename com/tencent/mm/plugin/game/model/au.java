package com.tencent.mm.plugin.game.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ael;
import com.tencent.mm.protocal.c.aem;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class au extends k implements j {
    private String appId;
    private e gUD;
    final b ldw;

    public au(String str) {
        a aVar = new a();
        aVar.hsm = new ael();
        aVar.hsn = new aem();
        aVar.uri = "/cgi-bin/mmgame-bin/gethvgamemenu";
        aVar.hsl = 1369;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.appId = str;
        this.ldw = aVar.BE();
        ael com_tencent_mm_protocal_c_ael = (ael) this.ldw.hsj.hsr;
        com_tencent_mm_protocal_c_ael.mtJ = v.bIN();
        com_tencent_mm_protocal_c_ael.hAM = bg.bJW();
        com_tencent_mm_protocal_c_ael.mtb = str;
        w.i("MicroMsg.NetSceneHVGameGetMenu", "lang=%s, country=%s, appid=%s", new Object[]{com_tencent_mm_protocal_c_ael.mtJ, com_tencent_mm_protocal_c_ael.hAM, com_tencent_mm_protocal_c_ael.mtb});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneHVGameGetMenu", "errType = " + i2 + ", errCode = " + i3 + ", errMsg = " + str);
        if (i2 != 0 || i3 != 0) {
            this.gUD.a(i2, i3, str, this);
        } else if (((aem) ((b) pVar).hsk.hsr) == null) {
            this.gUD.a(i2, i3, str, this);
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1369;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.ldw, this);
    }
}
