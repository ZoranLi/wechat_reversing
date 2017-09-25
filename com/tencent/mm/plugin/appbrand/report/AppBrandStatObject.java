package com.tencent.mm.plugin.appbrand.report;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class AppBrandStatObject implements Parcelable {
    public static final Creator<AppBrandStatObject> CREATOR = new Creator<AppBrandStatObject>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandStatObject(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandStatObject[i];
        }
    };
    public String appId;
    public String fCN;
    public int fWK;
    public int fWL;
    public String fWM;
    public transient String jfX;
    public int jfY;
    public int scene;

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeInt(this.fWL);
        parcel.writeString(this.fWM);
        parcel.writeInt(this.scene);
        parcel.writeString(this.fCN);
        parcel.writeInt(this.jfY);
        parcel.writeInt(this.fWK);
    }

    protected AppBrandStatObject(Parcel parcel) {
        this.appId = parcel.readString();
        this.fWL = parcel.readInt();
        this.fWM = parcel.readString();
        this.scene = parcel.readInt();
        this.fCN = parcel.readString();
        this.jfY = parcel.readInt();
        this.fWK = parcel.readInt();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("appId : ").append(this.appId).append(",");
        stringBuilder.append("preScene : ").append(this.fWL).append(",");
        stringBuilder.append("preSceneNote : ").append(this.fWM).append(",");
        stringBuilder.append("scene : ").append(this.scene).append(",");
        stringBuilder.append("sceneNote : ").append(this.fCN).append(",");
        stringBuilder.append("usedState : ").append(this.jfY).append(",");
        return stringBuilder.toString();
    }
}
