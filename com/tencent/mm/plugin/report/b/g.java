package com.tencent.mm.plugin.report.b;

import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ae;
import com.tencent.mm.protocal.c.af;
import com.tencent.mm.protocal.c.tr;
import com.tencent.mm.protocal.c.ts;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class g extends k implements j {
    private static boolean aJi = false;
    private static Object lock = new Object();
    private b gUA;
    private e gUD;
    private tr oTu = null;
    public af oTv;

    private static void gD(boolean z) {
        synchronized (lock) {
            aJi = z;
        }
    }

    public g(int i, int i2) {
        gD(true);
        ae aeVar = new ae();
        this.oTu = new tr();
        try {
            aeVar.tcI = i;
            aeVar.tcJ = i2;
            this.oTu.tBY = aeVar;
        } catch (Exception e) {
            w.e("MicroMsg.NetSceneGetAPMStrategy", "parse data error");
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        try {
            this.oTv = null;
            if (h.vH().gXC == null || h.vH().gXC.hsZ == null) {
                w.f("MicroMsg.NetSceneGetAPMStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
                this.gUD.a(i2, i3, str, this);
            } else if (i2 != 0) {
                w.e("MicroMsg.NetSceneGetAPMStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
                this.gUD.a(i2, i3, str, this);
                gD(false);
            } else {
                w.d("MicroMsg.NetSceneGetAPMStrategy", "get report strategy ok");
                this.oTv = ((ts) this.gUA.hsk.hsr).tBZ;
                this.gUD.a(i2, i3, str, this);
                gD(false);
            }
        } finally {
            gD(false);
        }
    }

    public final int getType() {
        return 914;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        h.vG();
        if (a.uU()) {
            b.a aVar = new b.a();
            aVar.hsq = false;
            aVar.hsm = this.oTu;
            aVar.hsn = new ts();
            aVar.uri = "/cgi-bin/micromsg-bin/getapmstrategy";
            aVar.hsl = 914;
            this.gUA = aVar.BE();
            int a = a(eVar, this.gUA, this);
            if (a >= 0) {
                return a;
            }
            w.i("MicroMsg.NetSceneGetAPMStrategy", "mark all failed. do scene %d", Integer.valueOf(a));
            try {
                this.oTv = null;
                gD(false);
                return a;
            } catch (Throwable e) {
                w.e("MicroMsg.NetSceneGetAPMStrategy", "onStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bg.g(e));
                return a;
            }
        }
        w.w("MicroMsg.NetSceneGetAPMStrategy", "get mrs strategy must go after login");
        return -1;
    }
}
