package com.tencent.mm.plugin.label.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.amx;
import com.tencent.mm.protocal.c.amy;
import com.tencent.mm.protocal.c.bio;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class d extends k implements j {
    private final b gUA;
    private e gUD;
    private LinkedList<bio> mYW = new LinkedList();

    public d(LinkedList<bio> linkedList) {
        a aVar = new a();
        aVar.hsm = new amx();
        aVar.hsn = new amy();
        aVar.uri = "/cgi-bin/micromsg-bin/modifycontactlabellist";
        aVar.hsl = 638;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.mYW = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 638;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.Label.NetSceneModifyContactLabelList", "cpan[doScene].");
        this.gUD = eVar2;
        amx com_tencent_mm_protocal_c_amx = (amx) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_amx.tRC = this.mYW;
        com_tencent_mm_protocal_c_amx.tDK = this.mYW.size();
        return a(eVar, this.gUA, this);
    }
}
