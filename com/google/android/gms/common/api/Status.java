package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.internal.v;
import java.util.Arrays;

public final class Status implements g, SafeParcelable {
    public static final Creator<Status> CREATOR = new t();
    public static final Status amM = new Status(0);
    public static final Status amN = new Status(14);
    public static final Status amO = new Status(8);
    public static final Status amP = new Status(15);
    public static final Status amQ = new Status(16);
    public final int alZ;
    public final String amR;
    final PendingIntent ama;
    final int mVersionCode;

    public Status(int i) {
        this(i, null);
    }

    Status(int i, int i2, String str, PendingIntent pendingIntent) {
        this.mVersionCode = i;
        this.alZ = i2;
        this.amR = str;
        this.ama = pendingIntent;
    }

    public Status(int i, String str) {
        this(1, i, str, null);
    }

    public Status(String str) {
        this(1, 8, str, null);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.mVersionCode == status.mVersionCode && this.alZ == status.alZ && v.d(this.amR, status.amR) && v.d(this.ama, status.ama);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.mVersionCode), Integer.valueOf(this.alZ), this.amR, this.ama});
    }

    public final boolean isSuccess() {
        return this.alZ <= 0;
    }

    public final Status jv() {
        return this;
    }

    public final String toString() {
        return v.Y(this).h("statusCode", this.amR != null ? this.amR : b.bQ(this.alZ)).h("resolution", this.ama).toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        t.a(this, parcel, i);
    }
}
