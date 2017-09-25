package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.gr;
import com.tencent.mm.protocal.c.vc;
import com.tencent.mm.protocal.c.vd;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class p extends k implements j {
    public b gUA;
    private e gUD;
    Map<String, String> hxw = new HashMap();

    public p(LinkedList<gr> linkedList) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            gr grVar = (gr) it.next();
            String str = grVar.tkF;
            String str2 = grVar.tkL;
            if (!(str2 == null || str == null)) {
                this.hxw.put(str, str2);
            }
        }
        a aVar = new a();
        aVar.hsm = new vc();
        aVar.hsn = new vd();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatinfolist";
        aVar.hsl = 1365;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((vc) this.gUA.hsj.hsr).tCJ = linkedList;
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        w.d("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1365;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.brandservice.NetSceneGetBizChatInfoList", "do scene");
        return a(eVar, this.gUA, this);
    }
}
