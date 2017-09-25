package com.tencent.mm.sdk;

import com.tencent.mm.sdk.platformtools.ay;

public class b<T> extends ay<T> {
    private final Object mLock = new Object();

    public b() {
        super(20);
    }

    public final T bF() {
        T bF;
        synchronized (this.mLock) {
            bF = super.bF();
        }
        return bF;
    }

    public final boolean i(T t) {
        boolean i;
        synchronized (this.mLock) {
            i = super.i(t);
        }
        return i;
    }
}
