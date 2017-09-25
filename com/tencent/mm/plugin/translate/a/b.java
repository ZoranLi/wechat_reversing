package com.tencent.mm.plugin.translate.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.abv;
import com.tencent.mm.protocal.c.abw;
import com.tencent.mm.protocal.c.bft;
import com.tencent.mm.protocal.c.bfu;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class b extends k implements j {
    private final com.tencent.mm.y.b gUA;
    private e gUD = null;
    public LinkedList<bfu> rbI;

    public b(LinkedList<bft> linkedList) {
        a aVar = new a();
        aVar.hsm = new abv();
        aVar.hsn = new abw();
        aVar.uri = "/cgi-bin/micromsg-bin/gettranstext";
        aVar.hsl = 631;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        abv com_tencent_mm_protocal_c_abv = (abv) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_abv.tHv = linkedList;
        com_tencent_mm_protocal_c_abv.jNc = linkedList.size();
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 631;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        abw com_tencent_mm_protocal_c_abw = (abw) this.gUA.hsk.hsr;
        this.gUD.a(i2, i3, str, this);
        this.rbI = com_tencent_mm_protocal_c_abw.tHv;
    }
}
