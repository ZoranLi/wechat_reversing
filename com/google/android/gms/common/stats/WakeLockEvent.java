package com.google.android.gms.common.stats;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.List;

public final class WakeLockEvent implements SafeParcelable {
    public static final Creator<WakeLockEvent> CREATOR = new g();
    final long arN;
    int arO;
    final long arV;
    private long arX;
    final String arY;
    final int arZ;
    final List<String> asa;
    final String asb;
    int asc;
    final String asd;
    final String ase;
    final float asf;
    final int mVersionCode;

    WakeLockEvent(int i, long j, int i2, String str, int i3, List<String> list, String str2, long j2, int i4, String str3, String str4, float f) {
        this.mVersionCode = i;
        this.arN = j;
        this.arO = i2;
        this.arY = str;
        this.asd = str3;
        this.arZ = i3;
        this.arX = -1;
        this.asa = list;
        this.asb = str2;
        this.arV = j2;
        this.asc = i4;
        this.ase = str4;
        this.asf = f;
    }

    public WakeLockEvent(long j, int i, String str, int i2, List<String> list, String str2, long j2, int i3, String str3, String str4, float f) {
        this(1, j, i, str, i2, list, str2, j2, i3, str3, str4, f);
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        g.a(this, parcel);
    }
}
