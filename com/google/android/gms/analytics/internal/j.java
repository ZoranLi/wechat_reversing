package com.google.android.gms.analytics.internal;

import com.google.android.gms.c.v;
import com.google.android.gms.common.internal.w;

final class j {
    private final v ahZ;
    long aia;

    public j(v vVar) {
        w.Z(vVar);
        this.ahZ = vVar;
    }

    public j(v vVar, long j) {
        w.Z(vVar);
        this.ahZ = vVar;
        this.aia = j;
    }

    public final boolean f(long j) {
        return this.aia == 0 || this.ahZ.elapsedRealtime() - this.aia > j;
    }

    public final void start() {
        this.aia = this.ahZ.elapsedRealtime();
    }
}
