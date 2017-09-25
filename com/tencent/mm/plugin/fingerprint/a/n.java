package com.tencent.mm.plugin.fingerprint.a;

import com.tencent.mm.compatible.d.p;
import com.tencent.mm.plugin.fingerprint.FingerPrintAuth;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;

public final class n {
    public a lOF;

    public interface a {
        void pq(String str);
    }

    public n(a aVar) {
        this.lOF = aVar;
    }

    public final void avz() {
        e.post(new Runnable(this) {
            final /* synthetic */ n lOG;

            {
                this.lOG = r1;
            }

            public final void run() {
                String str = "";
                if (e.avd()) {
                    w.i("MicroMsg.SyncGenRsaKey", "device is support FingerPrintAuth");
                    str = FingerPrintAuth.genRsaKey(e.ca(ab.getContext()), e.getUserId(), p.rB());
                } else {
                    w.e("MicroMsg.SyncGenRsaKey", "device is not support FingerPrintAuth");
                }
                if (this.lOG.lOF != null) {
                    this.lOG.lOF.pq(str);
                }
            }
        }, getClass().getName());
    }
}
