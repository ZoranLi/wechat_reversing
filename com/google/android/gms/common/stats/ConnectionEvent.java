package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public final class ConnectionEvent implements SafeParcelable {
    public static final Creator<ConnectionEvent> CREATOR = new a();
    final long arN;
    int arO;
    final String arP;
    final String arQ;
    final String arR;
    final String arS;
    final String arT;
    final String arU;
    final long arV;
    final long arW;
    private long arX;
    final int mVersionCode;

    ConnectionEvent(int i, long j, int i2, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this.mVersionCode = i;
        this.arN = j;
        this.arO = i2;
        this.arP = str;
        this.arQ = str2;
        this.arR = str3;
        this.arS = str4;
        this.arX = -1;
        this.arT = str5;
        this.arU = str6;
        this.arV = j2;
        this.arW = j3;
    }

    public ConnectionEvent(long j, int i, String str, String str2, String str3, String str4, String str5, String str6, long j2, long j3) {
        this(1, j, i, str, str2, str3, str4, str5, str6, j2, j3);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel);
    }
}
