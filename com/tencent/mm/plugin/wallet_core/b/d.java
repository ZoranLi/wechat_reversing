package com.tencent.mm.plugin.wallet_core.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.us;
import com.tencent.mm.protocal.c.ut;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class d extends k implements j {
    private b gUA;
    private e gUD;
    public ut rBM;

    public d(String str) {
        a aVar = new a();
        aVar.hsm = new us();
        aVar.hsn = new ut();
        aVar.uri = "/cgi-bin/mmpay-bin/tenpay/getbanpaymobileinfo";
        aVar.hsl = 1667;
        this.gUA = aVar.BE();
        us usVar = (us) this.gUA.hsj.hsr;
        w.d("MicroMsg.NetSceneGetBanpayMobileInfo", "req_key: %s", new Object[]{str});
        usVar.fLT = str;
    }

    public final int getType() {
        return 1667;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetBanpayMobileInfo", "NetSceneGetBanpayMobileInfo, netId: %s, errType: %s, errCode: %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)});
        this.rBM = (ut) this.gUA.hsk.hsr;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
