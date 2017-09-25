package com.tencent.mm.modelsimple;

import com.tencent.mm.a.n;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.protocal.o.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;
import java.util.List;
import junit.framework.Assert;

public final class j extends k implements com.tencent.mm.network.j {
    public byte[] content;
    private e gUD;
    public String hRP = "";
    private p htt;

    public static class a extends i {
        private final com.tencent.mm.protocal.o.a hRQ = new com.tencent.mm.protocal.o.a();
        private final b hRR = new b();

        protected final d zf() {
            return this.hRQ;
        }

        public final com.tencent.mm.protocal.k.e zg() {
            return this.hRR;
        }

        public final int getType() {
            return 10;
        }

        public final String getUri() {
            return null;
        }
    }

    public j(List<String> list, byte[] bArr) {
        boolean z = true;
        boolean z2 = list.size() > 0 && bArr != null;
        Assert.assertTrue(z2);
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        String str = (String) list.get(0);
        for (int i = 1; i < list.size(); i++) {
            str = str + "," + ((String) list.get(i)).trim();
        }
        this.htt = new a();
        com.tencent.mm.protocal.o.a aVar = (com.tencent.mm.protocal.o.a) this.htt.BG();
        aVar.fJK = 111;
        aVar.fRW = 0;
        aVar.hTw = currentTimeMillis;
        Assert.assertTrue(str != null);
        aVar.sZM = str;
        if (bArr == null) {
            z = false;
        }
        Assert.assertTrue(z);
        aVar.sZN = bArr;
        w.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: cmdId=111" + " seq=" + currentTimeMillis);
        w.d("MicroMsg.NetSceneDirectSend", "NetSceneDirectSend: lstReceiver=" + str + " status = " + n.c(bArr, 0));
    }

    public j(com.tencent.mm.protocal.k.e eVar) {
        b bVar = (b) eVar;
        this.hRP = bVar.hRP;
        this.content = bVar.content;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.htt, this);
    }

    public final int getType() {
        return 10;
    }

    public final boolean BI() {
        return true;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }
}
