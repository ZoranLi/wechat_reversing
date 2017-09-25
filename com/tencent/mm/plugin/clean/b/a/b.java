package com.tencent.mm.plugin.clean.b.a;

import android.os.Looper;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;

public final class b implements c {
    public HashMap<Long, ae> kyS;
    private HashSet<Long> kyT;

    public b() {
        this((byte) 0);
    }

    private b(byte b) {
        this.kyT = new HashSet(5);
        this.kyS = new HashMap(5);
        for (int i = 0; i <= 5; i++) {
            e.d(new Runnable(this) {
                final /* synthetic */ b kyU;

                {
                    this.kyU = r1;
                }

                public final void run() {
                    Looper.prepare();
                    this.kyU.kyS.put(Long.valueOf(Thread.currentThread().getId()), new ae(Looper.myLooper()));
                    Looper.loop();
                }
            }, "ThreadController_handler", 1).start();
        }
    }

    public final synchronized boolean b(a aVar) {
        boolean z;
        aVar.kyR = this;
        w.d("MicroMsg.ThreadController", "running threads %s", new Object[]{this.kyT.toString()});
        for (Entry entry : this.kyS.entrySet()) {
            if (!this.kyT.contains(entry.getKey())) {
                ((ae) entry.getValue()).post(aVar);
                this.kyT.add(entry.getKey());
                z = true;
                break;
            }
        }
        z = false;
        return z;
    }

    private synchronized void e(Long l) {
        if (this.kyT.remove(l)) {
            w.d("MicroMsg.ThreadController", "thread is idle, id=%d", new Object[]{l});
        }
    }

    public final void f(Long l) {
        e(l);
    }
}
