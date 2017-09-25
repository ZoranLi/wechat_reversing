package com.tencent.mm.plugin.sns.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.az;
import com.tencent.mm.protocal.c.ba;
import com.tencent.mm.protocal.c.bf;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import java.util.LinkedList;

public final class k extends com.tencent.mm.y.k implements j {
    private b gUA;
    public e gUD;
    private LinkedList<bf> pTL;

    public k(LinkedList<bf> linkedList) {
        a aVar = new a();
        aVar.hsm = new az();
        aVar.hsn = new ba();
        aVar.uri = "/cgi-bin/mmoc-bin/ad/addatareport";
        aVar.hsl = 1295;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((az) this.gUA.hsj.hsr).teq = linkedList;
        this.pTL = linkedList;
    }

    public final int getType() {
        return 1295;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneSnsAdDataReport", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        this.gUD.a(i2, i3, str, this);
    }
}
