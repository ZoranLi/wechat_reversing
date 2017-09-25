package com.tencent.mm.performance.d;

import java.lang.ref.WeakReference;

public final class d<T> extends WeakReference<T> {
    @b
    public final String igL;

    public d(String str, T t) {
        super(t);
        this.igL = str;
    }
}
