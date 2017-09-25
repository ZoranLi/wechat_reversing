package com.tencent.mm.plugin.qqmail.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bei;
import com.tencent.mm.protocal.c.bej;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class n extends k implements j {
    public final boolean fYd;
    private b gUA;
    private e gUD;
    private String oAe = "";

    public n(boolean z, String str) {
        this.fYd = z;
        this.oAe = bg.mz(str);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        a aVar = new a();
        aVar.hsm = new bei();
        aVar.hsn = new bej();
        aVar.uri = "/cgi-bin/micromsg-bin/switchpushmail";
        aVar.hsl = 129;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bei com_tencent_mm_protocal_c_bei = (bei) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bei.tAH = this.fYd ? 1 : 2;
        com_tencent_mm_protocal_c_bei.ufj = this.oAe;
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final boolean BI() {
        return true;
    }

    public final int getType() {
        return 24;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0) {
            bej com_tencent_mm_protocal_c_bej = (bej) this.gUA.hsk.hsr;
            ap.yY();
            c.vr().set(17, Integer.valueOf(com_tencent_mm_protocal_c_bej.tAH));
        }
        this.gUD.a(i2, i3, str, this);
    }
}
