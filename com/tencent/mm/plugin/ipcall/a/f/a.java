package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class a extends com.tencent.mm.plugin.ipcall.a.a.a {
    public final int[] aEt() {
        return new int[]{843};
    }

    public final int De() {
        return 3;
    }

    public final void oo() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            w.d("MicroMsg.IPCallCancelService", "call cancel scene, roomId: %d, inviteId: %d", new Object[]{Integer.valueOf(cVar.mNL), Integer.valueOf(cVar.mNO)});
            ap.vd().a(new com.tencent.mm.plugin.ipcall.a.d.a(cVar.mNL, cVar.mNM, cVar.fVb, cVar.mOo, cVar.mNO, cVar.mNN), 0);
        }
    }
}
