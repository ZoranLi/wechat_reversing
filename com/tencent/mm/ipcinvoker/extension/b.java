package com.tencent.mm.ipcinvoker.extension;

import android.os.Parcel;
import com.tencent.mm.ipcinvoker.d.a;
import com.tencent.mm.ipcinvoker.n;

public final class b implements a {
    public final boolean am(Object obj) {
        return obj instanceof a;
    }

    public final void a(Object obj, Parcel parcel) {
        a aVar = (a) obj;
        parcel.writeString(aVar.getClass().getName());
        parcel.writeBundle(aVar.toBundle());
    }

    public final Object d(Parcel parcel) {
        String readString = parcel.readString();
        parcel.readBundle();
        return (a) n.c(readString, a.class);
    }
}
