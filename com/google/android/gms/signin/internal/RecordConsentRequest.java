package com.google.android.gms.signin.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class RecordConsentRequest implements SafeParcelable {
    public static final Creator<RecordConsentRequest> CREATOR = new g();
    final Scope[] aDk;
    final Account akV;
    final String alT;
    final int mVersionCode;

    RecordConsentRequest(int i, Account account, Scope[] scopeArr, String str) {
        this.mVersionCode = i;
        this.akV = account;
        this.aDk = scopeArr;
        this.alT = str;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel, i);
    }
}
