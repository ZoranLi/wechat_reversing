package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.awn;
import com.tencent.mm.protocal.c.awo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class t extends k implements j {
    private b gUA = null;
    private e gUD = null;

    public t(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hsm = new awn();
        aVar.hsn = new awo();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/searchbleharddevice";
        aVar.hsl = 1706;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        awn com_tencent_mm_protocal_c_awn = (awn) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_awn.mac = str;
        if (str2 == null) {
            str2 = "";
        }
        com_tencent_mm_protocal_c_awn.userName = str2;
        if (str3 == null) {
            str3 = "";
        }
        com_tencent_mm_protocal_c_awn.category = str3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.exdevice.NetSceneSearchBLEHardDevice", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1706;
    }

    public final awo app() {
        if (this.gUA == null || this.gUA.hsk.hsr == null) {
            return null;
        }
        return (awo) this.gUA.hsk.hsr;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
