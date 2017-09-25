package android.support.v4.app;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

final class FragmentState implements Parcelable {
    public static final Creator<FragmentState> CREATOR = new Creator<FragmentState>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FragmentState(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FragmentState[i];
        }
    };
    final int mIndex;
    final String mTag;
    Bundle oT;
    final Bundle oW;
    final boolean pc;
    final int pk;
    final int pl;
    final boolean pn;
    final boolean po;
    final String qU;
    Fragment qV;

    public FragmentState(Fragment fragment) {
        this.qU = fragment.getClass().getName();
        this.mIndex = fragment.mIndex;
        this.pc = fragment.pc;
        this.pk = fragment.pk;
        this.pl = fragment.pl;
        this.mTag = fragment.mTag;
        this.po = fragment.po;
        this.pn = fragment.pn;
        this.oW = fragment.oW;
    }

    public FragmentState(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.qU = parcel.readString();
        this.mIndex = parcel.readInt();
        this.pc = parcel.readInt() != 0;
        this.pk = parcel.readInt();
        this.pl = parcel.readInt();
        this.mTag = parcel.readString();
        if (parcel.readInt() != 0) {
            z = true;
        } else {
            z = false;
        }
        this.po = z;
        if (parcel.readInt() == 0) {
            z2 = false;
        }
        this.pn = z2;
        this.oW = parcel.readBundle();
        this.oT = parcel.readBundle();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.qU);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.pc ? 1 : 0);
        parcel.writeInt(this.pk);
        parcel.writeInt(this.pl);
        parcel.writeString(this.mTag);
        if (this.po) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.pn) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeBundle(this.oW);
        parcel.writeBundle(this.oT);
    }
}
