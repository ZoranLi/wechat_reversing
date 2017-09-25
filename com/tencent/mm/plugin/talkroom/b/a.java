package com.tencent.mm.plugin.talkroom.b;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.bet;
import com.tencent.mm.protocal.c.beu;
import com.tencent.mm.protocal.c.pr;
import com.tencent.mm.protocal.c.ps;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import java.util.Iterator;
import java.util.LinkedList;

public final class a extends f {
    private final b gUA;
    private e gUD;
    public int mNL;
    public long mNM;
    private int nXW = 0;
    private final String neP;
    public int qYE;
    public int qYF;
    public LinkedList<bet> qYH;
    public LinkedList<beu> qZa;

    public a(String str, int i) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        this.nXW = i;
        aVar.hsm = new pr();
        aVar.hsn = new ps();
        aVar.uri = "/cgi-bin/micromsg-bin/entertalkroom";
        aVar.hsl = 332;
        aVar.hso = 147;
        aVar.hsp = 1000000147;
        this.gUA = aVar.BE();
        ((pr) this.gUA.hsj.hsr).tvK = str;
        ((pr) this.gUA.hsj.hsr).tdM = i;
        this.neP = str;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        w.d("MicroMsg.NetSceneEnterTalkRoom", "doScene %d", new Object[]{Integer.valueOf(this.nXW)});
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final int getType() {
        return 332;
    }

    public final String bnX() {
        return this.neP;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneEnterTalkRoom", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            ps psVar = (ps) this.gUA.hsk.hsr;
            w.i("MicroMsg.NetSceneEnterTalkRoom", "resp %s", new Object[]{psVar.toString()});
            this.mNL = psVar.tvL;
            this.mNM = psVar.tvM;
            this.qYE = psVar.tvN;
            this.qYF = psVar.tvP;
            this.qZa = ak(psVar.teK);
            this.qYH = al(psVar.thS);
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

    private static LinkedList<bet> al(LinkedList<bet> linkedList) {
        LinkedList<bet> linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            linkedList2.add((bet) it.next());
        }
        return linkedList2;
    }

    public final int bnY() {
        return this.nXW;
    }
}
