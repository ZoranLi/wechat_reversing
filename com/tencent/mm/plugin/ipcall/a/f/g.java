package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiGetOpenDeviceId;
import com.tencent.mm.plugin.ipcall.a.a.a;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.l;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class g extends a {
    public final int[] aEt() {
        return new int[]{GameJsApiGetOpenDeviceId.CTRL_BYTE};
    }

    public final int De() {
        return 7;
    }

    public final void oo() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        if (cVar != null) {
            ap.vd().a(new l(cVar.mNL, cVar.mNN, cVar.mOr), 0);
            w.i("MicroMsg.IPCallReportService", "start report, roomid: %d, callseq: %d, isAccept: %b", new Object[]{Integer.valueOf(cVar.mNL), Long.valueOf(cVar.mNN), Boolean.valueOf(cVar.mOr)});
        }
    }
}
