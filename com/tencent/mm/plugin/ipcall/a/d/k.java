package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aru;
import com.tencent.mm.protocal.c.arv;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class k extends com.tencent.mm.y.k implements j {
    private b gUA = null;
    private e gUD = null;
    public aru mPY = null;
    public arv mPZ = null;

    public k(int i, long j, long j2) {
        a aVar = new a();
        aVar.hsm = new aru();
        aVar.hsn = new arv();
        aVar.hsl = 726;
        aVar.uri = "/cgi-bin/micromsg-bin/pstnredirect";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.mPY = (aru) this.gUA.hsj.hsr;
        this.mPY.tvL = i;
        this.mPY.tvM = j;
        this.mPY.tVZ = j2;
    }

    public final int getType() {
        return 726;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneIPCallRedirect", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mPZ = (arv) ((b) pVar).hsk.hsr;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
