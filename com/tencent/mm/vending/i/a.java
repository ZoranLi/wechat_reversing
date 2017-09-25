package com.tencent.mm.vending.i;

import android.os.Handler;
import android.os.HandlerThread;

public final class a {
    private static a wDI = new a();
    public HandlerThread ixE = new HandlerThread("Vending-HeavyWorkThread", 10);
    private Handler mHandler;

    private a() {
        this.ixE.start();
        this.mHandler = new Handler(this.ixE.getLooper());
    }

    public static a cbN() {
        return wDI;
    }
}
