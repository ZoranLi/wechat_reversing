package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public class StorageInfoResponse implements SafeParcelable {
    public static final Creator<StorageInfoResponse> CREATOR = new al();
    public final long aHi;
    public final List<PackageStorageInfo> aHj;
    public final int statusCode;
    public final int versionCode;

    StorageInfoResponse(int i, int i2, long j, List<PackageStorageInfo> list) {
        this.versionCode = i;
        this.statusCode = i2;
        this.aHi = j;
        this.aHj = list;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        al.a(this, parcel);
    }
}
