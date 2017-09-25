package com.tencent.mm.plugin.location.model.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.qb;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    public final b gUA;
    private e gUD;
    private Runnable hSV;

    public a(String str) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new qb();
        aVar.hsn = new qc();
        aVar.uri = "/cgi-bin/micromsg-bin/exittrackroom";
        aVar.hsl = 491;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((qb) this.gUA.hsj.hsr).tvV = str;
        w.d("MicroMsg.NetSceneExitTrackRoom", "trackRoomId:" + str);
    }

    public final int getType() {
        return 491;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneExitTrackRoom", "onGYNetEnd errType %d errCode%d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
        if (this.hSV != null) {
            this.hSV.run();
        }
    }
}
