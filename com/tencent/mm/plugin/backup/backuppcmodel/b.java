package com.tencent.mm.plugin.backup.backuppcmodel;

import android.os.Looper;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mm.plugin.backup.a.e;
import com.tencent.mm.plugin.backup.b.a;
import com.tencent.mm.plugin.backup.f.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;

public final class b extends e {
    private static b jGn;
    private a jDx;
    private c jGo;
    private e jGp;
    private d jGq;
    private a jGr;
    public WakeLock wakeLock = null;

    public static b abd() {
        if (jGn == null) {
            com.tencent.mm.plugin.backup.a.a bVar = new b();
            jGn = bVar;
            a(bVar);
        }
        return jGn;
    }

    public final void ZY() {
        jGn = null;
    }

    public final void i(Object... objArr) {
        ((Boolean) objArr[0]).booleanValue();
        new ae(Looper.getMainLooper()).postDelayed(new Runnable(abd().abe()) {
            final /* synthetic */ c jGA;

            {
                this.jGA = r1;
            }

            public final void run() {
                b.abd().aaE().stop();
                b.abd().aag();
                if (b.abr() != null) {
                    b.abr().stop();
                }
                if (b.abs() != null) {
                    b.abs().stop();
                }
            }
        }, 100);
    }

    public final a aaE() {
        if (this.jDx == null) {
            this.jDx = new a();
        }
        return this.jDx;
    }

    public final c abe() {
        if (this.jGo == null) {
            this.jGo = new c();
        }
        return this.jGo;
    }

    public final e abf() {
        if (this.jGp == null) {
            this.jGp = new e();
        }
        return this.jGp;
    }

    public final d abg() {
        if (this.jGq == null) {
            this.jGq = new d();
        }
        return this.jGq;
    }

    public final a abh() {
        if (this.jGr == null) {
            this.jGr = new a();
        }
        return this.jGr;
    }

    public final void aaf() {
        af.v(new Runnable(this) {
            final /* synthetic */ b jGs;

            {
                this.jGs = r1;
            }

            public final void run() {
                try {
                    if (this.jGs.wakeLock == null) {
                        PowerManager powerManager = (PowerManager) ab.getContext().getSystemService("power");
                        this.jGs.wakeLock = powerManager.newWakeLock(26, "BackupPc Lock");
                    }
                    if (!this.jGs.wakeLock.isHeld()) {
                        this.jGs.wakeLock.acquire();
                    }
                } catch (Throwable th) {
                }
            }
        });
    }

    public final void aag() {
        af.v(new Runnable(this) {
            final /* synthetic */ b jGs;

            {
                this.jGs = r1;
            }

            public final void run() {
                try {
                    if (this.jGs.wakeLock != null && this.jGs.wakeLock.isHeld()) {
                        this.jGs.wakeLock.release();
                    }
                } catch (Throwable th) {
                }
            }
        });
    }
}
