package com.tencent.mm.plugin.game.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ta;
import com.tencent.mm.protocal.c.tb;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class am extends k implements j {
    private e gUD;
    public final b ldw;

    public am(String str, LinkedList<String> linkedList, LinkedList<String> linkedList2, int i) {
        a aVar = new a();
        aVar.hsm = new ta();
        aVar.hsn = new tb();
        aVar.uri = "/cgi-bin/mmgame-bin/gamecentersearch";
        aVar.hsl = 1328;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        ta taVar = (ta) this.ldw.hsj.hsr;
        taVar.mtJ = str;
        taVar.tAV = linkedList;
        taVar.tAO = linkedList2;
        taVar.tAW = i;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.ldw, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGameCenterSearch", "errType = " + i2 + ", errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1328;
    }
}
