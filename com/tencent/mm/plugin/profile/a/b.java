package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ayu;
import com.tencent.mm.protocal.c.ayv;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    public com.tencent.mm.y.b gUA;
    private e gUD;

    public b(String str, int i) {
        a aVar = new a();
        aVar.hsm = new ayu();
        aVar.hsn = new ayv();
        aVar.uri = "/cgi-bin/mmocbiz-bin/setbrandflag";
        aVar.hsl = 1363;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ayu com_tencent_mm_protocal_c_ayu = (ayu) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_ayu.tkL = str;
        com_tencent_mm_protocal_c_ayu.uaB = i;
        com_tencent_mm_protocal_c_ayu.uaC = 4;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.brandservice.NetSceneSetBrandFlag", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1363;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.brandservice.NetSceneSetBrandFlag", "do scene");
        return a(eVar, this.gUA, this);
    }
}
