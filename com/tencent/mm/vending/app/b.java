package com.tencent.mm.vending.app;

import android.os.Handler;
import android.os.Message;
import android.util.SparseIntArray;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    private static b wBP;
    Map<c, a> wBQ = new ConcurrentHashMap();
    final SparseIntArray wBR = new SparseIntArray();
    final Handler wBS = new Handler(this, com.tencent.mm.vending.i.b.cbO().wDJ.getLooper()) {
        final /* synthetic */ b wBT;

        public final void handleMessage(Message message) {
            a aVar = (a) message.obj;
            switch (message.what) {
                case 1:
                    aVar.onCreate();
                    synchronized (aVar.wBF) {
                        aVar.wBI = true;
                        aVar.wBF.notify();
                    }
                    return;
                case 4:
                    aVar.onDestroy();
                    return;
                default:
                    return;
            }
        }
    };

    static {
        wBP = null;
        wBP = new b();
    }

    public static b cbr() {
        return wBP;
    }
}
