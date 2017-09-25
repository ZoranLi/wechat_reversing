package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.b;
import com.google.android.gms.common.internal.p.a;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class GetServiceRequest implements SafeParcelable {
    public static final Creator<GetServiceRequest> CREATOR = new j();
    final int apA;
    int apB;
    String apC;
    IBinder apD;
    Scope[] apE;
    Bundle apF;
    Account apG;
    final int version;

    public GetServiceRequest(int i) {
        this.version = 2;
        this.apB = b.amc;
        this.apA = i;
    }

    GetServiceRequest(int i, int i2, int i3, String str, IBinder iBinder, Scope[] scopeArr, Bundle bundle, Account account) {
        this.version = i;
        this.apA = i2;
        this.apB = i3;
        this.apC = str;
        if (i < 2) {
            Account account2 = null;
            if (iBinder != null) {
                account2 = a.b(a.g(iBinder));
            }
            this.apG = account2;
        } else {
            this.apD = iBinder;
            this.apG = account;
        }
        this.apE = scopeArr;
        this.apF = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        j.a(this, parcel, i);
    }
}
