package com.tencent.mm.vending.h;

import android.os.Handler;
import android.os.Looper;

public final class h extends d {
    Looper aLd;
    private String mType;
    public a wDH;

    private h(Looper looper, a aVar, String str) {
        this.aLd = looper;
        this.wDH = aVar;
        this.mType = str;
    }

    private h(Handler handler, String str) {
        this(new b(handler), str);
    }

    public h(a aVar, String str) {
        this(aVar.getLooper(), aVar, str);
    }

    public h(Looper looper, String str) {
        this(new Handler(looper), str);
    }

    public final String getType() {
        return this.mType;
    }

    public final void cancel() {
        this.wDH.cl();
    }

    public final void ab(Runnable runnable) {
        this.wDH.f(runnable);
    }

    public final void h(Runnable runnable, long j) {
        if (j >= 0) {
            this.wDH.g(runnable, j);
        } else {
            this.wDH.f(runnable);
        }
    }
}
