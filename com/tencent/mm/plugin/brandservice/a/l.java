package com.tencent.mm.plugin.brandservice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aki;
import com.tencent.mm.protocal.c.akl;
import com.tencent.mm.protocal.c.akm;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class l extends k implements j {
    public b gUA;
    private e gUD;

    public l(String str, LinkedList<aki> linkedList) {
        a aVar = new a();
        aVar.hsm = new akl();
        aVar.hsn = new akm();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/setrecvtmpmsgoption";
        aVar.hsl = 1030;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        akl com_tencent_mm_protocal_c_akl = (akl) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_akl.tKK = str;
        com_tencent_mm_protocal_c_akl.tOd = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "onGYNetEnd code(%d, %d)", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1030;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.brandservice.NetSceneSetRecvTmpMsgOption", "do scene");
        return a(eVar, this.gUA, this);
    }
}
