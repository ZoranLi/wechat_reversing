package com.google.android.gms.playlog.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public class PlayLoggerContext implements SafeParcelable {
    public static final b CREATOR = new b();
    public final int aCX;
    public final int aCY;
    public final String aCZ;
    public final String aDa;
    public final boolean aDb;
    public final String aDc;
    public final boolean aDd;
    public final int aDe;
    public final String packageName;
    public final int versionCode;

    public PlayLoggerContext(int i, String str, int i2, int i3, String str2, String str3, boolean z, String str4, boolean z2, int i4) {
        this.versionCode = i;
        this.packageName = str;
        this.aCX = i2;
        this.aCY = i3;
        this.aCZ = str2;
        this.aDa = str3;
        this.aDb = z;
        this.aDc = str4;
        this.aDd = z2;
        this.aDe = i4;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PlayLoggerContext)) {
            return false;
        }
        PlayLoggerContext playLoggerContext = (PlayLoggerContext) obj;
        return this.versionCode == playLoggerContext.versionCode && this.packageName.equals(playLoggerContext.packageName) && this.aCX == playLoggerContext.aCX && this.aCY == playLoggerContext.aCY && v.d(this.aDc, playLoggerContext.aDc) && v.d(this.aCZ, playLoggerContext.aCZ) && v.d(this.aDa, playLoggerContext.aDa) && this.aDb == playLoggerContext.aDb && this.aDd == playLoggerContext.aDd && this.aDe == playLoggerContext.aDe;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.versionCode), this.packageName, Integer.valueOf(this.aCX), Integer.valueOf(this.aCY), this.aDc, this.aCZ, this.aDa, Boolean.valueOf(this.aDb), Boolean.valueOf(this.aDd), Integer.valueOf(this.aDe)});
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("PlayLoggerContext[");
        stringBuilder.append("versionCode=").append(this.versionCode).append(',');
        stringBuilder.append("package=").append(this.packageName).append(',');
        stringBuilder.append("packageVersionCode=").append(this.aCX).append(',');
        stringBuilder.append("logSource=").append(this.aCY).append(',');
        stringBuilder.append("logSourceName=").append(this.aDc).append(',');
        stringBuilder.append("uploadAccount=").append(this.aCZ).append(',');
        stringBuilder.append("loggingId=").append(this.aDa).append(',');
        stringBuilder.append("logAndroidId=").append(this.aDb).append(',');
        stringBuilder.append("isAnonymous=").append(this.aDd).append(',');
        stringBuilder.append("qosTier=").append(this.aDe);
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        b.a(this, parcel);
    }
}
