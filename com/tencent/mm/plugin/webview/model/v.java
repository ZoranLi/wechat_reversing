package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bfl;
import com.tencent.mm.protocal.c.bfm;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class v extends k implements j {
    public final b gUA;
    private e gWW;

    public v(String str, String str2) {
        a aVar = new a();
        aVar.hsm = new bfl();
        aVar.hsn = new bfm();
        aVar.uri = "/cgi-bin/mmbiz-bin/transid";
        aVar.hsl = 1142;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bfl com_tencent_mm_protocal_c_bfl = (bfl) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bfl.fTO = str;
        com_tencent_mm_protocal_c_bfl.ufX = str2;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1142;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.NetSceneSendAppMsgToSpecifiedContact", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
