package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bgm;
import com.tencent.mm.protocal.c.bgn;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class y extends k implements j {
    private String fGl;
    private String fwJ;
    private b gUA;
    private e gUD;
    public String gtR;
    private int ldH = 0;

    public y(String str, String str2, String str3) {
        this.gtR = str3;
        this.fwJ = str;
        this.fGl = str2;
    }

    public final int getType() {
        return 1263;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        a aVar = new a();
        aVar.hsm = new bgm();
        aVar.hsn = new bgn();
        aVar.uri = "/cgi-bin/mmoc-bin/hardware/updatemydeviceattr";
        aVar.hsl = 1263;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bgm com_tencent_mm_protocal_c_bgm = (bgm) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bgm.gtR = this.gtR;
        com_tencent_mm_protocal_c_bgm.ocL = this.fwJ;
        com_tencent_mm_protocal_c_bgm.devicetype = this.fGl;
        com_tencent_mm_protocal_c_bgm.ugE = this.ldH;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }
}
