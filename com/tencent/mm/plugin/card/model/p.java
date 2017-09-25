package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.protocal.c.aj;
import com.tencent.mm.protocal.c.ak;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class p extends k implements j {
    private final b gUA;
    private e gUD;
    public String kfG;
    public int kfH;
    public String kfI;

    public p(LinkedList<iu> linkedList, int i, String str, String str2, int i2) {
        a aVar = new a();
        aVar.hsm = new aj();
        aVar.hsn = new ak();
        aVar.uri = "/cgi-bin/micromsg-bin/acceptcardlistfromapp";
        aVar.hsl = 687;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        aj ajVar = (aj) this.gUA.hsj.hsr;
        ajVar.tcT = linkedList;
        ajVar.fVn = i;
        ajVar.tcP = str;
        ajVar.tcO = str2;
        ajVar.tcQ = i2;
    }

    public final int getType() {
        return 687;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, com.tencent.mm.network.p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, errType = " + i2 + " errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            ak akVar = (ak) this.gUA.hsk.hsr;
            this.kfG = akVar.kfG;
            this.kfH = akVar.kfH;
            this.kfI = akVar.kfI;
            w.e("MicroMsg.NetSceneGetCardListFromApp", "onGYNetEnd, ret_code = " + this.kfH + " ret_msg = " + this.kfI);
        }
        this.gUD.a(i2, i3, str, this);
    }
}
