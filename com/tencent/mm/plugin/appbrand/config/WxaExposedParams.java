package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WxaExposedParams implements Parcelable {
    public static final Creator<WxaExposedParams> CREATOR = new Creator<WxaExposedParams>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WxaExposedParams(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WxaExposedParams[i];
        }
    };
    public String appId;
    public String fFa;
    public int fFr;
    public String iGd;
    public String iGe;
    public String iGf;
    public String iconUrl;
    public int izV;
    public int izW;
    public String username;

    public static class a {
        public String appId = "";
        public String fFa = "";
        public int fFr = 0;
        public String iGd = "";
        public String iGe = "";
        public String iGf = "";
        public String iconUrl = "";
        public int izV = -1;
        public int izW = -1;
        public String username = "";

        public final WxaExposedParams RL() {
            return new WxaExposedParams(this);
        }
    }

    public WxaExposedParams(a aVar) {
        this.appId = aVar.appId;
        this.username = aVar.username;
        this.fFa = aVar.fFa;
        this.iconUrl = aVar.iconUrl;
        this.izV = aVar.izV;
        this.izW = aVar.izW;
        this.iGd = aVar.iGd;
        this.fFr = aVar.fFr;
        this.iGe = aVar.iGe;
        this.iGf = aVar.iGf;
    }

    protected WxaExposedParams(Parcel parcel) {
        this.appId = parcel.readString();
        this.username = parcel.readString();
        this.fFa = parcel.readString();
        this.iconUrl = parcel.readString();
        this.izV = parcel.readInt();
        this.izW = parcel.readInt();
        this.iGd = parcel.readString();
        this.fFr = parcel.readInt();
        this.iGe = parcel.readString();
        this.iGf = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.username);
        parcel.writeString(this.fFa);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.izV);
        parcel.writeInt(this.izW);
        parcel.writeString(this.iGd);
        parcel.writeInt(this.fFr);
        parcel.writeString(this.iGe);
        parcel.writeString(this.iGf);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "WxaExposedParams{appId='" + this.appId + '\'' + ", username='" + this.username + '\'' + ", nickname='" + this.fFa + '\'' + ", iconUrl='" + this.iconUrl + '\'' + ", pkgDebugType=" + this.izV + ", pkgVersion=" + this.izW + ", pkgMD5='" + this.iGd + '\'' + ", from=" + this.fFr + ", pageId='" + this.iGe + '\'' + ", errorUrl='" + this.iGf + '\'' + '}';
    }
}
