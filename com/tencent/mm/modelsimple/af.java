package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.aze;
import com.tencent.mm.protocal.c.azf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class af extends k implements j {
    public final b gUA;
    private e gUD;

    public af(String str, String str2, avw com_tencent_mm_protocal_c_avw) {
        a aVar = new a();
        aVar.hsm = new aze();
        aVar.hsn = new azf();
        aVar.uri = "/cgi-bin/micromsg-bin/newsetpasswd";
        this.gUA = aVar.BE();
        aze com_tencent_mm_protocal_c_aze = (aze) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aze.leF = bg.PR(str);
        com_tencent_mm_protocal_c_aze.tuo = str2;
        com_tencent_mm_protocal_c_aze.thf = com_tencent_mm_protocal_c_avw;
        w.d("MicroMsg.NetSceneSetPwd", "summersetpwd md5:%s ticket:%s, authkey:%s", str, str2, bg.bl(n.a(com_tencent_mm_protocal_c_avw)));
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 383;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneSetPwd", "onGYNetEnd  errType:" + i2 + " errCode:" + i3);
        this.gUD.a(i2, i3, str, this);
    }
}
