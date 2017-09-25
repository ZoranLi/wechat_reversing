package com.tencent.mm.plugin.webview.b;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.awu;
import com.tencent.mm.protocal.c.awv;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class b extends k implements j {
    private final com.tencent.mm.y.b gUA;
    private e gWW;
    private int kMP;
    private long kMa = 0;
    private byte[] kNa = null;
    private String kNc;
    int rVf = -1;
    boolean rVg = true;

    public b(int i, String str, byte[] bArr, int i2, long j) {
        a aVar = new a();
        aVar.hsm = new awu();
        aVar.hsn = new awv();
        aVar.uri = "/cgi-bin/micromsg-bin/mmsearchemotion";
        aVar.hsl = 234;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.kMP = i;
        this.kNc = str;
        this.kNa = bArr;
        this.rVf = i2;
        this.kMa = j;
    }

    public final int getType() {
        return 234;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        awu com_tencent_mm_protocal_c_awu = (awu) this.gUA.hsj.hsr;
        if (bg.bm(this.kNa)) {
            com_tencent_mm_protocal_c_awu.tDW = new avw();
            this.rVg = true;
        } else {
            com_tencent_mm_protocal_c_awu.tDW = n.G(this.kNa);
            this.rVg = false;
            com_tencent_mm_protocal_c_awu.tDZ = this.kMa;
        }
        w.d("MicroMsg.emoji.NetSceneSearchEmotion", com_tencent_mm_protocal_c_awu.tDW == null ? "Buf is NULL" : com_tencent_mm_protocal_c_awu.tDW.toString());
        com_tencent_mm_protocal_c_awu.tiJ = this.kMP;
        com_tencent_mm_protocal_c_awu.tDX = this.kNc;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.emoji.NetSceneSearchEmotion", "netId %d | errType %d | errCode %d | errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        this.gWW.a(i2, i3, str, this);
    }

    public final awv bwb() {
        return this.gUA == null ? null : (awv) this.gUA.hsk.hsr;
    }
}
