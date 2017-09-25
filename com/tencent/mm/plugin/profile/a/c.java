package com.tencent.mm.plugin.profile.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bec;
import com.tencent.mm.protocal.c.bed;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class c extends k implements j {
    public b gUA;
    private e gUD;

    public c(String str, boolean z) {
        a aVar = new a();
        aVar.hsm = new bec();
        aVar.hsn = new bed();
        aVar.uri = "/cgi-bin/mmocbiz-bin/switchbrand";
        this.gUA = aVar.BE();
        bec com_tencent_mm_protocal_c_bec = (bec) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bec.tkL = str;
        com_tencent_mm_protocal_c_bec.uff = z;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.brandservice.NetSceneSwitchBrand", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1394;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.brandservice.NetSceneSwitchBrand", "do scene");
        return a(eVar, this.gUA, this);
    }

    public final bed aTt() {
        if (this.gUA == null || this.gUA.hsk.hsr == null) {
            return null;
        }
        return (bed) this.gUA.hsk.hsr;
    }

    public final bec aTu() {
        if (this.gUA == null || this.gUA.hsj.hsr == null) {
            return null;
        }
        return (bec) this.gUA.hsj.hsr;
    }
}
