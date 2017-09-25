package com.tencent.mm.plugin.backup.c;

import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class b extends e {
    private static b jDt;
    private d jDu;
    private c jDv;
    private a jDw;
    private a jDx;
    String jDy = "tickit";
    public WakeLock wakeLock = null;

    public static b aaD() {
        if (jDt == null) {
            com.tencent.mm.plugin.backup.a.a bVar = new b();
            jDt = bVar;
            com.tencent.mm.plugin.backup.a.a.a(bVar);
        }
        return jDt;
    }

    public final void ZY() {
        jDt = null;
    }

    public final void i(Object... objArr) {
        final String str = (String) objArr[0];
        af.v(new Runnable(this) {
            final /* synthetic */ b jDz;

            public final void run() {
                c aaG = b.aaD().aaG();
                w.w("MicroMsg.BackupMoveRecoverServer", "~~~~~~~~~~~~  start by url:%s", new Object[]{str});
                ap.vd().a(595, aaG.jEb);
                ap.vd().a(new com.tencent.mm.plugin.backup.f.e(r1), 0);
            }
        });
    }

    public final a aaE() {
        if (this.jDx == null) {
            this.jDx = new a();
        }
        return this.jDx;
    }

    public final d aaF() {
        if (this.jDu == null) {
            this.jDu = new d();
        }
        return this.jDu;
    }

    public final c aaG() {
        if (this.jDv == null) {
            this.jDv = new c();
        }
        return this.jDv;
    }

    public final a aaH() {
        if (this.jDw == null) {
            this.jDw = new a();
        }
        return this.jDw;
    }

    public final void aaf() {
        af.v(new Runnable(this) {
            final /* synthetic */ b jDz;

            {
                this.jDz = r1;
            }

            public final void run() {
                try {
                    if (this.jDz.wakeLock == null) {
                        PowerManager powerManager = (PowerManager) ab.getContext().getSystemService("power");
                        this.jDz.wakeLock = powerManager.newWakeLock(26, "BackupMove Lock");
                    }
                    if (!this.jDz.wakeLock.isHeld()) {
                        this.jDz.wakeLock.acquire();
                    }
                } catch (Throwable th) {
                }
            }
        });
    }

    public final void aag() {
        af.v(new Runnable(this) {
            final /* synthetic */ b jDz;

            {
                this.jDz = r1;
            }

            public final void run() {
                try {
                    if (this.jDz.wakeLock != null && this.jDz.wakeLock.isHeld()) {
                        this.jDz.wakeLock.release();
                    }
                } catch (Throwable th) {
                }
            }
        });
    }
}
