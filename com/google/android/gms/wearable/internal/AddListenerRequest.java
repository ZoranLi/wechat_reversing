package com.google.android.gms.wearable.internal;

import android.content.IntentFilter;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.internal.w.a;

public class AddListenerRequest implements SafeParcelable {
    public static final Creator<AddListenerRequest> CREATOR = new ab();
    public final w aGt;
    public final IntentFilter[] aGu;
    public final String aGv;
    public final String aGw;
    final int mVersionCode;

    AddListenerRequest(int i, IBinder iBinder, IntentFilter[] intentFilterArr, String str, String str2) {
        this.mVersionCode = i;
        if (iBinder != null) {
            this.aGt = a.s(iBinder);
        } else {
            this.aGt = null;
        }
        this.aGu = intentFilterArr;
        this.aGv = str;
        this.aGw = str2;
    }

    public AddListenerRequest(ap apVar) {
        this.mVersionCode = 1;
        this.aGt = apVar;
        this.aGu = apVar.aHP;
        this.aGv = apVar.aHQ;
        this.aGw = apVar.aHR;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ab.a(this, parcel, i);
    }
}
