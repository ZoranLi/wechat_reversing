package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.asa;
import com.tencent.mm.protocal.c.asb;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class o extends k implements j {
    private b gUA = null;
    private e gUD;
    public asa mQg = null;
    public asb mQh = null;

    public o(int i, long j, int i2, long j2, boolean z) {
        a aVar = new a();
        aVar.hsm = new asa();
        aVar.hsn = new asb();
        aVar.hsl = 819;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnsync";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        long currentTimeMillis = System.currentTimeMillis();
        this.mQg = (asa) this.gUA.hsj.hsr;
        this.mQg.tWt = m.xL();
        this.mQg.tvL = i;
        this.mQg.tvM = j;
        this.mQg.tVW = currentTimeMillis;
        this.mQg.tWu = i2;
        this.mQg.tVZ = j2;
        if (z) {
            this.mQg.tWv = 1;
        } else {
            this.mQg.tWv = 0;
        }
        w.i("MicroMsg.NetSceneIPCallSync", "roomId: %d, roomKey: %d, syncKey: %d, callSeq: %d,dataFlag: %d, timestamp: %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(this.mQg.tWv), Long.valueOf(currentTimeMillis)});
    }

    public final int getType() {
        return 819;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneIPCallSync", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mQh = (asb) ((b) pVar).hsk.hsr;
        this.gUD.a(i2, i3, str, this);
    }
}
