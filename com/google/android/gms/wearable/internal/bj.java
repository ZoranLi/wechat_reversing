package com.google.android.gms.wearable.internal;

import com.google.android.gms.wearable.g;

public final class bj implements g {
    private final String ahk;
    private final String azV;

    public bj(g gVar) {
        this.ahk = gVar.getId();
        this.azV = gVar.mE();
    }

    public final String getId() {
        return this.ahk;
    }

    public final /* synthetic */ Object jO() {
        return this;
    }

    public final String mE() {
        return this.azV;
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetEntity[");
        stringBuilder.append("@");
        stringBuilder.append(Integer.toHexString(hashCode()));
        if (this.ahk == null) {
            stringBuilder.append(",noid");
        } else {
            stringBuilder.append(",");
            stringBuilder.append(this.ahk);
        }
        stringBuilder.append(", key=");
        stringBuilder.append(this.azV);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
