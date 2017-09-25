package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCVoid implements Parcelable {
    public static final Creator<IPCVoid> CREATOR = new Creator<IPCVoid>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new IPCVoid();
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCVoid[i];
        }
    };
    public static final IPCVoid gWv = new IPCVoid();

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }
}
