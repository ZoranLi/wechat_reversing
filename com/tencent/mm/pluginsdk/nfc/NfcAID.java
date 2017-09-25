package com.tencent.mm.pluginsdk.nfc;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class NfcAID implements Parcelable {
    public static final Creator<NfcAID> CREATOR = new Creator<NfcAID>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new NfcAID(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new NfcAID[i];
        }
    };
    public String mURL = null;
    public String sEG = null;

    public int describeContents() {
        return 0;
    }

    public NfcAID(Parcel parcel) {
        this.sEG = parcel.readString();
        this.mURL = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.sEG);
        parcel.writeString(this.mURL);
    }
}
