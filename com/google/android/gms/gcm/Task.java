package com.google.android.gms.gcm;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public abstract class Task implements Parcelable {
    private final String atl;
    private final boolean atm;
    private final boolean atn;
    private final int ato;
    private final boolean atp;
    private final Bundle mExtras;
    private final String mTag;

    @Deprecated
    Task(Parcel parcel) {
        boolean z = true;
        this.atl = parcel.readString();
        this.mTag = parcel.readString();
        this.atm = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.atn = z;
        this.ato = 2;
        this.atp = false;
        this.mExtras = null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.atl);
        parcel.writeString(this.mTag);
        parcel.writeInt(this.atm ? 1 : 0);
        if (!this.atn) {
            i2 = 0;
        }
        parcel.writeInt(i2);
    }
}
