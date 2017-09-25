package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class m extends k implements j {
    private e gUD;
    private final p htt = new com.tencent.mm.y.j();

    public final int getType() {
        return 381;
    }

    public final boolean BL() {
        return false;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.htt, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetCert", "dkcert onGYNetEnd [%d,%d]", Integer.valueOf(i2), Integer.valueOf(i3));
        this.gUD.a(i2, i3, str, this);
    }
}
