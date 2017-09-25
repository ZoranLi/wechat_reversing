package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import com.google.android.gms.common.internal.w;
import java.util.Arrays;

public class AccountChangeEvent implements SafeParcelable {
    public static final Creator<AccountChangeEvent> CREATOR = new e();
    final int akP;
    final long akQ;
    final String akR;
    final int akS;
    final int akT;
    final String akU;

    AccountChangeEvent(int i, long j, String str, int i2, int i3, String str2) {
        this.akP = i;
        this.akQ = j;
        this.akR = (String) w.Z(str);
        this.akS = i2;
        this.akT = i3;
        this.akU = str2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AccountChangeEvent)) {
            return false;
        }
        AccountChangeEvent accountChangeEvent = (AccountChangeEvent) obj;
        return this.akP == accountChangeEvent.akP && this.akQ == accountChangeEvent.akQ && v.d(this.akR, accountChangeEvent.akR) && this.akS == accountChangeEvent.akS && this.akT == accountChangeEvent.akT && v.d(this.akU, accountChangeEvent.akU);
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.akP), Long.valueOf(this.akQ), this.akR, Integer.valueOf(this.akS), Integer.valueOf(this.akT), this.akU});
    }

    public String toString() {
        String str = "UNKNOWN";
        switch (this.akS) {
            case 1:
                str = "ADDED";
                break;
            case 2:
                str = "REMOVED";
                break;
            case 3:
                str = "RENAMED_FROM";
                break;
            case 4:
                str = "RENAMED_TO";
                break;
        }
        return "AccountChangeEvent {accountName = " + this.akR + ", changeType = " + str + ", changeData = " + this.akU + ", eventIndex = " + this.akT + "}";
    }

    public void writeToParcel(Parcel parcel, int i) {
        e.a(this, parcel);
    }
}
