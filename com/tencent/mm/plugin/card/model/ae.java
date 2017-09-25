package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.asm;
import com.tencent.mm.protocal.c.xn;
import com.tencent.mm.protocal.c.xo;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class ae extends k implements j {
    private final b gUA;
    private e gUD;
    public asm kfX;

    public ae(LinkedList<String> linkedList, int i) {
        a aVar = new a();
        aVar.hsm = new xn();
        aVar.hsn = new xo();
        aVar.uri = "/cgi-bin/micromsg-bin/getdynamiccardcode";
        aVar.hsl = 1382;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        xn xnVar = (xn) this.gUA.hsj.hsr;
        xnVar.tEd = linkedList;
        xnVar.scene = i;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetDynamicCardCode", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            this.kfX = ((xo) this.gUA.hsk.hsr).tEe;
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1382;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }
}
