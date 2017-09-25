package com.tencent.mm.kiss.a;

import android.os.Handler;
import android.os.HandlerThread;

public final class a {
    private static a gZI = new a();
    public HandlerThread gZH = new HandlerThread("InflateThread", 5);
    private Handler mHandler;

    private a() {
        this.gZH.start();
        this.mHandler = new Handler(this.gZH.getLooper());
    }

    public static a vR() {
        return gZI;
    }
}
