package com.tencent.mm.plugin.game.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.sx;
import com.tencent.mm.protocal.c.sy;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class an extends k implements j {
    public String fDs;
    private e gUD;
    public final b ldw;

    public an(String str, String str2, LinkedList<String> linkedList) {
        a aVar = new a();
        aVar.hsm = new sx();
        aVar.hsn = new sy();
        aVar.uri = "/cgi-bin/mmgame-bin/gamecentersearchrecommend";
        aVar.hsl = 1329;
        aVar.hso = 0;
        aVar.hsp = 0;
        if (str2 == null) {
            this.fDs = "";
        } else {
            this.fDs = str2.trim();
        }
        this.ldw = aVar.BE();
        sx sxVar = (sx) this.ldw.hsj.hsr;
        sxVar.mtJ = str;
        sxVar.tAN = str2;
        sxVar.tAO = linkedList;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.ldw, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGameSearchRecmd", "errType = " + i2 + ", errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1329;
    }
}
