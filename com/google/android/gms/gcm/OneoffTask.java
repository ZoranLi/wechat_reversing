package com.google.android.gms.gcm;

import android.os.Parcel;
import android.os.Parcelable.Creator;

public class OneoffTask extends Task {
    public static final Creator<OneoffTask> CREATOR = new Creator<OneoffTask>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new OneoffTask(parcel);
        }

        public final /* synthetic */ Object[] newArray(int i) {
            return new OneoffTask[i];
        }
    };
    private final long ath;
    private final long ati;

    @Deprecated
    public OneoffTask(Parcel parcel) {
        super(parcel);
        this.ath = parcel.readLong();
        this.ati = parcel.readLong();
    }

    public String toString() {
        return super.toString() + " windowStart=" + this.ath + " windowEnd=" + this.ati;
    }

    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeLong(this.ath);
        parcel.writeLong(this.ati);
    }
}
