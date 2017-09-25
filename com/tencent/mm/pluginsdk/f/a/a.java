package com.tencent.mm.pluginsdk.f.a;

import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class a {
    private CountDownLatch sBO = null;

    public final void countDown() {
        if (this.sBO != null) {
            this.sBO.countDown();
            this.sBO = null;
        }
    }

    public final void b(long j, Runnable runnable) {
        w.i("MicroMsg.SyncJob", "doAsSyncJob");
        if (this.sBO == null) {
            this.sBO = new CountDownLatch(1);
        }
        af.v(runnable);
        w.i("MicroMsg.SyncJob", "doAsSyncJob postToMainThread");
        if (this.sBO != null) {
            try {
                this.sBO.await(j, TimeUnit.MILLISECONDS);
            } catch (Throwable e) {
                w.w("MicroMsg.SyncJob", e.getMessage());
                w.printErrStackTrace("MicroMsg.SyncJob", e, "", new Object[0]);
            }
        }
    }
}
