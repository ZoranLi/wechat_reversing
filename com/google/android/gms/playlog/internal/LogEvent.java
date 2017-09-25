package com.google.android.gms.playlog.internal;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class LogEvent implements SafeParcelable {
    public static final a CREATOR = new a();
    public final long aCT;
    public final long aCU;
    public final byte[] aCV;
    public final Bundle aCW;
    public final String tag;
    public final int versionCode;

    LogEvent(int i, long j, long j2, String str, byte[] bArr, Bundle bundle) {
        this.versionCode = i;
        this.aCT = j;
        this.aCU = j2;
        this.tag = str;
        this.aCV = bArr;
        this.aCW = bundle;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("tag=").append(this.tag).append(",");
        stringBuilder.append("eventTime=").append(this.aCT).append(",");
        stringBuilder.append("eventUptime=").append(this.aCU).append(",");
        if (!(this.aCW == null || this.aCW.isEmpty())) {
            stringBuilder.append("keyValues=");
            for (String str : this.aCW.keySet()) {
                stringBuilder.append("(").append(str).append(",");
                stringBuilder.append(this.aCW.getString(str)).append(")");
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        a.a(this, parcel);
    }
}
