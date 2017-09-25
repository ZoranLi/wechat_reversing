package com.tencent.mm.plugin.appbrand.jsapi.share;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class ShareInfo implements Parcelable {
    public static final Creator<ShareInfo> CREATOR = new Creator<ShareInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ShareInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ShareInfo[i];
        }
    };
    public String hpS;
    public String hpT;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hpT);
        parcel.writeString(this.hpS);
    }

    public ShareInfo(String str, String str2) {
        this.hpT = str;
        this.hpS = str2;
    }

    public ShareInfo(Parcel parcel) {
        this.hpT = parcel.readString();
        this.hpS = parcel.readString();
    }
}
