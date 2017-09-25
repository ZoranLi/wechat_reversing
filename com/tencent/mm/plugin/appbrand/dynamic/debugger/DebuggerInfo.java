package com.tencent.mm.plugin.appbrand.dynamic.debugger;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class DebuggerInfo implements Parcelable {
    public static final Creator<DebuggerInfo> CREATOR = new Creator<DebuggerInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            boolean z = true;
            DebuggerInfo debuggerInfo = new DebuggerInfo();
            debuggerInfo.iHI = parcel.readInt() != 0;
            debuggerInfo.iHJ = parcel.readInt() != 0;
            if (parcel.readInt() == 0) {
                z = false;
            }
            debuggerInfo.iHK = z;
            return debuggerInfo;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new DebuggerInfo[i];
        }
    };
    public boolean iHI;
    public boolean iHJ;
    public boolean iHK;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        if (this.iHI) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.iHJ) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.iHK) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
