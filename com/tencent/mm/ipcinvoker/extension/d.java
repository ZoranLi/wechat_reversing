package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import android.os.Parcelable;

public final class d implements a {
    public final boolean am(Object obj) {
        return obj instanceof Parcelable;
    }

    public final void a(Object obj, Parcel parcel) {
        parcel.writeParcelable((Parcelable) obj, 0);
    }

    public final Object d(Parcel parcel) {
        return parcel.readParcelable(getClass().getClassLoader());
    }
}
