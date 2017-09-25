package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.a.d;
import com.google.android.gms.common.api.c.b;

public final class c<T extends IInterface> extends k<T> {
    private final d<T> apO;

    public c(Context context, Looper looper, int i, b bVar, com.google.android.gms.common.api.c.c cVar, h hVar, d dVar) {
        super(context, looper, i, hVar, bVar, cVar);
        this.apO = dVar;
    }

    protected final T f(IBinder iBinder) {
        return this.apO.jo();
    }

    protected final String jm() {
        return this.apO.jm();
    }

    protected final String jn() {
        return this.apO.jn();
    }
}
