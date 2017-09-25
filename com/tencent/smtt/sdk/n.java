package com.tencent.smtt.sdk;

import android.os.HandlerThread;

final class n extends HandlerThread {
    private static n wUX;

    private n(String str) {
        super(str);
    }

    public static synchronized n cez() {
        n nVar;
        synchronized (n.class) {
            if (wUX == null) {
                nVar = new n("TbsHandlerThread");
                wUX = nVar;
                nVar.start();
            }
            nVar = wUX;
        }
        return nVar;
    }
}
