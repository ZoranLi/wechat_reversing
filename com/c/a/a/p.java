package com.c.a.a;

import android.os.SystemClock;

class p {
    final long aMa;
    final long aMb;
    final int what;

    private p(int i, long j, long j2) {
        this.what = i;
        this.aMa = j;
        this.aMb = j2;
    }

    p(int i) {
        this(i, System.currentTimeMillis(), SystemClock.elapsedRealtime());
    }
}
