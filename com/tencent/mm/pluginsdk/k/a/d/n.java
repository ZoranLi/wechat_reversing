package com.tencent.mm.pluginsdk.k.a.d;

import android.database.Cursor;
import com.tencent.mm.compatible.d.v;
import com.tencent.mm.kernel.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.storage.w;
import java.util.LinkedList;
import java.util.List;

final class n {
    public static void bDG() {
        if (h.vG().uV()) {
            h.vG();
            if (!a.uP() && getNetworkType() != 0) {
                long Ny = bg.Ny();
                if (bg.a((Long) h.vI().vr().get(w.a.USERINFO_RES_DOWNLOADER_CHECK_RESUME_INTERVAL_LONG, null), 0) < Ny) {
                    h.vI().vr().a(w.a.USERINFO_RES_DOWNLOADER_CHECK_RESUME_INTERVAL_LONG, Long.valueOf(7200 + Ny));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.PostTaskCheckResume", "doCheckResume");
                    a.sGQ.vL().D(new Runnable() {
                        public final void run() {
                            List list = null;
                            o oVar = a.sGQ;
                            int networkType = n.getNetworkType();
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType = %d", Integer.valueOf(networkType));
                            if (networkType == 0) {
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, networkType is unavailable");
                            } else if (oVar.rXW) {
                                if (oVar.rXW) {
                                    long Nz = bg.Nz();
                                    Cursor Kk = oVar.sGN.Kk();
                                    if (Kk != null) {
                                        if (Kk.getCount() <= 0) {
                                            Kk.close();
                                        } else {
                                            list = new LinkedList();
                                            Kk.moveToFirst();
                                            do {
                                                q qVar = new q();
                                                qVar.b(Kk);
                                                list.add(qVar);
                                            } while (Kk.moveToNext());
                                            Kk.close();
                                        }
                                    }
                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ResDownloaderCore", "queryAll: cost = %d", Long.valueOf(bg.aA(Nz)));
                                }
                                if (bg.bV(r0)) {
                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, no record stored, skip this resumeAll-op");
                                    return;
                                }
                                for (q qVar2 : r0) {
                                    if (!bg.mA(qVar2.field_groupId1)) {
                                        int hashCode = qVar2.field_groupId1.hashCode();
                                        for (g gVar : p.bDH()) {
                                            if (hashCode == bg.mz(gVar.Qo()).hashCode()) {
                                                gVar.bwQ().a(qVar2, networkType);
                                            }
                                        }
                                    }
                                }
                            } else {
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.ResDownloaderCore", "resumeAllAndEvictExpired, core can not work");
                            }
                        }
                    });
                }
            }
        }
    }

    public static int getNetworkType() {
        switch (v.rR()) {
            case 0:
                return 0;
            case 1:
                return 1;
            default:
                return 2;
        }
    }
}
