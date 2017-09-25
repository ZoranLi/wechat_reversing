package com.tencent.mm.plugin.chatroom.d;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.aeh;
import com.tencent.mm.protocal.c.lx;
import com.tencent.mm.protocal.c.ly;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class e extends k implements j {
    private LinkedList<aeh> fPl;
    private final b gUA;
    private com.tencent.mm.y.e gUD;

    public e(LinkedList<aeh> linkedList) {
        this.fPl = linkedList;
        a aVar = new a();
        aVar.hsm = new lx();
        aVar.hsn = new ly();
        aVar.uri = "/cgi-bin/micromsg-bin/collectchatroom";
        aVar.hsl = 181;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        lx lxVar = (lx) this.gUA.hsj.hsr;
        lxVar.tsg = linkedList;
        lxVar.tsf = linkedList.size();
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 181;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneCollectChatRoom", "netId : " + i + " errType :" + i2 + " errCode: " + i3 + " errMsg :" + str);
        if (pVar.zg().sZC != 0) {
            this.gUD.a(i2, i3, str, this);
            return;
        }
        if (this.fPl != null) {
            Iterator it = this.fPl.iterator();
            while (it.hasNext()) {
                aeh com_tencent_mm_protocal_c_aeh = (aeh) it.next();
                w.d("MicroMsg.NetSceneCollectChatRoom", "del groupcard Name :" + com_tencent_mm_protocal_c_aeh.tJB);
                com.tencent.mm.u.j.ex(com_tencent_mm_protocal_c_aeh.tJB);
            }
        }
        this.gUD.a(i2, i3, str, this);
    }
}
