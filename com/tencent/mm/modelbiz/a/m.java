package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.mn;
import com.tencent.mm.protocal.c.mo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class m extends k implements j {
    Object data;
    public b gUA;
    private e gUD;
    public String hxu;

    public m(String str, String str2, String str3, Object obj) {
        a aVar = new a();
        aVar.hsm = new mn();
        aVar.hsn = new mo();
        aVar.uri = "/cgi-bin/mmocbiz-bin/convertbizchat";
        this.gUA = aVar.BE();
        mn mnVar = (mn) this.gUA.hsj.hsr;
        mnVar.tsS = str;
        mnVar.tsU = str2;
        mnVar.tsT = str3;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneConvertBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1315;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.NetSceneConvertBizChat", "do scene");
        return a(eVar, this.gUA, this);
    }

    public final mo Ea() {
        if (this.gUA == null || this.gUA.hsk.hsr == null) {
            return null;
        }
        return (mo) this.gUA.hsk.hsr;
    }
}
