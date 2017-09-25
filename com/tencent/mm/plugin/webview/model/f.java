package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.akc;
import com.tencent.mm.protocal.c.akd;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class f extends k implements j {
    String appId;
    final b gUA;
    private e gWW;
    String iDB;

    public f(String str, String str2) {
        this.appId = str;
        this.iDB = str2;
        a aVar = new a();
        aVar.hsm = new akc();
        aVar.hsn = new akd();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_downloadcdninfo";
        aVar.hsl = 1035;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        akc com_tencent_mm_protocal_c_akc = (akc) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_akc.fTO = str;
        com_tencent_mm_protocal_c_akc.tNY = str2;
        w.i("MicroMsg.NetSceneDownloadCdnInfo", "download cdn info, appid : %s, mediaId : %s", new Object[]{str, str2});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneDownloadCdnInfo", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1035;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
