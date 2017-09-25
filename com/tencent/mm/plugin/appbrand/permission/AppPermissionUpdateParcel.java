package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class AppPermissionUpdateParcel implements Parcelable {
    public static final Creator<AppPermissionUpdateParcel> CREATOR = new Creator<AppPermissionUpdateParcel>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppPermissionUpdateParcel(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppPermissionUpdateParcel[i];
        }
    };
    public String appId;
    public byte[] jfs;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeByteArray(this.jfs);
    }

    public AppPermissionUpdateParcel(Parcel parcel) {
        this.appId = parcel.readString();
        this.jfs = parcel.createByteArray();
    }
}
