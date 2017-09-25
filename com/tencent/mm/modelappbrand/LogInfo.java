package com.tencent.mm.modelappbrand;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class LogInfo implements Parcelable {
    public static final Creator<LogInfo> CREATOR = new Creator<LogInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            LogInfo logInfo = new LogInfo();
            logInfo.hpU = parcel.readLong();
            logInfo.level = parcel.readInt();
            logInfo.message = parcel.readString();
            return logInfo;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new LogInfo[i];
        }
    };
    public long hpU;
    public int level;
    public String message;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.hpU);
        parcel.writeInt(this.level);
        parcel.writeString(this.message);
    }
}
