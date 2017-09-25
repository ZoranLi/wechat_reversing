package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.arp;
import com.tencent.mm.protocal.c.arq;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class h extends k implements j {
    private b gUA = null;
    private e gUD = null;
    public arp mPS = null;
    private arq mPT = null;

    public h(int i, long j, long j2) {
        a aVar = new a();
        aVar.hsm = new arp();
        aVar.hsn = new arq();
        aVar.hsl = 824;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnheartbeat";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        long currentTimeMillis = System.currentTimeMillis();
        this.mPS = (arp) this.gUA.hsj.hsr;
        this.mPS.tvL = i;
        this.mPS.tvM = j;
        this.mPS.tVZ = j2;
        this.mPS.tVW = currentTimeMillis;
        w.d("MicroMsg.NetSceneIPCallHeartBeat", "heartbeat, roomId: %d, roomKey: %d, callSeq: %d, timestamp: %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), Long.valueOf(j2), Long.valueOf(currentTimeMillis)});
    }

    public final int getType() {
        return 824;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneIPCallHeartBeat", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mPT = (arq) ((b) pVar).hsk.hsr;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
