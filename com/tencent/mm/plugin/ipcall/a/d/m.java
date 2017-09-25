package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ayi;
import com.tencent.mm.protocal.c.ayj;
import com.tencent.mm.protocal.c.bly;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class m extends k implements j {
    private b gUA = null;
    private e gUD;
    private ayi mQc = null;
    public ayj mQd = null;

    public m(int i, int i2, LinkedList<bly> linkedList) {
        a aVar = new a();
        aVar.hsm = new ayi();
        aVar.hsn = new ayj();
        aVar.hsl = 871;
        aVar.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.mQc = (ayi) this.gUA.hsj.hsr;
        this.mQc.tQH = i2;
        this.mQc.uat = linkedList;
        this.mQc.uas = linkedList.size();
        this.mQc.uau = i;
        w.i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(linkedList.size())});
    }

    public final int getType() {
        return 871;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneIPCallSendFeedback", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mQd = (ayj) ((b) pVar).hsk.hsr;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
