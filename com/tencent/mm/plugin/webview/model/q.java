package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ake;
import com.tencent.mm.protocal.c.akf;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class q extends k implements j {
    private final b gUA;
    private e gWW;
    public String rWH;
    public String rWI;
    public String rWJ;
    public int rWK;
    public String sign;

    public q(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hsm = new ake();
        aVar.hsn = new akf();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/mmbizjsapi_getuseropenid";
        aVar.hsl = 1177;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ake com_tencent_mm_protocal_c_ake = (ake) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ake.kdK = str;
        com_tencent_mm_protocal_c_ake.tOa = str2;
        com_tencent_mm_protocal_c_ake.khr = str3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneMMBizGetUserOpenId", "errType = %d, errCode = %d, errMsg = %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            akf com_tencent_mm_protocal_c_akf = (akf) this.gUA.hsk.hsr;
            this.rWH = com_tencent_mm_protocal_c_akf.rWH;
            this.sign = com_tencent_mm_protocal_c_akf.sign;
            this.rWI = com_tencent_mm_protocal_c_akf.rWI;
            this.rWJ = com_tencent_mm_protocal_c_akf.rWJ;
            this.rWK = com_tencent_mm_protocal_c_akf.rWK;
            w.d("MicroMsg.NetSceneMMBizGetUserOpenId", "openid:%s, sign:%s, head_img_url:%s, nick_name:%s, friend_relation:%d", new Object[]{this.rWH, this.sign, this.rWI, this.rWJ, Integer.valueOf(this.rWK)});
        }
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1177;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
