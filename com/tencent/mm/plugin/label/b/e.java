package com.tencent.mm.plugin.label.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aim;
import com.tencent.mm.protocal.c.bgk;
import com.tencent.mm.protocal.c.bgl;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;

public final class e extends k implements j {
    private final b gUA;
    private com.tencent.mm.y.e gUD;
    private aim mYX = null;

    public e(int i, String str) {
        a aVar = new a();
        aVar.hsm = new bgk();
        aVar.hsn = new bgl();
        aVar.uri = "/cgi-bin/micromsg-bin/updatecontactlabel";
        aVar.hsl = 637;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        if (i >= 0 && !bg.mA(str)) {
            this.mYX = new aim();
            this.mYX.tMv = i;
            this.mYX.tMu = str;
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[onGYNetEnd] netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 637;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        bgk com_tencent_mm_protocal_c_bgk = (bgk) this.gUA.hsj.hsr;
        if (this.mYX != null) {
            com_tencent_mm_protocal_c_bgk.ugD = this.mYX;
            return a(eVar, this.gUA, this);
        }
        w.e("MicroMsg.Label.NetSceneUpdateContactLabel", "cpan[doScene] label pair is null.");
        eVar2.a(3, -1, "[doScene]empty label pair.", this);
        return 0;
    }
}
