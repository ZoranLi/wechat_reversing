package com.tencent.mm.plugin.appbrand.ui.banner;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.concurrent.locks.ReentrantReadWriteLock;

final class BannerModel implements Parcelable {
    public static final Creator<BannerModel> CREATOR = new Creator<BannerModel>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BannerModel(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BannerModel[i];
        }
    };
    private static final ReentrantReadWriteLock jlH = new ReentrantReadWriteLock();
    private static volatile BannerModel jlI;
    String appId;
    String appName;
    int iPk;
    String jhe;
    String jlG;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.iPk);
        parcel.writeString(this.appName);
        parcel.writeString(this.jhe);
        parcel.writeString(this.jlG);
    }

    BannerModel() {
    }

    public BannerModel(Parcel parcel) {
        this.appId = parcel.readString();
        this.iPk = parcel.readInt();
        this.appName = parcel.readString();
        this.jhe = parcel.readString();
        this.jlG = parcel.readString();
    }

    static BannerModel Xn() {
        BannerModel Xi;
        synchronized (BannerModel.class) {
            Xi = a.Xi();
            jlI = Xi;
        }
        return Xi;
    }

    static BannerModel Xo() {
        BannerModel bannerModel;
        synchronized (BannerModel.class) {
            bannerModel = jlI;
        }
        return bannerModel;
    }
}
