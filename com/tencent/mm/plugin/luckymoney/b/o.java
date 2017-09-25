package com.tencent.mm.plugin.luckymoney.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class o extends k implements j {
    private b gUA;
    private e gUD;

    public final int getType() {
        return 980;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneAsyncBizSubscribe", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
