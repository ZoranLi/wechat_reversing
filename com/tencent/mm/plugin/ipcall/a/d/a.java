package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.arl;
import com.tencent.mm.protocal.c.arm;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    private b gUA = null;
    private e gUD = null;
    public arl mPD = null;
    private arm mPE = null;

    public a(int i, long j, String str, String str2, int i2, long j2) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new arl();
        aVar.hsn = new arm();
        aVar.hsl = 843;
        aVar.uri = "/cgi-bin/micromsg-bin/pstncancelinvite";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        long currentTimeMillis = System.currentTimeMillis();
        this.mPD = (arl) this.gUA.hsj.hsr;
        this.mPD.tvL = i;
        this.mPD.tvM = j;
        this.mPD.mvU = str;
        this.mPD.tVW = currentTimeMillis;
        this.mPD.tVX = i2;
        this.mPD.tVY = str2;
        this.mPD.tVZ = j2;
        w.d("MicroMsg.NetSceneIPCallCancel", "roomId: %d, roomKey: %d, toUsername: %s, timestamp: %d, inviteId: %d, phoneNumber: %s, callseq: %d", new Object[]{Integer.valueOf(i), Long.valueOf(j), str, Long.valueOf(currentTimeMillis), Integer.valueOf(i2), str2, Long.valueOf(j2)});
    }

    public final int getType() {
        return 843;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneIPCallCancel", "errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mPE = (arm) ((b) pVar).hsk.hsr;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
