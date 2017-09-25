package com.tencent.mm.plugin.exdevice.c.a;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.protocal.c.mf;
import com.tencent.mm.protocal.c.mg;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;

public final class a extends com.tencent.mm.plugin.exdevice.a.a<mf, mg> {
    String appId;
    String fGl;
    String fwJ;
    String laQ;
    private WeakReference<b<a>> laR;

    protected final /* synthetic */ com.tencent.mm.bd.a aoL() {
        return new mf();
    }

    protected final /* synthetic */ com.tencent.mm.bd.a aoM() {
        return new mg();
    }

    protected final /* bridge */ /* synthetic */ void c(com.tencent.mm.bd.a aVar) {
        mf mfVar = (mf) aVar;
        mfVar.tst = this.fwJ;
        mfVar.thD = this.fGl;
        mfVar.tsu = this.laQ;
        mfVar.mtb = this.appId;
    }

    public a(String str, String str2, String str3, String str4, b<a> bVar) {
        this.fwJ = bg.mz(str);
        this.fGl = bg.mz(str2);
        this.laQ = bg.mz(str3);
        this.appId = bg.mz(str4);
        this.laR = new WeakReference(bVar);
    }

    public final int getType() {
        return 1799;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneConnectedRouter", "ap: connected router end. errType: %d, errCode: %d, errMsg: %s, resp: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str, pVar.toString()});
        super.a(i, i2, i3, str, pVar, bArr);
        b bVar = (b) this.laR.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/mydevice/connectedrouter";
    }
}
