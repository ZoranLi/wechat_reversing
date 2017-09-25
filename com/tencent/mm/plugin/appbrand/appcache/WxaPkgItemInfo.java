package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class WxaPkgItemInfo implements Parcelable {
    public static final Creator<WxaPkgItemInfo> CREATOR = new Creator<WxaPkgItemInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WxaPkgItemInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WxaPkgItemInfo[i];
        }
    };
    public final String fyF;
    public final String gam;
    public final int izm;
    public final int izn;

    WxaPkgItemInfo(String str, int i, int i2) {
        this.fyF = str;
        this.gam = null;
        this.izm = i;
        this.izn = i2;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fyF);
        parcel.writeString(this.gam);
        parcel.writeInt(this.izm);
        parcel.writeInt(this.izn);
    }

    public WxaPkgItemInfo(Parcel parcel) {
        this.fyF = parcel.readString();
        this.gam = parcel.readString();
        this.izm = parcel.readInt();
        this.izn = parcel.readInt();
    }
}
