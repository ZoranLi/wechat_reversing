package com.c.a.a;

import android.os.Handler;
import android.util.SparseArray;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

final class z {
    private static z aPC;
    private static final SparseArray<z> aPD = new SparseArray();
    private final ExecutorService aPE;
    private final Handler handler;

    private z(Handler handler) {
        if (handler != null) {
            this.aPE = null;
        } else {
            this.aPE = Executors.newSingleThreadExecutor();
        }
        this.handler = handler;
    }

    static z b(Handler handler) {
        if (handler != null) {
            int hashCode = handler.getLooper().hashCode();
            z zVar = (z) aPD.get(hashCode);
            if (zVar != null) {
                return zVar;
            }
            zVar = new z(handler);
            aPD.put(hashCode, zVar);
            return zVar;
        }
        if (aPC == null) {
            aPC = new z(null);
        }
        return aPC;
    }

    final void execute(Runnable runnable) {
        if (this.handler != null) {
            this.handler.post(runnable);
        } else {
            this.aPE.execute(runnable);
        }
    }
}
