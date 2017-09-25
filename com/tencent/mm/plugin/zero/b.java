package com.tencent.mm.plugin.zero;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.e.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelmulti.r;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.bo;
import com.tencent.mm.u.bo.a;

public final class b implements c, com.tencent.mm.plugin.zero.b.b {
    private bo sAM;
    private r sAN;

    public final r Hy() {
        h.vJ();
        h.vG().uQ();
        if (this.sAN == null) {
            this.sAN = new r();
        }
        return this.sAN;
    }

    public final bo bCi() {
        h.vJ();
        h.vG().uQ();
        if (this.sAM == null) {
            this.sAM = new bo(new a(this) {
                final /* synthetic */ b sAO;

                {
                    this.sAO = r1;
                }

                public final boolean zZ() {
                    return this.sAO.Hy().hMr == null;
                }
            });
        }
        return this.sAM;
    }

    public final void onAccountInitialized(f fVar) {
    }

    public final void onAccountRelease() {
        if (this.sAN != null) {
            r rVar = this.sAN;
            w.i("MicroMsg.SyncService", "clear synclist:%s notify:%s running:%s", Integer.valueOf(rVar.hMo.size()), Integer.valueOf(rVar.hMp.size()), rVar.hMr);
            rVar.hMo.clear();
            rVar.hMp.clear();
        }
        if (this.sAM != null) {
            this.sAM.zU();
        }
    }
}
