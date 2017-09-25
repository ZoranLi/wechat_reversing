package com.tencent.mm.modelstat;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.az;
import com.tencent.mm.protocal.c.ba;
import com.tencent.mm.protocal.c.bf;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class h extends k implements j {
    private final b gUA;
    private e gWW;

    public h(int i, String str, int i2) {
        a aVar = new a();
        aVar.hsm = new az();
        aVar.hsn = new ba();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/addatareport";
        aVar.hsl = 1295;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        az azVar = (az) this.gUA.hsj.hsr;
        bf bfVar = new bf();
        bfVar.teD = i;
        bfVar.teE = new com.tencent.mm.bd.b(str.getBytes());
        bfVar.teF = (long) i2;
        azVar.teq.add(bfVar);
        w.i("MicroMsg.NetSceneAdDataReport", "init logId:%d, logStr:%s", new Object[]{Integer.valueOf(i), str});
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        ba baVar = (ba) this.gUA.hsk.hsr;
        w.i("MicroMsg.NetSceneAdDataReport", "onGYNetEnd, errType = %d, errCode = %d, ret=%d, msg=%s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(baVar.ret), baVar.fEr});
        this.gWW.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1295;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        return a(eVar, this.gUA, this);
    }
}
