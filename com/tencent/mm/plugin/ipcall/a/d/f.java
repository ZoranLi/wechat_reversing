package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.adc;
import com.tencent.mm.protocal.c.add;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class f extends k implements j {
    private b gUA = null;
    private e gUD;
    private adc mPN = null;
    public add mPO = null;
    public boolean mPP = true;

    public f(String str, String str2) {
        if (bg.mA(str2)) {
            this.mPP = true;
            str2 = "";
        } else {
            this.mPP = false;
        }
        a aVar = new a();
        aVar.hsm = new adc();
        aVar.hsn = new add();
        aVar.hsl = 929;
        aVar.uri = "/cgi-bin/micromsg-bin/getwcoproductlist";
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        this.mPN = (adc) this.gUA.hsj.hsr;
        this.mPN.tIy = str;
        this.mPN.tIz = str2;
        w.i("MicroMsg.NetSceneIPCallGetProductList", "NetSceneIPCallGetProductList");
    }

    public final int getType() {
        return 929;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneIPCallGetProductList", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.mPO = (add) ((b) pVar).hsk.hsr;
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }
}
