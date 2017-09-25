package com.tencent.mm.plugin.game.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.game.c.an;
import com.tencent.mm.plugin.game.c.ao;
import com.tencent.mm.plugin.game.c.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.Iterator;
import java.util.LinkedList;

public final class ar extends k implements j {
    private e gUD;
    public final b ldw;

    public ar(String str, LinkedList<String> linkedList, q qVar, q qVar2, q qVar3, boolean z) {
        w.i("MicroMsg.NetSceneGetGameIndex2", "lang = " + str + ", installedApp list size: " + linkedList.size());
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            w.i("MicroMsg.NetSceneGetGameIndex2", "install id:[%s]", new Object[]{(String) it.next()});
        }
        a aVar = new a();
        aVar.hsm = new an();
        aVar.hsn = new ao();
        aVar.uri = "/cgi-bin/mmgame-bin/getgameindex2";
        aVar.hsl = 1238;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.ldw = aVar.BE();
        an anVar = (an) this.ldw.hsj.hsr;
        anVar.mtJ = str;
        anVar.mue = linkedList;
        String ci = e.ci(ab.getContext());
        if (bg.mA(ci)) {
            ci = bg.bJW();
        }
        if (!bg.mA(k.countryCode)) {
            ci = k.countryCode;
        }
        anVar.hAM = ci;
        if (qVar == null) {
            if (qVar2 != null) {
                qVar = qVar2;
            } else if (qVar3 != null) {
                qVar = qVar3;
            } else {
                qVar = null;
            }
        }
        anVar.muf = new m();
        if (qVar != null) {
            anVar.muf.mta = qVar.mpR.mqG;
            anVar.muf.mtb = qVar.field_appId;
            anVar.muf.msg = qVar.mqz;
            if (qVar.field_msgType == 100) {
                anVar.muf.mtd = qVar.mqy;
            } else {
                anVar.muf.mtd = qVar.field_msgType;
            }
        }
        if (qVar2 != null) {
            m mVar = anVar.muf;
            mVar.mtc |= 1;
        }
        if (qVar3 != null) {
            mVar = anVar.muf;
            mVar.mtc |= 2;
        }
        anVar.mug = SubCoreGameCenter.aBB().aAY();
        anVar.muh = z;
        anVar.mtK = bg.bKe() ? 1 : 0;
        w.i("MicroMsg.NetSceneGetGameIndex2", "Country Code: %s", new Object[]{ci});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.ldw, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetGameIndex2", "errType = " + i2 + ", errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1238;
    }
}
