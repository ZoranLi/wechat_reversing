package com.tencent.mm.modelbiz;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ahz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class t extends k implements j {
    public b gUA;
    private e gUD;
    public String hwg;

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneKFGetDefaultList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 672;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.NetSceneKFGetDefaultList", "do scene");
        return a(eVar, this.gUA, this);
    }

    public final ahz DD() {
        if (this.gUA == null || this.gUA.hsk.hsr == null) {
            return null;
        }
        return (ahz) this.gUA.hsk.hsr;
    }
}
