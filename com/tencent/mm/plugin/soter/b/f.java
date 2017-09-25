package com.tencent.mm.plugin.soter.b;

import com.tencent.d.b.e.b;
import com.tencent.d.b.e.e;
import com.tencent.d.b.e.e.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.y.k;

public final class f extends k implements e, j {
    private com.tencent.mm.y.e gUD;
    private p htt;
    private b<e.b> lOJ = null;

    public final /* synthetic */ void aS(Object obj) {
        a aVar = (a) obj;
        this.htt = new b();
        c.a aVar2 = (c.a) this.htt.BG();
        aVar2.qPQ.ugF = aVar.xae;
        aVar2.qPQ.ugG = aVar.xad;
    }

    protected final int ub() {
        return 3;
    }

    protected final int a(p pVar) {
        return k.b.hsT;
    }

    public final int getType() {
        return 627;
    }

    public final int a(com.tencent.mm.network.e eVar, com.tencent.mm.y.e eVar2) {
        this.gUD = eVar2;
        return a(eVar, this.htt, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        w.i("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo errType: %d, errCode: %d, errMsg: %s", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), str});
        if (this.gUD != null) {
            this.gUD.a(i2, i3, str, this);
        }
        if (i2 == 0 && i3 == 0) {
            w.i("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa successfully");
            if (this.lOJ != null) {
                this.lOJ.bV(new e.b(true));
                return;
            }
            return;
        }
        w.e("MicroMsg.NetSceneUploadSoterASKRsa", "netscene upload soter ask rsa failed");
        if (this.lOJ != null) {
            this.lOJ.bV(new e.b(false));
        }
    }

    public final void execute() {
        w.v("MicroMsg.NetSceneUploadSoterASKRsa", "alvinluo NetSceneUploadSoterASKRsa doScene");
        h.vd().a(this, 0);
    }

    public final void a(b<e.b> bVar) {
        this.lOJ = bVar;
    }
}
