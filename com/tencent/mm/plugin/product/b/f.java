package com.tencent.mm.plugin.product.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.awb;
import com.tencent.mm.protocal.c.ik;
import com.tencent.mm.protocal.c.il;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class f extends k implements j {
    private b gUA;
    private e gUD;

    public f(LinkedList<awb> linkedList, String str) {
        int i = 0;
        a aVar = new a();
        aVar.hsm = new ik();
        aVar.hsn = new il();
        aVar.uri = "/cgi-bin/micromsg-bin/cancelpreorder";
        aVar.hsl = 555;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ik ikVar = (ik) this.gUA.hsj.hsr;
        ikVar.tnp = linkedList;
        if (linkedList != null) {
            i = linkedList.size();
        }
        ikVar.ogX = i;
        ikVar.tnq = str;
        w.d("MicroMsg.NetSceneMallCancelPreOrder", "lockId " + str);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        il ilVar = (il) ((b) pVar).hsk.hsr;
        if (i3 == 0 && ilVar.tnr != 0) {
            i3 = ilVar.tnr;
            str = ilVar.tns;
        }
        w.d("MicroMsg.NetSceneMallCancelPreOrder", "errCode " + i3 + ", errMsg " + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 555;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
