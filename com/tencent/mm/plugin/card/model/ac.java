package com.tencent.mm.plugin.card.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.wg;
import com.tencent.mm.protocal.c.wh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class ac extends k implements j {
    private final b gUA;
    private e gUD;
    public LinkedList<String> kcK;
    public int kcM;
    public int kcN;
    public int kcO;

    public ac(String str) {
        a aVar = new a();
        aVar.hsm = new wg();
        aVar.hsn = new wh();
        aVar.uri = "/cgi-bin/micromsg-bin/getcardserial";
        aVar.hsl = 577;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        ((wg) this.gUA.hsj.hsr).fVl = str;
    }

    public final int getType() {
        return 577;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, errType = %d, errCode = %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        if (i2 == 0 && i3 == 0) {
            wh whVar = (wh) this.gUA.hsk.hsr;
            this.kcK = whVar.kcK;
            this.kcM = whVar.kcM;
            this.kcN = whVar.kcN;
            this.kcO = whVar.kcO;
        }
        w.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp request_time = %d, request_count = %d, refresh_interval = %d,", new Object[]{Integer.valueOf(this.kcM), Integer.valueOf(this.kcN), Integer.valueOf(this.kcO)});
        if (this.kcK != null) {
            w.i("MicroMsg.NetSceneGetCardSerial", "onGYNetEnd, resp codes size is " + this.kcK.size());
        }
        this.gUD.a(i2, i3, str, this);
    }
}
