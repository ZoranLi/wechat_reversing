package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class LaunchParamsOptional implements Parcelable {
    public static final Creator<LaunchParamsOptional> CREATOR = new Creator<LaunchParamsOptional>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new LaunchParamsOptional(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LaunchParamsOptional[i];
        }
    };
    public String hpS;
    public String hpT;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hpS);
        parcel.writeString(this.hpT);
    }

    public LaunchParamsOptional(Parcel parcel) {
        this.hpS = parcel.readString();
        this.hpT = parcel.readString();
    }
}
