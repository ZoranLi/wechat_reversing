package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahu;
import com.tencent.mm.protocal.c.ahv;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class y extends k implements j {
    private e gUD;
    private final b hKp;

    public y(String str) {
        a aVar = new a();
        aVar.hsm = new ahu();
        aVar.hsn = new ahv();
        aVar.uri = "/cgi-bin/micromsg-bin/jumpemotiondetail";
        aVar.hsl = 666;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.hKp = aVar.BE();
        ((ahu) this.hKp.hsj.hsr).msN = str;
    }

    public final int getType() {
        return 666;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hKp, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:netId:%s,errType:%s,errCode:%s,errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (i2 == 0 && i3 == 0) {
            w.d("MicroMsg.NetSceneScanEmoji", "[oneliang][NetSceneScanEmoji]:net end ok");
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final ahv Jv() {
        return (ahv) this.hKp.hsk.hsr;
    }
}
