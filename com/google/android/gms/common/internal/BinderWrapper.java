package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR = new Creator<BinderWrapper>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BinderWrapper(parcel);
        }

        public final /* synthetic */ Object[] newArray(int i) {
            return new BinderWrapper[i];
        }
    };
    private IBinder apv = null;

    public BinderWrapper(IBinder iBinder) {
        this.apv = iBinder;
    }

    public BinderWrapper(Parcel parcel) {
        this.apv = parcel.readStrongBinder();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.apv);
    }
}
