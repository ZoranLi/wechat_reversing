package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ary;
import com.tencent.mm.protocal.c.arz;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class n extends k implements j {
    private b gUA = null;
    private e gUD = null;
    public ary mQe = null;
    private arz mQf = null;

    public n(int i, long j, long j2, int i2) {
        a aVar = new a();
        aVar.hsm = new ary();
        aVar.hsn = new arz();
        aVar.hsl = 723;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnshutdown";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        long currentTimeMillis = System.currentTimeMillis();
        this.mQe = (ary) this.gUA.hsj.hsr;
        this.mQe.mvV = m.xL();
        this.mQe.tvL = i;
        this.mQe.tvM = j;
        this.mQe.tVZ = j2;
        this.mQe.jNB = i2;
        this.mQe.tVW = currentTimeMillis;
        w.i("MicroMsg.NetSceneIPCallShutDown", "roomId: %d, roomKey: %d, callSeq: %d, status: %d, timestamp: %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Integer.valueOf(i2), Long.valueOf(currentTimeMillis)});
    }

    public final int getType() {
        return 723;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneIPCallShutDown", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mQf = (arz) ((b) pVar).hsk.hsr;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
