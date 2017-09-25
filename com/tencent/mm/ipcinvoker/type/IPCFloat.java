package com.tencent.mm.ipcinvoker.type;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class IPCFloat implements Parcelable {
    public static final Creator<IPCFloat> CREATOR = new Creator<IPCFloat>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            IPCFloat iPCFloat = new IPCFloat();
            iPCFloat.value = parcel.readFloat();
            return iPCFloat;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new IPCFloat[i];
        }
    };
    public float value;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.value);
    }

    public String toString() {
        return Float.toString(this.value);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IPCFloat)) {
            return obj instanceof Float ? obj.equals(Float.valueOf(this.value)) : false;
        } else {
            if (this.value != ((IPCFloat) obj).value) {
                return false;
            }
            return true;
        }
    }
}
