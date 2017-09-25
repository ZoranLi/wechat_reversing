package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCInteger implements Parcelable {
    public static final Creator<IPCInteger> CREATOR = new Creator<IPCInteger>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            IPCInteger iPCInteger = new IPCInteger();
            iPCInteger.value = parcel.readInt();
            return iPCInteger;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCInteger[i];
        }
    };
    public int value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.value);
    }

    public String toString() {
        return Integer.toString(this.value);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IPCInteger)) {
            return obj instanceof Integer ? obj.equals(Integer.valueOf(this.value)) : false;
        } else {
            if (this.value != ((IPCInteger) obj).value) {
                return false;
            }
            return true;
        }
    }
}
