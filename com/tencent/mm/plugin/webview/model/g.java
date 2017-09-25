package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ui;
import com.tencent.mm.protocal.c.uj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class g extends k implements j {
    private e gUD;
    public final b ldw;

    public g(String str, String str2) {
        a aVar = new a();
        aVar.hsm = new ui();
        aVar.hsn = new uj();
        aVar.uri = "/cgi-bin/mmbiz-bin/getappticket";
        aVar.hsl = 1097;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        ui uiVar = (ui) this.ldw.hsj.hsr;
        uiVar.fTO = str;
        uiVar.signature = str2;
    }

    public final int getType() {
        return 1097;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.ldw, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetAppTicket", "errType = " + i2 + ", errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }
}
