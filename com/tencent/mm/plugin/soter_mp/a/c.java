package com.tencent.mm.plugin.soter_mp.a;

import android.app.Activity;
import com.tencent.mm.plugin.soter_mp.b.d;
import com.tencent.mm.plugin.soter_mp.ui.SoterAuthenticationUI;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.h;
import java.lang.ref.WeakReference;

public abstract class c {
    protected com.tencent.mm.plugin.soter_mp.b.c qQU = null;
    protected d qQV = null;
    protected WeakReference<Activity> qQW = null;

    public abstract void cQ();

    public abstract void onPause();

    public abstract void onRequestPermissionsResult(int i, String[] strArr, int[] iArr);

    public abstract void onResume();

    public c(WeakReference<Activity> weakReference, com.tencent.mm.plugin.soter_mp.b.c cVar, d dVar) {
        this.qQU = cVar;
        this.qQV = dVar;
        this.qQW = weakReference;
    }

    protected static void bmd() {
        if (SoterAuthenticationUI.qRb != null) {
            SoterAuthenticationUI.qRb.obtainMessage(5).sendToTarget();
        } else {
            w.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }

    protected final void bme() {
        if (SoterAuthenticationUI.qRb != null) {
            bmd();
            SoterAuthenticationUI.qRb.obtainMessage(0, this.qQV).sendToTarget();
            return;
        }
        w.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    protected final void bmf() {
        if (SoterAuthenticationUI.qRb != null) {
            bmd();
            SoterAuthenticationUI.qRb.obtainMessage(1, this.qQV).sendToTarget();
            return;
        }
        w.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    protected final void bmg() {
        if (SoterAuthenticationUI.qRb != null) {
            bmd();
            SoterAuthenticationUI.qRb.obtainMessage(2, this.qQV).sendToTarget();
            return;
        }
        w.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
    }

    protected static void a(h hVar) {
        if (hVar == null) {
            w.e("MicroMsg.SoterMpBaseController", "hy: dialog is null.");
        } else if (SoterAuthenticationUI.qRb != null) {
            bmd();
            SoterAuthenticationUI.qRb.obtainMessage(6, hVar).sendToTarget();
        } else {
            w.e("MicroMsg.SoterMpBaseController", "hy: handler not bind");
        }
    }
}
