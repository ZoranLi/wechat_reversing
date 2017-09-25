package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.hf;
import com.tencent.mm.protocal.c.hg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class g extends k implements j {
    public b gUA;
    private e gUD;
    private int hrs;
    private byte[] oWf;
    private int oWg = 1;
    private int oWj;
    private int offset;

    public g(byte[] bArr, int i, int i2) {
        this.oWf = bArr;
        this.oWg = 1;
        this.hrs = i;
        this.offset = 0;
        this.oWj = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        a aVar = new a();
        aVar.hsm = new hf();
        aVar.hsn = new hg();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanimg";
        aVar.hsl = 1062;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        hf hfVar = (hf) this.gUA.hsj.hsr;
        hfVar.tli = ((int) bg.Nz()) & Integer.MAX_VALUE;
        hfVar.tlj = new avw().bb(this.oWf);
        hfVar.tlk = this.hrs;
        hfVar.tll = this.offset;
        if (this.offset + this.oWf.length < this.hrs) {
            hfVar.tiL = 0;
        } else {
            hfVar.tiL = 1;
        }
        hfVar.tlm = this.oWg;
        hfVar.tln = this.oWj;
        return a(eVar, this.gUA, this);
    }

    protected final int a(p pVar) {
        hf hfVar = (hf) ((b) pVar).hsj.hsr;
        if (hfVar.tli > 0 && hfVar.tlm >= 0 && hfVar.tlj != null && hfVar.tlj.tZn > 0 && hfVar.tlk > 0 && hfVar.tll >= 0 && hfVar.tll + hfVar.tlj.tZn <= hfVar.tlk) {
            return k.b.hsT;
        }
        w.e("MicroMsg.scanner.NetSceneScanImage", "ERR: Security Check Failed, imageType = %s, totalLen = %s, offset = %s", new Object[]{Integer.valueOf(hfVar.tlm), Integer.valueOf(hfVar.tlk), Integer.valueOf(hfVar.tll)});
        if (hfVar.tlj != null) {
            w.e("MicroMsg.scanner.NetSceneScanImage", "buffer length = %s", new Object[]{Integer.valueOf(hfVar.tlj.tZn)});
        }
        return k.b.hsU;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.scanner.NetSceneScanImage", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1062;
    }
}
