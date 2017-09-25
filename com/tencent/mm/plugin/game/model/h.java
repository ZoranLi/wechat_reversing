package com.tencent.mm.plugin.game.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public class h implements e {
    private static h mpn;
    private boolean hpL = false;

    public static h aAH() {
        if (mpn == null) {
            synchronized (h.class) {
                if (mpn == null) {
                    mpn = new h();
                }
            }
        }
        return mpn;
    }

    public final synchronized void update() {
        if (!((bg.az(Long.valueOf(bg.c((Long) com.tencent.mm.kernel.h.vI().vr().get(a.uzC, Long.valueOf(0)))).longValue()) > 86400 ? 1 : null) == null || this.hpL)) {
            w.i("MicroMsg.GameConfigUpdater", "Game config start update");
            release();
            this.hpL = true;
            ap.vd().a(1311, this);
            ap.vd().a(new aq(), 0);
        }
    }

    private void release() {
        this.hpL = false;
        ap.vd().b(1311, this);
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 1311) {
            w.i("MicroMsg.GameConfigUpdater", "getGameCenterGlobalSetting sceneEnd, %s, %s", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)});
            com.tencent.mm.kernel.h.vI().vr().a(a.uzC, Long.valueOf(bg.Ny()));
            release();
        }
    }
}
