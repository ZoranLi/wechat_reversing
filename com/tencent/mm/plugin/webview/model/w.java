package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.akb;
import com.tencent.mm.protocal.c.akg;
import com.tencent.mm.protocal.c.akh;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class w extends k implements j {
    String appId;
    String fJz;
    final b gUA;
    private e gWW;

    public w(String str, String str2, akb com_tencent_mm_protocal_c_akb) {
        this.appId = str;
        this.fJz = str2;
        a aVar = new a();
        aVar.hsm = new akg();
        aVar.hsn = new akh();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_uploadcdninfo";
        aVar.hsl = 1034;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        akg com_tencent_mm_protocal_c_akg = (akg) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_akg.fTO = str;
        com_tencent_mm_protocal_c_akg.tNZ = com_tencent_mm_protocal_c_akb;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.NetSceneUploadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1034;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
