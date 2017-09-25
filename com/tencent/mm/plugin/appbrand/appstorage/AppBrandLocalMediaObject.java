package com.tencent.mm.plugin.appbrand.appstorage;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class AppBrandLocalMediaObject implements Parcelable {
    public static final Creator<AppBrandLocalMediaObject> CREATOR = new Creator<AppBrandLocalMediaObject>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandLocalMediaObject(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandLocalMediaObject[i];
        }
    };
    public String fJz;
    public String hos;
    public String iAS;
    public boolean iAT;
    public long iAU;
    public long ilG;
    public String mimeType;

    public String toString() {
        return "AppBrandLocalMediaObject{localId='" + this.fJz + '\'' + ", fileFullPath='" + this.hos + '\'' + ", mimeType='" + this.mimeType + '\'' + ", fileExt='" + this.iAS + '\'' + '}';
    }

    protected AppBrandLocalMediaObject() {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.fJz);
        parcel.writeString(this.hos);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.iAS);
        parcel.writeByte(this.iAT ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.ilG);
        parcel.writeLong(this.iAU);
    }

    protected AppBrandLocalMediaObject(Parcel parcel) {
        this.fJz = parcel.readString();
        this.hos = parcel.readString();
        this.mimeType = parcel.readString();
        this.iAS = parcel.readString();
        this.iAT = parcel.readByte() != (byte) 0;
        this.ilG = parcel.readLong();
        this.iAU = parcel.readLong();
    }
}
