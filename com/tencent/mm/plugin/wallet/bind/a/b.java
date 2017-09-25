package com.tencent.mm.plugin.wallet.bind.a;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.wallet.a.o;
import com.tencent.mm.plugin.wallet_core.model.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.wallet_core.c.k;
import com.tencent.mm.y.e;

public final class b extends k {
    private com.tencent.mm.y.b gUA;
    private e gUD;
    private String rwo;

    public final void d(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetSceneSetMainBankCard", "errType:" + i + ",errCode:" + i2 + ",errMsg" + str);
        if (i == 0 && i2 == 0) {
            o.bsC();
            o.bsD();
            af.HY(this.rwo);
        }
        this.gUD.a(i, i2, str, this);
    }

    public final int getType() {
        return 621;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
