package com.google.android.gms.common.server;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class FavaDiagnosticsEntity implements SafeParcelable {
    public static final a CREATOR = new a();
    public final String arl;
    public final int arm;
    final int mVersionCode;

    public FavaDiagnosticsEntity(int i, String str, int i2) {
        this.mVersionCode = i;
        this.arl = str;
        this.arm = i2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel);
    }
}
