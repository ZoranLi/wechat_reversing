package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bev;
import com.tencent.mm.protocal.c.bew;
import com.tencent.mm.protocal.c.bex;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class g extends k implements j {
    private final b gUA;
    private e gUD;

    public g(LinkedList<bev> linkedList, int i) {
        a aVar = new a();
        aVar.hsm = new bew();
        aVar.hsn = new bex();
        aVar.uri = "/cgi-bin/micromsg-bin/talkstatreport";
        aVar.hsl = 373;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        bew com_tencent_mm_protocal_c_bew = (bew) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_bew.uft = linkedList.size();
        com_tencent_mm_protocal_c_bew.ufu = linkedList;
        com_tencent_mm_protocal_c_bew.tdM = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.NetSceneTalkStatReport", "doScene");
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 373;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneTalkStatReport", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            this.gUD.a(i2, i3, str, this);
        } else {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
