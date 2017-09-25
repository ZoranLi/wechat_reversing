package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.n;

public class XParcelableWrapper implements Parcelable {
    public static final Creator<XParcelableWrapper> CREATOR = new Creator<XParcelableWrapper>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            XParcelableWrapper xParcelableWrapper = new XParcelableWrapper();
            if (parcel.readInt() == 1) {
                String readString = parcel.readString();
                if (xParcelableWrapper.gWq == null) {
                    xParcelableWrapper.gWq = (f) n.c(readString, f.class);
                }
                xParcelableWrapper.gWq.readFromParcel(parcel);
            }
            return xParcelableWrapper;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new XParcelableWrapper[i];
        }
    };
    public f gWq;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.gWq != null) {
            parcel.writeInt(1);
            parcel.writeString(this.gWq.getClass().getName());
            this.gWq.e(parcel);
            return;
        }
        parcel.writeInt(1);
    }
}
