package com.tencent.mm.ui.snackbar;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

class Snack implements Parcelable {
    public static final Creator<Snack> CREATOR = new Creator<Snack>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Snack(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Snack[i];
        }
    };
    final String mMessage;
    final String wjI;
    final int wjJ;
    final Parcelable wjK;
    final short wjL;
    final int wjM;

    Snack(String str, String str2, int i, Parcelable parcelable, short s, int i2) {
        this.mMessage = str;
        this.wjI = str2;
        this.wjJ = i;
        this.wjK = parcelable;
        this.wjL = s;
        this.wjM = i2;
    }

    Snack(Parcel parcel) {
        this.mMessage = parcel.readString();
        this.wjI = parcel.readString();
        this.wjJ = parcel.readInt();
        this.wjK = parcel.readParcelable(parcel.getClass().getClassLoader());
        this.wjL = (short) parcel.readInt();
        this.wjM = ((Integer) parcel.readParcelable(parcel.getClass().getClassLoader())).intValue();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mMessage);
        parcel.writeString(this.wjI);
        parcel.writeInt(this.wjJ);
        parcel.writeParcelable(this.wjK, 0);
        parcel.writeInt(this.wjL);
        parcel.writeInt(this.wjM);
    }

    public int describeContents() {
        return 0;
    }
}
