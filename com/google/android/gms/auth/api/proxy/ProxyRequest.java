package com.google.android.gms.auth.api.proxy;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class ProxyRequest implements SafeParcelable {
    public static final Creator<ProxyRequest> CREATOR = new b();
    public static final int alB = 0;
    public static final int alC = 1;
    public static final int alD = 2;
    public static final int alE = 3;
    public static final int alF = 4;
    public static final int alG = 5;
    public static final int alH = 6;
    public static final int alI = 7;
    public static final int alJ = 7;
    public final long alA;
    public final int alK;
    Bundle alL;
    public final byte[] body;
    public final String url;
    final int versionCode;

    ProxyRequest(int i, String str, int i2, long j, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.url = str;
        this.alK = i2;
        this.alA = j;
        this.body = bArr;
        this.alL = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "ProxyRequest[ url: " + this.url + ", method: " + this.alK + " ]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
