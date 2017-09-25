package com.tencent.mm.plugin.ipcall.a.f;

import com.tencent.mm.plugin.ipcall.a.a.b;
import com.tencent.mm.plugin.ipcall.a.a.c;
import com.tencent.mm.plugin.ipcall.a.d.o;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;

public final class i extends b {
    private o mQR = null;
    private int mQS = 0;

    public final int[] aEt() {
        return new int[]{819};
    }

    public final void onStop() {
        if (this.mQR != null) {
            ap.vd().c(this.mQR);
        }
    }

    public final int De() {
        return 2;
    }

    public final void oo() {
    }

    public final void onDestroy() {
    }

    public final void b(c cVar) {
        boolean z = true;
        String str = "MicroMsg.IPCallSyncService";
        String str2 = "serviceImpl, info==null: %b";
        Object[] objArr = new Object[1];
        if (cVar != null) {
            z = false;
        }
        objArr[0] = Boolean.valueOf(z);
        w.d(str, str2, objArr);
        if (this.mNd != null) {
            this.mQS = this.mNd.mNW;
            this.mQR = new o(this.mNd.mNL, this.mNd.mNM, this.mNd.aEx(), this.mNd.mNN, false);
            ap.vd().a(this.mQR, 0);
        }
    }

    public final int aEu() {
        return this.mQS;
    }

    public final void aEv() {
        w.d("MicroMsg.IPCallSyncService", "onLoopSuccess");
    }

    public final void aEw() {
        w.d("MicroMsg.IPCallSyncService", "onLoopFailed");
    }
}
