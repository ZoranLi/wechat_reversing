package com.tencent.mm.plugin.normsg.utils;

import com.tencent.mm.sdk.platformtools.w;

public final class b {
    public static boolean nZG;

    static {
        nZG = false;
        long nanoTime = System.nanoTime();
        try {
            nZG = NativeLogic.aPn();
            w.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", new Object[]{Boolean.valueOf(nZG), Long.valueOf(System.nanoTime() - nanoTime)});
        } catch (Throwable th) {
            w.i("MicroMsg.NormalMsgSource.DADH", "CDA, result: %b, time: %d ns", new Object[]{Boolean.valueOf(nZG), Long.valueOf(System.nanoTime() - nanoTime)});
        }
    }
}
