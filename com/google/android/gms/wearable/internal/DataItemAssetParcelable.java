package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.wearable.g;

public class DataItemAssetParcelable implements SafeParcelable, g {
    public static final Creator<DataItemAssetParcelable> CREATOR = new b();
    final String ahk;
    final String azV;
    final int mVersionCode;

    DataItemAssetParcelable(int i, String str, String str2) {
        this.mVersionCode = i;
        this.ahk = str;
        this.azV = str2;
    }

    public DataItemAssetParcelable(g gVar) {
        this.mVersionCode = 1;
        this.ahk = (String) w.Z(gVar.getId());
        this.azV = (String) w.Z(gVar.mE());
    }

    public int describeContents() {
        return 0;
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

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("DataItemAssetParcelable[");
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

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
