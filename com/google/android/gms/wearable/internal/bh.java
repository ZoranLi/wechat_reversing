package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.d;
import com.google.android.gms.wearable.f;

public final class bh implements d {
    private f aHW;
    private int aoA;

    public bh(d dVar) {
        this.aoA = dVar.getType();
        this.aHW = (f) dVar.mC().jO();
    }

    public final int getType() {
        return this.aoA;
    }

    public final /* synthetic */ Object jO() {
        return this;
    }

    public final f mC() {
        return this.aHW;
    }

    public final String toString() {
        String str = this.aoA == 1 ? "changed" : this.aoA == 2 ? "deleted" : "unknown";
        return "DataEventEntity{ type=" + str + ", dataitem=" + this.aHW + " }";
    }
}
