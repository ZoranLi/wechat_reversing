package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.ConnectionConfiguration;

@Deprecated
public class GetConfigResponse implements SafeParcelable {
    public static final Creator<GetConfigResponse> CREATOR = new o();
    public final ConnectionConfiguration aGZ;
    public final int statusCode;
    public final int versionCode;

    GetConfigResponse(int i, int i2, ConnectionConfiguration connectionConfiguration) {
        this.versionCode = i;
        this.statusCode = i2;
        this.aGZ = connectionConfiguration;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        o.a(this, parcel, i);
    }
}
