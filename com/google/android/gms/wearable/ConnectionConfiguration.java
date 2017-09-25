package com.google.android.gms.wearable;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public class ConnectionConfiguration implements SafeParcelable {
    public static final Creator<ConnectionConfiguration> CREATOR = new u();
    final String aFI;
    final int aFJ;
    final boolean aFK;
    String aFL;
    boolean aFM;
    String aFN;
    boolean ahM;
    final int aoA;
    final String mName;
    final int mVersionCode;

    ConnectionConfiguration(int i, String str, String str2, int i2, int i3, boolean z, boolean z2, String str3, boolean z3, String str4) {
        this.mVersionCode = i;
        this.mName = str;
        this.aFI = str2;
        this.aoA = i2;
        this.aFJ = i3;
        this.aFK = z;
        this.ahM = z2;
        this.aFL = str3;
        this.aFM = z3;
        this.aFN = str4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionConfiguration)) {
            return false;
        }
        ConnectionConfiguration connectionConfiguration = (ConnectionConfiguration) obj;
        return v.d(Integer.valueOf(this.mVersionCode), Integer.valueOf(connectionConfiguration.mVersionCode)) && v.d(this.mName, connectionConfiguration.mName) && v.d(this.aFI, connectionConfiguration.aFI) && v.d(Integer.valueOf(this.aoA), Integer.valueOf(connectionConfiguration.aoA)) && v.d(Integer.valueOf(this.aFJ), Integer.valueOf(connectionConfiguration.aFJ)) && v.d(Boolean.valueOf(this.aFK), Boolean.valueOf(connectionConfiguration.aFK)) && v.d(Boolean.valueOf(this.aFM), Boolean.valueOf(connectionConfiguration.aFM));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mVersionCode), this.mName, this.aFI, Integer.valueOf(this.aoA), Integer.valueOf(this.aFJ), Boolean.valueOf(this.aFK), Boolean.valueOf(this.aFM)});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("ConnectionConfiguration[ ");
        stringBuilder.append("mName=" + this.mName);
        stringBuilder.append(", mAddress=" + this.aFI);
        stringBuilder.append(", mType=" + this.aoA);
        stringBuilder.append(", mRole=" + this.aFJ);
        stringBuilder.append(", mEnabled=" + this.aFK);
        stringBuilder.append(", mIsConnected=" + this.ahM);
        stringBuilder.append(", mPeerNodeId=" + this.aFL);
        stringBuilder.append(", mBtlePriority=" + this.aFM);
        stringBuilder.append(", mNodeId=" + this.aFN);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        u.a(this, parcel);
    }
}
