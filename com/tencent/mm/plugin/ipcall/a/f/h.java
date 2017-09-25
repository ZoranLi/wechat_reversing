package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.n;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class h extends a {
    public int mQP = 1;
    public boolean mQQ = false;

    public final int[] aEt() {
        return new int[]{723};
    }

    public final int De() {
        return 4;
    }

    public final void oo() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            w.d("MicroMsg.IPCallShutDownService", "call shutdown scene, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(cVar.mNL), Integer.valueOf(cVar.mNO)});
            ap.vd().a(new n(cVar.mNL, cVar.mNM, cVar.mNN, this.mQP), 0);
        }
    }
}
