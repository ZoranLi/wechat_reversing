package com.tencent.mm.plugin.fingerprint.a;

import com.tencent.mm.e.a.qc;
import com.tencent.mm.e.a.qc.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class m extends c<qc> {
    public m() {
        this.usg = qc.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qc qcVar = (qc) bVar;
        if (!ap.zb()) {
            w.e("MicroMsg.SupportFingerPrintEventListener", "SupportFingerPrintEventListener account is not ready");
        } else if (qcVar instanceof qc) {
            w.i("MicroMsg.SupportFingerPrintEventListener", "handle SupportFingerPrintEvent");
            boolean auV = c.auV();
            w.i("MicroMsg.SupportFingerPrintEventListener", "isSupportFP is " + auV);
            a aVar = new a();
            aVar.fXh = auV;
            qcVar.fXg = aVar;
            if (qcVar.nFq != null) {
                qcVar.nFq.run();
            }
            return true;
        }
        return false;
    }
}
