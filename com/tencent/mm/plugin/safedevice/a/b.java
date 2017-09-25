package com.tencent.mm.plugin.safedevice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bgs;
import com.tencent.mm.protocal.c.bgt;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    public String deviceName;
    public String fGl;
    public String fwJ;
    private com.tencent.mm.y.b gUA;
    private e gUD;

    public b(String str, String str2, String str3) {
        a aVar = new a();
        aVar.hsm = new bgs();
        aVar.hsn = new bgt();
        aVar.uri = "/cgi-bin/micromsg-bin/updatesafedevice";
        aVar.hsl = 361;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.fwJ = str;
        this.deviceName = str2;
        this.fGl = str3;
        bgs com_tencent_mm_protocal_c_bgs = (bgs) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bgs.ttx = str;
        com_tencent_mm_protocal_c_bgs.msj = str2;
        com_tencent_mm_protocal_c_bgs.thD = str3;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetscenUpdateSafeDevice", "errType = " + i2 + ", errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 361;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        if (bg.mA(this.fwJ) || bg.mA(this.deviceName) || bg.mA(this.fGl)) {
            w.e("MicroMsg.NetscenUpdateSafeDevice", "null device is or device name or device type");
            return -1;
        }
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
