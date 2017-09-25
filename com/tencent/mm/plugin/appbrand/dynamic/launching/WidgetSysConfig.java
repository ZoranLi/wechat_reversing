package com.tencent.mm.plugin.appbrand.dynamic.launching;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class WidgetSysConfig implements Parcelable {
    public static final Creator<WidgetSysConfig> CREATOR = new Creator<WidgetSysConfig>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            WidgetSysConfig widgetSysConfig = new WidgetSysConfig();
            widgetSysConfig.iEw = parcel.readInt();
            widgetSysConfig.iEx = parcel.readInt();
            widgetSysConfig.iEy = parcel.readInt();
            return widgetSysConfig;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WidgetSysConfig[i];
        }
    };
    public int iEw;
    public int iEx;
    public int iEy;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.iEw);
        parcel.writeInt(this.iEx);
        parcel.writeInt(this.iEy);
    }
}
