package com.google.android.gms.auth.api.proxy;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyResponse implements SafeParcelable {
    public static final Creator<ProxyResponse> CREATOR = new c();
    final Bundle alL;
    public final int alM;
    public final PendingIntent alN;
    public final byte[] body;
    public final int statusCode;
    final int versionCode;

    ProxyResponse(int i, int i2, PendingIntent pendingIntent, int i3, Bundle bundle, byte[] bArr) {
        this.versionCode = i;
        this.alM = i2;
        this.statusCode = i3;
        this.alL = bundle;
        this.body = bArr;
        this.alN = pendingIntent;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        c.a(this, parcel, i);
    }
}
