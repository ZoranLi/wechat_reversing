package com.tencent.mm.ao;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aov;
import com.tencent.mm.protocal.c.aow;
import com.tencent.mm.protocal.c.avw;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.protocal.c.lv;
import com.tencent.mm.protocal.k.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.e;
import com.tencent.mm.y.i;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.List;

public final class a extends k implements j {
    private e gUD;
    public a hNo;
    public final List<com.tencent.mm.plugin.messenger.foundation.a.a.e.b> hNp = new ArrayList();

    static class b extends d implements com.tencent.mm.protocal.k.b {
        public aov hNs = new aov();

        b() {
        }

        public final byte[] zh() {
            return this.hNs.toByteArray();
        }

        public final int zi() {
            return 681;
        }
    }

    static class c extends com.tencent.mm.protocal.k.e implements com.tencent.mm.protocal.k.c {
        public aow hNt = new aow();

        c() {
        }

        public final int y(byte[] bArr) {
            this.hNt = (aow) new aow().aD(bArr);
            return this.hNt.thX;
        }
    }

    static class a extends i {
        private final b hNq = new b();
        final c hNr = new c();

        public final d zf() {
            return this.hNq;
        }

        public final com.tencent.mm.protocal.k.e zg() {
            return this.hNr;
        }

        public final int getType() {
            return 681;
        }

        public final String getUri() {
            return "/cgi-bin/micromsg-bin/oplog";
        }
    }

    public a(List<com.tencent.mm.plugin.messenger.foundation.a.a.e.b> list) {
        this.hNp.addAll(list);
        this.hNo = new a();
        ((b) this.hNo.BG()).hNs.tSS = J(list);
    }

    private static lv J(List<com.tencent.mm.plugin.messenger.foundation.a.a.e.b> list) {
        lv lvVar = new lv();
        for (com.tencent.mm.plugin.messenger.foundation.a.a.e.b bVar : list) {
            byte[] buffer = bVar.getBuffer();
            lu luVar = new lu();
            luVar.tsa = bVar.getCmdId();
            luVar.tsb = new avw().bb(buffer);
            lvVar.jNe.add(luVar);
        }
        lvVar.jNd = list.size();
        w.d("MicroMsg.NetSceneOplog", "summeroplog oplogs size=" + list.size());
        return lvVar;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.hNo, this);
    }

    protected final int a(p pVar) {
        return b.hsT;
    }

    protected final int ub() {
        return 5;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 681;
    }
}
