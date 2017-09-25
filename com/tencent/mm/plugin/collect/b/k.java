package com.tencent.mm.plugin.collect.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.jq;
import com.tencent.mm.protocal.c.jr;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;

public final class k extends com.tencent.mm.y.k implements j {
    private final String TAG = "MicroMsg.NetSceneMDRcvVoice";
    private b gUA;
    private e gUD;
    public jr kAS;

    public k(int i, com.tencent.mm.bd.b bVar, String str) {
        a aVar = new a();
        aVar.hsm = new jq();
        aVar.hsn = new jr();
        aVar.hsl = 1317;
        aVar.uri = "/cgi-bin/mmpay-bin/getmdrcvvoice";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        jq jqVar = (jq) this.gUA.hsj.hsr;
        jqVar.boy = i;
        jqVar.tpv = 1;
        jqVar.kBe = str;
        jqVar.tpt = null;
        jqVar.tpu = bVar;
        w.i("MicroMsg.NetSceneMDRcvVoice", "amount: %d, outtradeno: %s", new Object[]{Integer.valueOf(i), str});
    }

    public final int getType() {
        return 1317;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneMDRcvVoice", "errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.kAS = (jr) ((b) pVar).hsk.hsr;
        w.i("MicroMsg.NetSceneMDRcvVoice", "ret_code: %d, ret_msg: %s，voice_type: %d", new Object[]{Integer.valueOf(this.kAS.kAC), this.kAS.kAD, Integer.valueOf(this.kAS.tpv)});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
