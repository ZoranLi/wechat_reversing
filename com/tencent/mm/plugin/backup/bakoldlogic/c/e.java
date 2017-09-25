package com.tencent.mm.plugin.backup.bakoldlogic.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.wz;
import com.tencent.mm.protocal.c.xa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;

public final class e extends k implements j {
    private final b gUA;
    private com.tencent.mm.y.e gUD;

    public e(String str) {
        w.i("MicroMsg.NetSceneGetConnectInfo", "summerbak NetSceneGetConnectInfo init, url[%s], stack[%s]", new Object[]{str, bg.bJZ()});
        a aVar = new a();
        aVar.hsm = new wz();
        aVar.hsn = new xa();
        aVar.uri = "/cgi-bin/micromsg-bin/getconnectinfo";
        aVar.hso = 0;
        aVar.hsp = 0;
        aVar.hsl = 595;
        this.gUA = aVar.BE();
        ((wz) this.gUA.hsj.hsr).URL = str;
    }

    public final int getType() {
        return 595;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final xa acy() {
        return (xa) this.gUA.hsk.hsr;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetConnectInfo", "errType %d,  errCode %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            xa xaVar = (xa) this.gUA.hsk.hsr;
            com.tencent.mm.plugin.backup.a.e.N(xaVar.thF.tZp.sYA);
            w.i("MicroMsg.NetSceneGetConnectInfo", "id:%s  hello:%s, ok:%s, PCName:%s, PCAcctName:%s, scene:%d", new Object[]{xaVar.ID, xaVar.tib, xaVar.tic, xaVar.thT, xaVar.thU, Integer.valueOf(xaVar.tdM)});
            w.i("MicroMsg.NetSceneGetConnectInfo", "resource:%s", new Object[]{xaVar.tDJ});
            com.tencent.mm.bd.b bVar = xaVar.thF.tZp;
        }
        this.gUD.a(i2, i3, str, this);
    }
}
