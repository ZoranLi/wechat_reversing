package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ResolveAccountRequest implements SafeParcelable {
    public static final Creator<ResolveAccountRequest> CREATOR = new x();
    final Account akV;
    final int apH;
    final int mVersionCode;

    ResolveAccountRequest(int i, Account account, int i2) {
        this.mVersionCode = i;
        this.akV = account;
        this.apH = i2;
    }

    public ResolveAccountRequest(Account account, int i) {
        this(1, account, i);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        x.a(this, parcel, i);
    }
}
