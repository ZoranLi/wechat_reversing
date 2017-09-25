package com.tencent.mm.plugin.exdevice.f.a;

import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.a.a;
import com.tencent.mm.plugin.exdevice.a.b;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.protocal.c.nj;
import com.tencent.mm.protocal.c.nk;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;

public final class h extends a<nj, nk> {
    private final WeakReference<b<h>> laR;
    String username;

    protected final /* synthetic */ com.tencent.mm.bd.a aoL() {
        return new nj();
    }

    protected final /* synthetic */ com.tencent.mm.bd.a aoM() {
        return new nk();
    }

    protected final /* bridge */ /* synthetic */ void c(com.tencent.mm.bd.a aVar) {
        ((nj) aVar).ttu = this.username;
    }

    public h(String str, b<h> bVar) {
        this.username = str;
        this.laR = new WeakReference(bVar);
    }

    public final int getType() {
        return 1792;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.d("MicroMsg.NetSceneDelFollow", "hy: del follow end. errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        super.a(i, i2, i3, str, pVar, bArr);
        if (i2 == 0 && i3 == 0) {
            ad.apv().ve(this.username);
        }
        b bVar = (b) this.laR.get();
        if (bVar != null) {
            bVar.b(i2, i3, str, this);
        }
    }

    protected final String getUri() {
        return "/cgi-bin/mmoc-bin/hardware/delfollow";
    }
}
