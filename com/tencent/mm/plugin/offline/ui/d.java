package com.tencent.mm.plugin.offline.ui;

import android.os.Looper;
import com.tencent.mm.e.a.qf;
import com.tencent.mm.plugin.offline.k;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class d extends c<qf> {
    private ae mHandler;

    public d() {
        this.mHandler = new ae(Looper.getMainLooper());
        this.usg = qf.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        qf qfVar = (qf) bVar;
        if (ap.zb() && (qfVar instanceof qf)) {
            w.i("MicroMsg.SyncOfflineTokenListener", "SyncOfflineTokenListener -> updateToken()");
            boolean z = qfVar.fXk.fXl;
            final boolean z2 = qfVar.fXk.scene == 1;
            if (z2) {
                g.oUh.a(135, 25, 1, true);
            }
            if (z) {
                this.mHandler.postDelayed(new Runnable(this) {
                    final /* synthetic */ d odK;

                    public final void run() {
                        k.aQd();
                        k.aQg().gc(z2);
                    }
                }, 10000);
            } else {
                k.aQd();
                k.aQg().gc(z2);
            }
        }
        return false;
    }
}
