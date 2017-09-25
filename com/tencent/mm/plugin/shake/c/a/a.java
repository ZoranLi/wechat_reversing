package com.tencent.mm.plugin.shake.c.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.io;
import com.tencent.mm.protocal.c.ip;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends k implements j {
    private final b gUA;
    private e gUD;

    public a(String str, String str2) {
        com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
        aVar.hsm = new io();
        aVar.hsn = new ip();
        aVar.uri = "/cgi-bin/mmbiz-bin/card/cancelshakecard";
        aVar.hsl = 1252;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        io ioVar = (io) this.gUA.hsj.hsr;
        ioVar.kdE = str;
        ioVar.fVm = str2;
    }

    public final int getType() {
        return 1252;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneCancelShakeCard", "onGYNetEnd, getType = 1252" + " errType = " + i2 + " errCode = " + i3);
        this.gUD.a(i2, i3, str, this);
    }
}
