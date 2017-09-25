package com.tencent.mm.plugin.radar.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    b gUA;
    private e gUD;

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.Radar.NetSceneRadarRelationChain", "netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gUD.a(i2, i3, str, this);
        if (i2 != 0 && i2 == 4) {
        }
    }

    public final int getType() {
        return 602;
    }
}
