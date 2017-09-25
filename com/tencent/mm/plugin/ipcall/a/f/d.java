package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.i;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class d extends a {
    public final int[] aEt() {
        return new int[]{991};
    }

    public final int De() {
        return 1;
    }

    public final void oo() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            if (cVar.mNO == 0) {
                cVar.mNO = (int) System.currentTimeMillis();
            }
            ap.vd().a(new i(cVar.fVb, cVar.mOo, cVar.mNO, cVar.mNP, cVar.mNQ), 0);
            w.d("MicroMsg.IPCallInviteService", "start invite, toUsername: %s, toPhoneNumber: %s, inviteid: %d", new Object[]{cVar.fVb, cVar.mOo, Integer.valueOf(cVar.mNO)});
        }
    }
}
