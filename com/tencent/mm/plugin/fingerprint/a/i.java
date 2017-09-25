package com.tencent.mm.plugin.fingerprint.a;

import com.tencent.mm.e.a.mg;
import com.tencent.mm.plugin.fingerprint.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class i extends c<mg> {
    public i() {
        this.usg = mg.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        mg mgVar = (mg) bVar;
        if (!ap.zb()) {
            w.e("MicroMsg.ReleaseFingerPrintAuthEventListener", "ReleaseFingerPrintAuthEventListener account is not ready");
        } else if (mgVar instanceof mg) {
            w.i("MicroMsg.ReleaseFingerPrintAuthEventListener", "handle ReleaseFingerPrintAuthEventListener");
            a.auQ();
            if (a.auR() != null) {
                a.auQ();
                a.auR();
                c.auW();
                w.i("MicroMsg.ReleaseFingerPrintAuthEventListener", "systemRelease FPManger");
            }
            return true;
        }
        return false;
    }
}
