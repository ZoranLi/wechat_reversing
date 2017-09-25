package com.tencent.mm.modelbiz.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.hp;
import com.tencent.mm.protocal.c.vi;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public final class r extends k implements j {
    Object data;
    public b gUA;
    private e gUD;
    Map<String, String> hxx = new HashMap();

    public r(LinkedList<hp> linkedList, Object obj) {
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            hp hpVar = (hp) it.next();
            LinkedList linkedList2 = hpVar.tlL;
            String str = hpVar.tkL;
            if (!(str == null || linkedList2 == null || linkedList2.size() <= 0)) {
                Iterator it2 = linkedList2.iterator();
                while (it2.hasNext()) {
                    this.hxx.put((String) it2.next(), str);
                }
            }
        }
        a aVar = new a();
        aVar.hsm = new vi();
        aVar.hsn = new vj();
        aVar.uri = "/cgi-bin/mmocbiz-bin/getbizchatuserinfolist";
        aVar.hsl = 1353;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((vi) this.gUA.hsj.hsr).tCL = linkedList;
        this.data = obj;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "onGYNetEnd code(%d, %d)", Integer.valueOf(i2), Integer.valueOf(i3));
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
    }

    public final int getType() {
        return 1353;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        w.i("MicroMsg.brandservice.NetSceneGetBizChatUserInfoList", "do scene");
        return a(eVar, this.gUA, this);
    }
}
