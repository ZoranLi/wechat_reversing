package com.tencent.mm.plugin.voip.model;

import com.tencent.mm.plugin.voip.a;
import com.tencent.mm.plugin.voip.ui.g;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.b;
import com.tencent.mm.y.d.c;
import java.util.HashMap;

public final class d implements am {
    private m rfh = null;
    private i rfi = new i();
    public g rfj;
    private a rfk = new a();

    private static d bpc() {
        d dVar = (d) ap.yR().gs("plugin.voip");
        if (dVar != null) {
            return dVar;
        }
        Object dVar2 = new d();
        ap.yR().a("plugin.voip", dVar2);
        return dVar2;
    }

    public static m bpd() {
        if (ap.zb()) {
            if (bpc().rfh == null) {
                bpc().rfh = new m();
            }
            return bpc().rfh;
        }
        throw new b();
    }

    public static g bpe() {
        if (ap.zb()) {
            if (bpc().rfj == null) {
                bpc().rfj = new g();
            }
            return bpc().rfj;
        }
        throw new b();
    }

    public final void onAccountRelease() {
        if (this.rfj != null) {
            af.v(new Runnable(this) {
                final /* synthetic */ d rfl;

                {
                    this.rfl = r1;
                }

                public final void run() {
                    this.rfl.rfj.dismiss();
                    this.rfl.rfj = null;
                }
            });
        }
        c.aA(Integer.valueOf(50));
        bpd();
        m.bqp();
        com.tencent.mm.sdk.b.a.urY.c(this.rfk);
    }

    public final HashMap<Integer, com.tencent.mm.bj.g.c> uh() {
        return null;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        c.a(Integer.valueOf(50), this.rfi);
        bpd();
        m.bqo();
        com.tencent.mm.sdk.b.a.urY.b(this.rfk);
        ap.getNotification().cancel(40);
    }

    public final void aN(boolean z) {
    }
}
