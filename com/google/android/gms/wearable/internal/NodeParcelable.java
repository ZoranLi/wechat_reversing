package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.m;

public class NodeParcelable implements SafeParcelable, m {
    public static final Creator<NodeParcelable> CREATOR = new ad();
    final String aDg;
    final int aHg;
    final boolean aHh;
    final String ahk;
    final int mVersionCode;

    NodeParcelable(int i, String str, String str2, int i2, boolean z) {
        this.mVersionCode = i;
        this.ahk = str;
        this.aDg = str2;
        this.aHg = i2;
        this.aHh = z;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        return !(obj instanceof NodeParcelable) ? false : ((NodeParcelable) obj).ahk.equals(this.ahk);
    }

    public final String getId() {
        return this.ahk;
    }

    public int hashCode() {
        return this.ahk.hashCode();
    }

    public String toString() {
        return "Node{" + this.aDg + ", id=" + this.ahk + ", hops=" + this.aHg + ", isNearby=" + this.aHh + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        ad.a(this, parcel);
    }
}
