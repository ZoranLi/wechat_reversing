package com.tencent.mm.plugin.wallet_core.id_verify.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class Profession implements Parcelable {
    public static final Creator<Profession> CREATOR = new Creator<Profession>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Profession(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Profession[i];
        }
    };
    public String rDp;
    public int rDq;

    public Profession(String str, int i) {
        this.rDp = str;
        this.rDq = i;
    }

    protected Profession(Parcel parcel) {
        this.rDp = parcel.readString();
        this.rDq = parcel.readInt();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.rDp);
        parcel.writeInt(this.rDq);
    }
}
