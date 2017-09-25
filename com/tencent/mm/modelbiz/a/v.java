package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.atc;
import com.tencent.mm.protocal.c.atd;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class v extends k implements j {
    public b gUA;
    private e gUD;

    public v(String str, String str2, int i) {
        a aVar = new a();
        aVar.hsm = new atc();
        aVar.hsn = new atd();
        aVar.uri = "/cgi-bin/mmocbiz-bin/qymsgstatenotify";
        this.gUA = aVar.BE();
        atc com_tencent_mm_protocal_c_atc = (atc) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_atc.tkL = str;
        com_tencent_mm_protocal_c_atc.tkF = str2;
        com_tencent_mm_protocal_c_atc.time_stamp = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneQyMsgStateNotify", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1361;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.NetSceneQyMsgStateNotify", "do scene");
        return a(eVar, this.gUA, this);
    }
}
