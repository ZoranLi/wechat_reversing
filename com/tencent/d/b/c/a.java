package com.tencent.d.b.c;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.CancellationSignal;
import com.tencent.d.a.c.c;
import com.tencent.d.b.f.f;
import com.tencent.d.b.f.g;
import junit.framework.Assert;

public final class a {
    public CancellationSignal wZS = null;

    public a() {
        Assert.assertTrue(VERSION.SDK_INT >= 16);
        cfR();
    }

    @SuppressLint({"NewApi"})
    public final boolean mh(final boolean z) {
        c.v("Soter.SoterFingerprintCanceller", "soter: publishing cancellation. should publish: %b", Boolean.valueOf(z));
        if (this.wZS.isCanceled()) {
            c.i("Soter.SoterFingerprintCanceller", "soter: cancellation signal already expired.", new Object[0]);
            return false;
        } else if (VERSION.SDK_INT < 23) {
            g.cfZ().y(new Runnable(this) {
                final /* synthetic */ a wZU;

                public final void run() {
                    c.v("Soter.SoterFingerprintCanceller", "soter: enter worker thread. perform cancel", new Object[0]);
                    this.wZU.wZS.cancel();
                    if (z) {
                        a.cfQ();
                    }
                }
            });
            return true;
        } else {
            g.cfZ().y(new Runnable(this) {
                final /* synthetic */ a wZU;

                {
                    this.wZU = r1;
                }

                public final void run() {
                    this.wZU.wZS.cancel();
                }
            });
            g.cfZ().i(new Runnable(this) {
                final /* synthetic */ a wZU;

                {
                    this.wZU = r1;
                }

                public final void run() {
                    c.w("Soter.SoterFingerprintCanceller", "hy: waiting for %s ms not callback to system callback. cancel manually", Long.valueOf(350));
                    a.cfQ();
                }
            }, 350);
            return true;
        }
    }

    public static void cfQ() {
        f cfX = f.cfX();
        synchronized (cfX.xaz) {
            c.i("Soter.SoterTaskManager", "soter: request publish cancellation", new Object[0]);
            if (f.xay.size() != 0) {
                for (int i = 0; i < f.xay.size(); i++) {
                    g.cfZ().y(new com.tencent.d.b.f.f.AnonymousClass3(cfX, f.xay.keyAt(i)));
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final void cfR() {
        this.wZS = new CancellationSignal();
    }
}
