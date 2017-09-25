package com.tencent.mm.plugin.subapp.c;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.protocal.c.aoo;
import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.bjq;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class a extends k implements j {
    private b gUA;
    private e gUD;

    public a(LinkedList<bjq> linkedList, int i) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new aoo();
        aVar.hsn = new aop();
        aVar.uri = "/cgi-bin/micromsg-bin/opvoicereminder";
        aVar.hso = ck.CTRL_INDEX;
        aVar.hsp = 1000000150;
        this.gUA = aVar.BE();
        aoo com_tencent_mm_protocal_c_aoo = (aoo) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_aoo.tce = 1;
        com_tencent_mm_protocal_c_aoo.tTE = linkedList;
        com_tencent_mm_protocal_c_aoo.tTD = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 331;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }
}
