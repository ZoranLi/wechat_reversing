package com.tencent.mm.plugin.appbrand.permission;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.bd.b;
import com.tencent.mm.protocal.c.kp;

public final class AppRuntimeApiPermissionBundle implements Parcelable {
    public static final Creator<AppRuntimeApiPermissionBundle> CREATOR = new Creator<AppRuntimeApiPermissionBundle>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppRuntimeApiPermissionBundle(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppRuntimeApiPermissionBundle[i];
        }
    };
    final byte[] jft;
    final byte[] jfu;
    final byte[] jfv;

    public AppRuntimeApiPermissionBundle(kp kpVar) {
        this.jft = kpVar.tqU.toByteArray();
        this.jfu = ((b) kpVar.tqV.get(0)).toByteArray();
        this.jfv = ((b) kpVar.tqV.get(1)).toByteArray();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeByteArray(this.jft);
        parcel.writeByteArray(this.jfu);
        parcel.writeByteArray(this.jfv);
    }

    public AppRuntimeApiPermissionBundle(Parcel parcel) {
        this.jft = parcel.createByteArray();
        this.jfu = parcel.createByteArray();
        this.jfv = parcel.createByteArray();
    }
}
