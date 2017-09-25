package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class PeriodicTask extends Task {
    public static final Creator<PeriodicTask> CREATOR = new Creator<PeriodicTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PeriodicTask(parcel);
        }

        public final /* synthetic */ Object[] newArray(int i) {
            return new PeriodicTask[i];
        }
    };
    protected long atj = -1;
    protected long atk = -1;

    @Deprecated
    public PeriodicTask(Parcel parcel) {
        super(parcel);
        this.atj = parcel.readLong();
        this.atk = parcel.readLong();
    }

    public String toString() {
        return super.toString() + " period=" + this.atj + " flex=" + this.atk;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.atj);
        parcel.writeLong(this.atk);
    }
}
