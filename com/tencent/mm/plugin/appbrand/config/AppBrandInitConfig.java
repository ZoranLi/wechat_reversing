package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONException;
import org.json.JSONObject;

public final class AppBrandInitConfig implements Parcelable {
    public static final Creator<AppBrandInitConfig> CREATOR = new Creator<AppBrandInitConfig>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandInitConfig(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandInitConfig[i];
        }
    };
    public String appId;
    public String fGs;
    public String hpS;
    public String hpT;
    public boolean iEH;
    public String iEI;
    public boolean iEJ;
    public final AppBrandLaunchReferrer iEK = new AppBrandLaunchReferrer();
    public String iconUrl;
    public int izM;
    public long startTime;

    public AppBrandInitConfig(Parcel parcel) {
        boolean z = true;
        this.appId = parcel.readString();
        this.fGs = parcel.readString();
        this.iconUrl = parcel.readString();
        this.izM = parcel.readInt();
        this.iEH = parcel.readByte() != (byte) 0;
        this.iEI = parcel.readString();
        this.hpS = parcel.readString();
        this.hpT = parcel.readString();
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.iEJ = z;
        this.startTime = parcel.readLong();
        this.iEK.g(parcel);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte b = (byte) 1;
        parcel.writeString(this.appId);
        parcel.writeString(this.fGs);
        parcel.writeString(this.iconUrl);
        parcel.writeInt(this.izM);
        parcel.writeByte(this.iEH ? (byte) 1 : (byte) 0);
        parcel.writeString(this.iEI);
        parcel.writeString(this.hpS);
        parcel.writeString(this.hpT);
        if (!this.iEJ) {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeLong(this.startTime);
        this.iEK.writeToParcel(parcel, i);
    }

    public final int describeContents() {
        return 0;
    }

    public final JSONObject RB() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("shareKey", this.hpT);
            jSONObject.put("shareName", this.hpS);
            if (jSONObject.length() == 0) {
                return null;
            }
            return jSONObject;
        } catch (JSONException e) {
            return null;
        }
    }
}
