package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.json.JSONObject;

public final class AppBrandLaunchReferrer implements Parcelable {
    public static final Creator<AppBrandLaunchReferrer> CREATOR = new Creator<AppBrandLaunchReferrer>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandLaunchReferrer(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandLaunchReferrer[i];
        }
    };
    public String appId;
    public int iEL;
    public String iEM;
    public String url;

    final void g(Parcel parcel) {
        this.iEL = parcel.readInt();
        this.appId = parcel.readString();
        this.iEM = parcel.readString();
        this.url = parcel.readString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.iEL);
        parcel.writeString(this.appId);
        parcel.writeString(this.iEM);
        parcel.writeString(this.url);
    }

    public final void a(AppBrandLaunchReferrer appBrandLaunchReferrer) {
        if (appBrandLaunchReferrer != null) {
            Parcel obtain = Parcel.obtain();
            obtain.setDataPosition(0);
            appBrandLaunchReferrer.writeToParcel(obtain, 0);
            obtain.setDataPosition(0);
            g(obtain);
            obtain.recycle();
        }
    }

    public final JSONObject RC() {
        Object jSONObject;
        try {
            jSONObject = new JSONObject(this.iEM);
        } catch (Exception e) {
            jSONObject = this.iEM;
        }
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("appId", this.appId);
            jSONObject2.put("extraData", jSONObject);
        } catch (Exception e2) {
        }
        return jSONObject2.length() == 0 ? null : jSONObject2;
    }

    public final int describeContents() {
        return 0;
    }

    public AppBrandLaunchReferrer(Parcel parcel) {
        g(parcel);
    }
}
