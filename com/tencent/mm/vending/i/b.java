package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;

public final class b {
    private static b wDK = new b();
    private Handler mHandler;
    public HandlerThread wDJ = new HandlerThread("Vending-LogicThread");

    private b() {
        this.wDJ.start();
        this.mHandler = new Handler(this.wDJ.getLooper());
    }

    public static b cbO() {
        return wDK;
    }
}
