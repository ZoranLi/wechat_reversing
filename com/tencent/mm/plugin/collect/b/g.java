package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.jl;
import com.tencent.mm.protocal.c.jm;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class g extends k implements j {
    private e gUD;
    private b inV;
    public jm kAz;

    public g(int i, com.tencent.mm.bd.b bVar, String str) {
        a aVar = new a();
        aVar.hsm = new jl();
        aVar.hsn = new jm();
        aVar.hsl = 1384;
        aVar.uri = "/cgi-bin/mmpay-bin/getf2frcvvoice";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.inV = aVar.BE();
        jl jlVar = (jl) this.inV.hsj.hsr;
        jlVar.boy = i;
        jlVar.tpv = 1;
        jlVar.kBe = str;
        jlVar.tpt = null;
        jlVar.tpu = bVar;
        w.i("MicroMsg.NetSceneF2FRcvVoice", "amount: %d, outtradeno: %s", new Object[]{Integer.valueOf(i), str});
    }

    public final int getType() {
        return 1384;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.inV, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneF2FRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.kAz = (jm) ((b) pVar).hsk.hsr;
        w.i("MicroMsg.NetSceneF2FRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[]{Integer.valueOf(this.kAz.kAC), this.kAz.kAD, Integer.valueOf(this.kAz.tpv)});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
