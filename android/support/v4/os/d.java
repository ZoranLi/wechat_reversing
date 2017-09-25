package android.support.v4.os;

import android.os.Parcel;
import android.os.Parcelable.ClassLoaderCreator;

final class d<T> implements ClassLoaderCreator<T> {
    private final c<T> vp;

    public d(c<T> cVar) {
        this.vp = cVar;
    }

    public final T createFromParcel(Parcel parcel) {
        return this.vp.createFromParcel(parcel, null);
    }

    public final T createFromParcel(Parcel parcel, ClassLoader classLoader) {
        return this.vp.createFromParcel(parcel, classLoader);
    }

    public final T[] newArray(int i) {
        return this.vp.newArray(i);
    }
}
