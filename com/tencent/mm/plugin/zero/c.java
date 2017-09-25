package com.tencent.mm.plugin.zero;

import com.tencent.mm.bn.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.zero.a.f;
import com.tencent.mm.protocal.c.lu;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class c {
    public static volatile b<f> sBe;
    private final f sBf;

    public c() {
        if (sBe != null) {
            this.sBf = (f) sBe.get();
        } else {
            this.sBf = null;
        }
    }

    public final void aX(Object obj) {
        if (this.sBf != null) {
            this.sBf.aX(obj);
        }
    }

    public final boolean a(lu luVar, boolean z) {
        if (h.vG().uV()) {
            long Nz = bg.Nz();
            byte[] a = n.a(luVar.tsb);
            w.i("MicroMsg.SyncDoCmdDelegate", "doCmd %d cmdid:%d buf:%d thr:[%d]", Long.valueOf(Nz), Integer.valueOf(luVar.tsa), Integer.valueOf(bg.bn(a)), Long.valueOf(Thread.currentThread().getId()));
            if (bg.bm(a)) {
                w.e("MicroMsg.SyncDoCmdDelegate", "docmd: no protobuf found.");
                return false;
            }
            try {
                if (this.sBf != null) {
                    this.sBf.a(luVar, a, z);
                }
                w.i("MicroMsg.SyncDoCmdDelegate", "doCmd FIN %d cmdid:%d Time:%d", Long.valueOf(Nz), Integer.valueOf(luVar.tsa), Long.valueOf(bg.aA(Nz)));
                return true;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SyncDoCmdDelegate", e, "", new Object[0]);
                return false;
            }
        }
        w.e("MicroMsg.SyncDoCmdDelegate", "account storage disabled, discard all commands");
        return false;
    }

    public final void aY(Object obj) {
        if (this.sBf != null) {
            this.sBf.aY(obj);
        }
    }

    public final void aZ(Object obj) {
        if (this.sBf != null) {
            this.sBf.aZ(obj);
        }
    }
}
