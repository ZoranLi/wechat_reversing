package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.wearable.internal.f;

public final class h extends com.google.android.gms.common.data.h<f> implements g {
    private final Status aFq;

    public h(DataHolder dataHolder) {
        super(dataHolder);
        this.aFq = new Status(dataHolder.alZ);
    }

    protected final /* synthetic */ Object aj(int i, int i2) {
        return new f(this.aoy, i, i2);
    }

    protected final String jP() {
        return "path";
    }

    public final Status jv() {
        return this.aFq;
    }
}
