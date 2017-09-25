package com.google.android.gms.wearable;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.h;
import com.google.android.gms.wearable.internal.bi;

public final class e extends h<d> implements g {
    public final Status aFq;

    public e(DataHolder dataHolder) {
        super(dataHolder);
        this.aFq = new Status(dataHolder.alZ);
    }

    protected final /* synthetic */ Object aj(int i, int i2) {
        return new bi(this.aoy, i, i2);
    }

    protected final String jP() {
        return "path";
    }

    public final Status jv() {
        return this.aFq;
    }
}
