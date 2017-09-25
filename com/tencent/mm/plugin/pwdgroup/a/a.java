package com.tencent.mm.plugin.pwdgroup.a;

import com.tencent.mm.modelstat.n;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.rh;
import com.tencent.mm.protocal.c.ri;
import com.tencent.mm.protocal.c.rj;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.x.h;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class a extends k implements j {
    private b gUA;
    private e gUD;
    public int owE;

    public a(int i, String str, String str2, float f, float f2, int i2, int i3, String str3, String str4) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new rh();
        aVar.hsn = new ri();
        aVar.uri = "/cgi-bin/micromsg-bin/mmfacingcreatechatroom";
        aVar.hsl = 653;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        rh rhVar = (rh) this.gUA.hsj.hsr;
        this.owE = i;
        rhVar.tce = i;
        rhVar.twP = str;
        rhVar.tuo = str2;
        rhVar.tmZ = f2;
        rhVar.tna = f;
        rhVar.twQ = i2;
        if (!bg.mA(str3)) {
            rhVar.twR = str3;
        }
        if (!bg.mA(str4)) {
            rhVar.twS = str4;
        }
        rhVar.twT = i3;
        w.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "OpCode:%d, Ticket:%s, Longitude:%f, Latitude:%f, Precision:%d, MackAddr:%s, CellId:%s, GPSSource:%d", new Object[]{Integer.valueOf(i), str2, Float.valueOf(f2), Float.valueOf(f), Integer.valueOf(i2), str3, str4, Integer.valueOf(i3)});
        n.a(2007, f2, f, i2);
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "netId:%d errType:%d errCode:%d errMsg:%s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.owE == 0) {
            ri aTT = aTT();
            if (aTT != null) {
                LinkedList linkedList = aTT.teK;
                if (linkedList != null) {
                    long currentTimeMillis = System.currentTimeMillis();
                    int size = linkedList.size();
                    List arrayList = new ArrayList();
                    for (int i4 = 0; i4 < size; i4++) {
                        rj rjVar = (rj) linkedList.get(i4);
                        h hVar = new h();
                        if (bg.mA(rjVar.jNj)) {
                            hVar.username = rjVar.twU;
                        } else {
                            hVar.username = rjVar.jNj;
                        }
                        w.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "cpan[onGYNetEnd]UserName:%s SmallImgUrl:%s", new Object[]{rjVar.jNj, rjVar.tuS});
                        hVar.hrA = rjVar.tuS;
                        hVar.aV(true);
                        arrayList.add(hVar);
                    }
                    com.tencent.mm.x.n.Bm().z(arrayList);
                    w.d("MicroMsg.Facing.NetSceneFacingCreateChatRoom", "use time:%s", new Object[]{(System.currentTimeMillis() - currentTimeMillis)});
                }
            }
        }
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 653;
    }

    public final ri aTT() {
        return (ri) this.gUA.hsk.hsr;
    }
}
