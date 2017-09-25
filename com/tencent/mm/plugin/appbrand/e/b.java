package com.tencent.mm.plugin.appbrand.e;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahh;
import com.tencent.mm.protocal.c.ahi;
import com.tencent.mm.protocal.c.bqo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    public final com.tencent.mm.y.b gUA;
    private e gWW;
    private a<b> jaO;

    public interface a<T extends k> {
        void b(int i, int i2, String str, T t);
    }

    public b(String str, String str2, String str3, int i, int i2, int i3, a<b> aVar) {
        this(str, str2, str3, i, i2, i3);
        this.jaO = aVar;
    }

    private b(String str, String str2, String str3, int i, int i2, int i3) {
        w.i("MicroMsg.webview.NetSceneJSOperateWxData", "NetSceneJSLogin doScene appId [%s], data [%s], grantScope [%s], versionType [%d], opt [%d], extScene [%d]", new Object[]{str, str2, str3, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new ahh();
        aVar.hsn = new ahi();
        aVar.uri = "/cgi-bin/mmbiz-bin/js-operatewxdata";
        aVar.hsl = 1133;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ahh com_tencent_mm_protocal_c_ahh = (ahh) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ahh.mtb = str;
        com_tencent_mm_protocal_c_ahh.jMQ = new com.tencent.mm.bd.b(str2.getBytes() == null ? new byte[0] : str2.getBytes());
        com_tencent_mm_protocal_c_ahh.tLR = str3;
        com_tencent_mm_protocal_c_ahh.tLJ = i;
        com_tencent_mm_protocal_c_ahh.tLI = i2;
        if (i3 > 0) {
            com_tencent_mm_protocal_c_ahh.tLK = new bqo();
            com_tencent_mm_protocal_c_ahh.tLK.scene = i3;
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.webview.NetSceneJSOperateWxData", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gWW != null) {
            this.gWW.a(i2, i3, str, this);
        }
        if (this.jaO != null) {
            this.jaO.b(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1133;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.i("MicroMsg.webview.NetSceneJSOperateWxData", "doScene");
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
