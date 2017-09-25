package com.tencent.mm.u;

import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.report.c;
import com.tencent.mm.sdk.a.b;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public final class a {
    public byte[] hkG;
    public long hkH = -1;

    public final int wH() {
        return this.hkG == null ? -1 : this.hkG.length;
    }

    public a() {
        if (wI()) {
            af.f(new Runnable(this) {
                final /* synthetic */ a hkI;

                {
                    this.hkI = r1;
                }

                public final void run() {
                    try {
                        if (a.wI()) {
                            c.oTb.a(226, 1, 1, false);
                        }
                    } catch (Throwable e) {
                        w.e("MicroMsg.AccInfoCacheInWorker", "init Exception:%s", bg.g(e));
                    }
                }
            }, 5000);
        }
    }

    public static boolean wI() {
        if (com.tencent.mm.kernel.a.uP() || !h.vG().uV()) {
            return false;
        }
        int i = bg.getInt(((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getValue("AndroidUseWorkerAuthCache"), 0);
        h.vJ();
        h.vG();
        int aw = com.tencent.mm.a.h.aw(com.tencent.mm.kernel.a.uH(), 100);
        boolean bIu = b.bIu();
        r7 = new Object[5];
        h.vJ();
        h.vG();
        r7[2] = Integer.valueOf(com.tencent.mm.kernel.a.uH());
        r7[3] = Integer.valueOf(aw);
        r7[4] = Boolean.valueOf(h.vG().uV());
        w.i("MicroMsg.AccInfoCacheInWorker", "checkUse debug:%s dyVal:%s uin:%d  uinHash:%d init:%b", r7);
        if (bIu) {
            return true;
        }
        if (i > aw) {
            return true;
        }
        return false;
    }

    public static void wJ() {
        if (wI()) {
            try {
                h.vJ();
                a aVar = h.vG().gXj;
                h.vJ();
                com.tencent.mm.network.c Cc = h.vH().gXC.hsZ.Cc();
                long Nz = bg.Nz();
                if (Cc == null) {
                    w.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker  accinfo == null");
                    c.oTb.a(226, 2, 1, false);
                    return;
                }
                w.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker islogin:%b cache:%s", Boolean.valueOf(Cc.BY()), Integer.valueOf(aVar.wH()));
                if (Cc.BY()) {
                    aVar.hkG = Cc.Cb();
                    c.oTb.a(226, aVar.wH() > 0 ? 4 : 5, 1, false);
                    w.i("MicroMsg.AccInfoCacheInWorker", "backupToWorker time:%s cache:%s useCacheCount:%s ", Long.valueOf(bg.aA(Nz)), Integer.valueOf(aVar.wH()), Long.valueOf(aVar.hkH));
                    if (aVar.wH() > 0) {
                        c.oTb.a(226, 31 - (aVar.hkH > 5 ? 5 : aVar.hkH), 1, false);
                        c.oTb.i(11098, Integer.valueOf(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN), Long.valueOf(aVar.hkH));
                        aVar.hkH = -1;
                        return;
                    }
                    return;
                }
                c.oTb.a(226, 3, 1, false);
                w.e("MicroMsg.AccInfoCacheInWorker", "backupToWorker ERR: Is Not Login");
            } catch (Throwable th) {
                w.e("MicroMsg.AccInfoCacheInWorker", "tryBackupToWorker Exception:%s", bg.g(th));
            }
        }
    }
}
