package com.tencent.mm.plugin.report.b;

import com.tencent.mars.smc.SmcLogic;
import com.tencent.mars.smc.SmcProtoBufUtil;
import com.tencent.mm.kernel.a;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.a.a.c;
import com.tencent.mm.protocal.a.a.f;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.aey;
import com.tencent.mm.protocal.c.wx;
import com.tencent.mm.protocal.c.wy;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class h extends k implements j {
    private static boolean aJi = false;
    private static Object lock = new Object();
    private b gUA;
    private e gUD;
    private a oTs = new a();
    private wx oTw = null;

    public static boolean isRunning() {
        boolean z;
        synchronized (lock) {
            z = aJi;
        }
        return z;
    }

    private static void gD(boolean z) {
        synchronized (lock) {
            aJi = z;
        }
    }

    public h() {
        gD(true);
        this.oTw = SmcProtoBufUtil.toMMGetStrategyReq();
        this.oTw.trJ = new aey();
        this.oTw.trJ.tKh = this.oTs.rW(0);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (com.tencent.mm.kernel.h.vH().gXC == null || com.tencent.mm.kernel.h.vH().gXC.hsZ == null) {
            w.f("MicroMsg.NetSceneGetCliKVStrategy", "null == network().getNetSceneQueue().getDispatcher(), can't give response to kvcomm.");
            this.gUD.a(i2, i3, str, this);
        } else if (i2 != 0) {
            w.e("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy err, errType:" + i2 + ", errCode:" + i3);
            SmcLogic.OnStrategyResp(i2, i3, null, 1);
            SmcLogic.OnStrategyResp(i2, i3, null, 2);
            this.gUD.a(i2, i3, str, this);
            gD(false);
        } else {
            w.d("MicroMsg.NetSceneGetCliKVStrategy", "get report strategy ok");
            wy wyVar = (wy) this.gUA.hsk.hsr;
            this.oTs.a(wyVar.trT, 0);
            try {
                f toSmcKVStrategyResp = SmcProtoBufUtil.toSmcKVStrategyResp(wyVar);
                c toSmcIdkeyStrategyResp = SmcProtoBufUtil.toSmcIdkeyStrategyResp(wyVar);
                SmcLogic.OnStrategyResp(0, 0, toSmcKVStrategyResp.toByteArray(), 1);
                SmcLogic.OnStrategyResp(0, 0, toSmcIdkeyStrategyResp.toByteArray(), 2);
            } catch (Throwable e) {
                w.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bg.g(e));
            }
            this.gUD.a(i2, i3, str, this);
            gD(false);
        }
    }

    public final int getType() {
        com.tencent.mm.kernel.h.vG();
        return a.uU() ? 988 : 989;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        com.tencent.mm.kernel.h.vG();
        boolean uU = a.uU();
        if (!uU) {
            this.oTw.trI = com.tencent.mm.bd.b.aU(bg.bJQ());
        }
        b.a aVar = new b.a();
        aVar.hsq = false;
        aVar.hsm = this.oTw;
        aVar.hsn = new wy();
        aVar.uri = uU ? "/cgi-bin/micromsg-bin/getkvidkeystrategy" : "/cgi-bin/micromsg-bin/getkvidkeystrategyrsa";
        aVar.hsl = getType();
        this.gUA = aVar.BE();
        if (!uU) {
            this.gUA.a(ac.bHt());
            this.gUA.fYs = 1;
        }
        int a = a(eVar, this.gUA, this);
        if (a < 0) {
            w.i("MicroMsg.NetSceneGetCliKVStrategy", "mark all failed. do scene %d", Integer.valueOf(a));
            try {
                SmcLogic.OnStrategyResp(3, -1, null, 1);
                SmcLogic.OnStrategyResp(3, -1, null, 2);
                gD(false);
            } catch (Throwable e) {
                w.e("MicroMsg.NetSceneGetCliKVStrategy", "onReportStrategyResp failed  hash:%d  , ex:%s", Integer.valueOf(hashCode()), bg.g(e));
            }
        }
        return a;
    }
}
