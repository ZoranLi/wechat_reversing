package com.tencent.mm.plugin.game.model;

import com.tencent.mm.protocal.c.awx;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.w.a;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class p implements e {
    private static boolean aJi = false;
    public static int mpC = 20;
    public static LinkedList<j> mpD = new LinkedList();
    private static af mpE;
    public int offset = 0;

    public static void update() {
        ap.yY();
        if (!(System.currentTimeMillis() - ((Long) c.vr().get(a.uzB, Long.valueOf(0))).longValue() > 86400000)) {
            w.i("MicroMsg.GameListUpdater", "No need to update");
        } else if (aJi) {
            w.e("MicroMsg.GameListUpdater", "Already running");
        } else {
            mpE = new af("GameListUpdate");
            mpD.clear();
            Object pVar = new p();
            ap.vd().a(1215, pVar);
            ap.vd().a(new aw(pVar.offset, mpC), 0);
            aJi = true;
        }
    }

    public final void a(int i, int i2, String str, final k kVar) {
        if (i == 0 && i2 == 0) {
            mpE.D(new Runnable(this) {
                final /* synthetic */ p mpF;

                public final void run() {
                    String str;
                    this.mpF.offset += p.mpC;
                    awx com_tencent_mm_protocal_c_awx = (awx) ((aw) kVar).ldw.hsk.hsr;
                    if (com_tencent_mm_protocal_c_awx == null) {
                        w.e("MicroMsg.NetSceneSearchGameList", "resp == null");
                        str = null;
                    } else {
                        str = com_tencent_mm_protocal_c_awx.tAQ;
                    }
                    i jVar = new j(str);
                    jVar.aAI();
                    p.mpD.add(jVar);
                    w.i("MicroMsg.GameListUpdater", "remainingCount: %d", new Object[]{Integer.valueOf(jVar.mpo.optInt("remainingCount"))});
                    if (jVar.mpo.optInt("remainingCount") > 0) {
                        ap.vd().a(new aw(this.mpF.offset, p.mpC), 0);
                        return;
                    }
                    this.mpF.aAM();
                    ap.yY();
                    c.vr().a(a.uzB, Long.valueOf(System.currentTimeMillis()));
                    Object obj = p.mpD;
                    if (!bg.bV(obj)) {
                        ap.vL().D(new com.tencent.mm.plugin.game.model.j.AnonymousClass1(obj));
                    }
                }
            });
        } else {
            aAM();
        }
    }

    public final void aAM() {
        aJi = false;
        mpE.nJF.quit();
        ap.vd().b(1215, this);
    }
}
