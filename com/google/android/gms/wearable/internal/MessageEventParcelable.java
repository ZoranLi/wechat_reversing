package com.google.android.gms.wearable.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.wearable.l;

public class MessageEventParcelable implements SafeParcelable, l {
    public static final Creator<MessageEventParcelable> CREATOR = new aa();
    final String aAW;
    final byte[] aFF;
    final String aGN;
    final int aHf;
    final int mVersionCode;

    MessageEventParcelable(int i, int i2, String str, byte[] bArr, String str2) {
        this.mVersionCode = i;
        this.aHf = i2;
        this.aGN = str;
        this.aFF = bArr;
        this.aAW = str2;
    }

    public int describeContents() {
        return 0;
    }

    public final byte[] getData() {
        return this.aFF;
    }

    public final String getPath() {
        return this.aGN;
    }

    public String toString() {
        return "MessageEventParcelable[" + this.aHf + "," + this.aGN + ", size=" + (this.aFF == null ? "null" : Integer.valueOf(this.aFF.length)) + "]";
    }

    public void writeToParcel(Parcel parcel, int i) {
        aa.a(this, parcel);
    }
}
