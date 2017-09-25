package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.abu;
import com.tencent.mm.protocal.c.beu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import java.util.Iterator;
import java.util.LinkedList;

public final class c extends f {
    private final b gUA;
    private e gUD;
    private int nXW = 0;
    private final String neP;
    public int qYE;
    public LinkedList<beu> qZa;

    public c(int i, long j, String str, int i2) {
        this.nXW = i2;
        a aVar = new a();
        aVar.hsm = new abt();
        aVar.hsn = new abu();
        aVar.uri = "/cgi-bin/micromsg-bin/gettalkroommember";
        aVar.hsl = 336;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        abt com_tencent_mm_protocal_c_abt = (abt) this.gUA.hsj.hsr;
        com_tencent_mm_protocal_c_abt.tvL = i;
        com_tencent_mm_protocal_c_abt.tvM = j;
        this.neP = str;
        com_tencent_mm_protocal_c_abt.tdM = i2;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.NetSceneGetTalkRoomMember", "doScene");
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 336;
    }

    public final String bnX() {
        return this.neP;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneGetTalkRoomMember", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            abu com_tencent_mm_protocal_c_abu = (abu) this.gUA.hsk.hsr;
            w.i("MicroMsg.NetSceneGetTalkRoomMember", "resp %s", new Object[]{com_tencent_mm_protocal_c_abu.toString()});
            this.qYE = com_tencent_mm_protocal_c_abu.tvN;
            this.qZa = ak(com_tencent_mm_protocal_c_abu.teK);
            this.gUD.a(i2, i3, str, this);
            return;
        }
        this.gUD.a(i2, i3, str, this);
    }

    private static LinkedList<beu> ak(LinkedList<beu> linkedList) {
        LinkedList<beu> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            beu com_tencent_mm_protocal_c_beu = (beu) it.next();
            if (!bg.mA(com_tencent_mm_protocal_c_beu.jNj)) {
                linkedList2.add(com_tencent_mm_protocal_c_beu);
            }
        }
        return linkedList2;
    }

    public final int bnY() {
        return this.nXW;
    }
}
