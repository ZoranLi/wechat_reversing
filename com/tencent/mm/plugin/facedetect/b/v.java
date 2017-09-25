package com.tencent.mm.plugin.facedetect.b;

import com.tencent.mm.modelcdntran.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.facedetect.b.i.a;
import com.tencent.mm.protocal.c.anj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;
import com.tencent.mm.y.k.b;

public final class v extends p implements j, b {
    private final p htt = new h();
    private long lvl = -1;
    private byte[] lvm = null;

    public final long ark() {
        return this.lvl;
    }

    public final byte[] arl() {
        return this.lvm;
    }

    public v(int i) {
        a aVar = (a) this.htt.BG();
        aVar.luR.tCE = p.lvg;
        aVar.luR.jOc = 1;
        aVar.luR.tdM = i;
    }

    final int g(e eVar) {
        return a(eVar, this.htt, this);
    }

    protected final int ub() {
        return 3;
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final void a(k.a aVar) {
    }

    public final int getType() {
        return 733;
    }

    public final void b(int i, int i2, String str, p pVar) {
        w.d("MicroMsg.NetSceneGetBioConfigRsa", "hy: onGYNetEnd  errType:" + i + " errCode:" + i2);
        if (i == 0 && i2 == 0) {
            i.b bVar = (i.b) pVar.zg();
            this.lvl = bVar.luS.tCF;
            if (bVar.luS.tCG != null) {
                this.lvm = bVar.luS.tCG.sYA;
            }
            if (bVar.luS.tCI != null) {
                byte[] bArr;
                byte[] bArr2;
                if (bVar.luS.tCI.tpf == null || bVar.luS.tCI.tpf.tZn <= 0) {
                    bArr = null;
                } else {
                    w.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd cdnrule:%d", new Object[]{Integer.valueOf(bVar.luS.tCI.tpf.tZn)});
                    bArr = n.a(bVar.luS.tCI.tpf);
                }
                if (bVar.luS.tCI.tpg == null || bVar.luS.tCI.tpg.tZn <= 0) {
                    bArr2 = null;
                } else {
                    w.i("MicroMsg.NetSceneGetBioConfigRsa", "summersafecdn onGYNetEnd safecdnrule:%d", new Object[]{Integer.valueOf(bVar.luS.tCI.tpg.tZn)});
                    bArr2 = n.a(bVar.luS.tCI.tpg);
                }
                g.Em().a(bVar.luS.tCI.tpc, bVar.luS.tCI.tpd, bVar.luS.tCI.tpe, bArr, bArr2, bVar.luS.tCI.tph);
            }
            String str2 = "MicroMsg.NetSceneGetBioConfigRsa";
            String str3 = "hy: get bio config: bioId: %s, bioConfigSize: %d";
            Object[] objArr = new Object[2];
            objArr[0] = Long.valueOf(this.lvl);
            objArr[1] = Integer.valueOf(this.lvm == null ? 0 : this.lvm.length);
            w.i(str2, str3, objArr);
        }
        this.gUD.a(i, i2, str, this);
    }

    final void vE(String str) {
        ((a) this.htt.BG()).luR.tCE = str;
    }

    protected final anj f(p pVar) {
        return ((i.b) pVar.zg()).luS.tCH;
    }
}
