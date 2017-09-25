package com.tencent.mm.plugin.scanner.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.hd;
import com.tencent.mm.protocal.c.he;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.b.a;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class f extends k implements j {
    public int fFo;
    public int fFp;
    private b gUA;
    private e gUD;
    public boolean oWk = false;

    public f(int i, String str, int i2, int i3) {
        a aVar = new a();
        aVar.hsm = new hd();
        aVar.hsn = new he();
        aVar.uri = "/cgi-bin/mmbiz-bin/usrmsg/bizscanbarcode";
        aVar.hsl = 1061;
        aVar.hso = 0;
        aVar.hsp = 0;
        this.gUA = aVar.BE();
        hd hdVar = (hd) this.gUA.hsj.hsr;
        hdVar.jOc = i;
        hdVar.tlh = str;
        hdVar.tdM = 1;
        this.fFo = i2;
        this.fFp = i3;
        w.d("MicroMsg.scanner.NetSceneScanBarcode", "NetSceneScanBarcode, type: %s, barcode: %s, scene: %s, codetype: %s, codeVersion: %s", new Object[]{Integer.valueOf(i), str, Integer.valueOf(1), Integer.valueOf(i2), Integer.valueOf(i3)});
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.gUA, this);
    }

    protected final int a(p pVar) {
        hd hdVar = (hd) ((b) pVar).hsj.hsr;
        if (hdVar.jOc >= 0 && hdVar.tlh != null && hdVar.tlh.length() > 0) {
            return k.b.hsT;
        }
        w.e("MicroMsg.scanner.NetSceneScanBarcode", "securityVerificationChecked failed, Type = " + hdVar.jOc + ", Barcode = %s" + hdVar.tlh);
        return k.b.hsU;
    }

    public final he aXZ() {
        if (this.gUA == null || this.gUA.hsk.hsr == null) {
            return null;
        }
        return (he) this.gUA.hsk.hsr;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.scanner.NetSceneScanBarcode", "onGYNetEnd errtype:" + i2 + " errcode:" + i3 + " errMsg:" + str);
        this.gUD.a(i2, i3, str, this);
    }

    public final int getType() {
        return 1061;
    }
}
