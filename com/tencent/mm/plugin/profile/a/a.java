package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.protocal.c.adk;
import com.tencent.mm.protocal.c.adl;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    private final b gUA;
    private e gUD;
    public String osr;

    public a(String str, String str2) {
        this.osr = str;
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new adk();
        aVar.hsn = new adl();
        aVar.uri = "/cgi-bin/micromsg-bin/getwburl";
        aVar.hsl = cf.CTRL_INDEX;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        adk com_tencent_mm_protocal_c_adk = (adk) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_adk.jNj = str2;
        ap.yY();
        String mz = bg.mz((String) c.vr().get(46, null));
        com_tencent_mm_protocal_c_adk.thn = new avw().bb(bg.PT(mz));
        ap.yY();
        String mz2 = bg.mz((String) c.vr().get(72, null));
        com_tencent_mm_protocal_c_adk.tBy = new avw().bb(bg.PT(mz2));
        w.d("MicroMsg.NetSceneGetWeiboURL", "dkwt get weibo url with id=" + str + ", a2=" + mz + " , newa2:" + mz2);
    }

    public final int getType() {
        return cf.CTRL_INDEX;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetWeiboURL", "dkwt onGYNetEnd:[%d,%d] get weibo url result:[%s] ", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), getURL()});
        this.gUD.a(i2, i3, str, this);
    }

    public final String getURL() {
        return ((adl) this.gUA.hsk.hsr).URL;
    }
}
