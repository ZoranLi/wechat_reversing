package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class AccountChangeEventsRequest implements SafeParcelable {
    public static final Creator<AccountChangeEventsRequest> CREATOR = new f();
    final int akP;
    @Deprecated
    String akR;
    int akT;
    Account akV;

    public AccountChangeEventsRequest() {
        this.akP = 1;
    }

    AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.akP = i;
        this.akT = i2;
        this.akR = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.akV = account;
        } else {
            this.akV = new Account(str, "com.google");
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        f.a(this, parcel, i);
    }
}
