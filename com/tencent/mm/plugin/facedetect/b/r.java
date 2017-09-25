package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.rf;
import com.tencent.mm.protocal.c.rg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class r extends k implements j {
    private b gUA;
    private e gUD;
    public String mFileName = "";

    public r(String str, long j, String str2, String str3, String str4) {
        a aVar = new a();
        aVar.hsm = new rf();
        aVar.hsn = new rg();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/facevideobindbioid";
        aVar.hsl = 1197;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.mFileName = str;
        rf rfVar = (rf) this.gUA.hsj.hsr;
        rfVar.fTO = str2;
        rfVar.twJ = j;
        rfVar.twK = str4;
        rfVar.twO = str3;
    }

    public final int getType() {
        return 1197;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneFaceThirdBindVideo", "hy:  errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
