package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.afz;
import com.tencent.mm.protocal.c.aga;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class t extends k implements j {
    Object data;
    public b gUA;
    private e gUD;
    public String hxu;

    public t(String str, String str2, LinkedList<String> linkedList, Object obj) {
        a aVar = new a();
        aVar.hsm = new afz();
        aVar.hsn = new aga();
        aVar.uri = "/cgi-bin/mmocbiz-bin/initiatebizchat";
        this.gUA = aVar.BE();
        afz com_tencent_mm_protocal_c_afz = (afz) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_afz.tsS = str;
        if (str2 == null) {
            str2 = "";
        }
        com_tencent_mm_protocal_c_afz.tLd = str2;
        com_tencent_mm_protocal_c_afz.tLe = linkedList;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneInitiateBizChat", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1389;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.NetSceneInitiateBizChat", "do scene");
        return a(eVar, this.gUA, this);
    }

    public final aga Ed() {
        if (this.gUA == null || this.gUA.hsk.hsr == null) {
            return null;
        }
        return (aga) this.gUA.hsk.hsr;
    }
}
