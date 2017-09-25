package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ValidateAccountRequest implements SafeParcelable {
    public static final Creator<ValidateAccountRequest> CREATOR = new d();
    final int apJ;
    final Bundle apK;
    final String apL;
    final IBinder apt;
    final Scope[] apu;
    final int mVersionCode;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.mVersionCode = i;
        this.apJ = i2;
        this.apt = iBinder;
        this.apu = scopeArr;
        this.apK = bundle;
        this.apL = str;
    }

    public ValidateAccountRequest(p pVar, Scope[] scopeArr, String str, Bundle bundle) {
        this(1, b.amc, pVar == null ? null : pVar.asBinder(), scopeArr, null, str);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        d.a(this, parcel, i);
    }
}
