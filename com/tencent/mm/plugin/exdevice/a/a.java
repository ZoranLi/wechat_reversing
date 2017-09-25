package com.tencent.mm.plugin.exdevice.a;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.b;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public abstract class a<RequestType extends com.tencent.mm.bd.a, ResponseType extends com.tencent.mm.bd.a> extends k implements j {
    private e gWW;
    protected b laq;

    public abstract RequestType aoL();

    public abstract ResponseType aoM();

    public abstract String getUri();

    public void c(RequestType requestType) {
    }

    public final ResponseType abn() {
        if (this.laq == null || this.laq.hsk.hsr == null) {
            return null;
        }
        return this.laq.hsk.hsr;
    }

    public void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.BaseNetScene", "onGYNetEnd netId %d, errType %d, errCode %d, errMsg %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gWW != null) {
            this.gWW.a(i2, i3, str, this);
        }
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.gWW = eVar2;
        if (this.laq == null) {
            com.tencent.mm.y.b.a aVar = new com.tencent.mm.y.b.a();
            aVar.hsl = getType();
            aVar.uri = getUri();
            aVar.hsm = aoL();
            aVar.hsn = aoM();
            aVar.hso = 0;
            aVar.hsp = 0;
            this.laq = aVar.BE();
            c(this.laq.hsj.hsr);
        }
        return a(eVar, this.laq, this);
    }
}
