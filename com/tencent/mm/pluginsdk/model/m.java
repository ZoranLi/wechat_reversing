package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.axq;
import com.tencent.mm.protocal.c.axr;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class m extends k implements j {
    private final b gUA;
    private e gUD;

    public m(String str, String str2) {
        this(str, str2, 0);
    }

    public m(String str, String str2, int i) {
        a aVar = new a();
        aVar.hsm = new axq();
        aVar.hsn = new axr();
        aVar.uri = "/cgi-bin/micromsg-bin/sendfeedback";
        aVar.hsl = 153;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        axq com_tencent_mm_protocal_c_axq = (axq) this.gUA.hsj.hsr;
        if (i != 8) {
            if (bg.mA(str2)) {
                str2 = w.bCL();
            } else {
                str2 = str2 + " " + w.bCL();
            }
        }
        com_tencent_mm_protocal_c_axq.uaj = str;
        com_tencent_mm_protocal_c_axq.opI = str2;
        com_tencent_mm_protocal_c_axq.tMq = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 153;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSendSceneFeedBack", "onGYNetEnd type:" + i2 + " code:" + i3);
        this.gUD.a(i2, i3, str, this);
    }
}
