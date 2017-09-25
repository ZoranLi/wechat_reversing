package com.tencent.mm.ipcinvoker.extension.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.a;
import com.tencent.mm.ipcinvoker.extension.c;

class WrapperParcelable implements Parcelable {
    public static final Creator<WrapperParcelable> CREATOR = new Creator<WrapperParcelable>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            WrapperParcelable wrapperParcelable = new WrapperParcelable();
            if (parcel.readInt() == 1) {
                wrapperParcelable.gWm = c.a(parcel.readString(), parcel);
            }
            return wrapperParcelable;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WrapperParcelable[i];
        }
    };
    Object gWm;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.gWm != null) {
            a an = c.an(this.gWm);
            if (an != null) {
                parcel.writeInt(1);
                parcel.writeString(an.getClass().getName());
                an.a(this.gWm, parcel);
                return;
            }
        }
        parcel.writeInt(1);
    }
}
