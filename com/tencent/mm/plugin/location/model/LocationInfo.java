package com.tencent.mm.plugin.location.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.location.ui.d;
import com.tencent.mm.sdk.platformtools.bg;

public class LocationInfo implements Parcelable {
    public static final Creator<LocationInfo> CREATOR = new Creator<LocationInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            LocationInfo locationInfo = new LocationInfo();
            locationInfo.naN = parcel.readString();
            locationInfo.naO = parcel.readDouble();
            locationInfo.naP = parcel.readDouble();
            locationInfo.zoom = parcel.readInt();
            locationInfo.naQ = parcel.readString();
            locationInfo.naR = parcel.readString();
            locationInfo.fRX = parcel.readString();
            locationInfo.naS = parcel.readString();
            locationInfo.naT = parcel.readInt();
            return locationInfo;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LocationInfo[i];
        }
    };
    public String fRX;
    public String naN;
    public double naO;
    public double naP;
    public String naQ;
    public String naR;
    String naS;
    public int naT;
    public int zoom;

    public LocationInfo() {
        this.naN = "";
        this.naO = -85.0d;
        this.naP = -1000.0d;
        this.naQ = "";
        this.naR = "zh-cn";
        this.naS = "";
        this.naT = 0;
    }

    public LocationInfo(byte b) {
        this.naN = "";
        this.naO = -85.0d;
        this.naP = -1000.0d;
        this.naQ = "";
        this.naR = "zh-cn";
        this.naS = "";
        this.naT = 0;
        this.naN = toString() + " " + System.nanoTime();
        this.zoom = d.fn(false);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.naN);
        parcel.writeDouble(this.naO);
        parcel.writeDouble(this.naP);
        parcel.writeInt(this.zoom);
        parcel.writeString(this.naQ);
        parcel.writeString(this.naR);
        parcel.writeString(this.fRX);
        parcel.writeString(this.naS);
        parcel.writeInt(this.naT);
    }

    public final boolean aFU() {
        if (this.naO == -85.0d || this.naP == -1000.0d) {
            return false;
        }
        return true;
    }

    public final boolean aFV() {
        if (bg.mA(this.naQ) && bg.mA(this.fRX)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.naO + " " + this.naP + " " + this.naQ + " " + this.fRX + "  " + this.naN;
    }

    public int describeContents() {
        return 0;
    }
}
