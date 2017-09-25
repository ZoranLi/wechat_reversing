package com.tencent.mm.modelsimple;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.i;
import com.tencent.mm.protocal.c.lc;
import com.tencent.mm.protocal.c.ld;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class h extends k implements j {
    public static int hRL = 1;
    public static int hRM = 2;
    public static int hRN = 3;
    public static int hRO = 4;
    private b gUA;
    private e gUD;

    public h(int i) {
        a aVar = new a();
        aVar.hsm = new lc();
        aVar.hsn = new ld();
        aVar.uri = "/cgi-bin/micromsg-bin/checkunbind";
        aVar.hsl = i.CTRL_BYTE;
        this.gUA = aVar.BE();
        ((lc) this.gUA.hsj.hsr).trs = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final String IO() {
        try {
            String str = ((ld) this.gUA.hsk.hsr).trt;
            w.d("MicroMsg.NetSceneCheckUnBind", "getRandomPasswd() " + str);
            return str;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.NetSceneCheckUnBind", e, "", new Object[0]);
            return null;
        }
    }

    public final int getType() {
        return i.CTRL_BYTE;
    }

    public final ld IP() {
        return (ld) this.gUA.hsk.hsr;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        this.gUD.a(i2, i3, str, this);
    }
}
