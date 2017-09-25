package com.tencent.mm.plugin.wear.model;

import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.mm.plugin.wear.model.f.d;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;

public final class j {
    HandlerThread handlerThread;
    ae kir;

    private class a extends ae {
        final /* synthetic */ j rUj;

        public a(j jVar, Looper looper) {
            this.rUj = jVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            d dVar = (d) message.obj;
            if (dVar != null) {
                try {
                    dVar.run();
                } catch (Exception e) {
                    w.printErrStackTrace("MicroMsg.Wear.WearWorker", e.getCause(), "run task %s occur exception", new Object[]{dVar.getName()});
                }
            }
        }
    }

    public j() {
        if (com.tencent.mm.compatible.util.d.eq(18)) {
            this.handlerThread = e.Qu("WearWorker_worker_thread");
            this.handlerThread.start();
            this.kir = new a(this, this.handlerThread.getLooper());
            w.i("MicroMsg.Wear.WearWorker", "start worker %d", new Object[]{Integer.valueOf(this.handlerThread.getThreadId())});
        }
    }

    public final void a(d dVar) {
        if (this.kir != null) {
            this.kir.sendMessage(this.kir.obtainMessage(0, dVar));
        }
    }
}
