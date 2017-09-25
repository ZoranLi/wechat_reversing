package com.tencent.mm.pluginsdk.wallet;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class PayInfo implements Parcelable {
    public static final Creator<PayInfo> CREATOR = new Creator<PayInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PayInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new PayInfo[i];
        }
    };
    public String appId;
    public String fGa;
    public String fJH;
    public int fLS;
    public String fLU;
    public String fLV;
    public String fPf;
    public String fRe = "";
    public int fRr;
    public int fRv = 0;
    public int fRw = -1;
    public String iBi;
    public String kdW;
    public boolean mqD = false;
    public String mry;
    public String partnerId;
    public String rPJ;
    public int sYa = 0;
    public boolean sYb = true;
    public String sYc;
    public String sYd;
    public Bundle sYe;
    public int sYf = 0;
    public int sYg = 0;
    public int sYh;
    public long sYi = 0;
    public int sYj = -1;
    public String sYk;
    public String sYl;
    public int sYm = 1;

    public PayInfo(Parcel parcel) {
        boolean z = true;
        this.fRv = parcel.readInt();
        this.sYa = parcel.readInt();
        this.fJH = parcel.readString();
        this.mry = parcel.readString();
        this.appId = parcel.readString();
        this.rPJ = parcel.readString();
        this.partnerId = parcel.readString();
        this.sYc = parcel.readString();
        this.fGa = parcel.readString();
        this.fPf = parcel.readString();
        this.fRr = parcel.readInt();
        this.fRw = parcel.readInt();
        this.mqD = parcel.readInt() == 1;
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.sYb = z;
        this.sYe = parcel.readBundle();
        this.sYf = parcel.readInt();
        this.fLU = parcel.readString();
        this.fLV = parcel.readString();
        this.fLS = parcel.readInt();
        this.sYi = parcel.readLong();
        this.fRe = parcel.readString();
        this.sYk = parcel.readString();
        this.sYl = parcel.readString();
        this.sYm = parcel.readInt();
        this.kdW = parcel.readString();
        this.iBi = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeInt(this.fRv);
        parcel.writeInt(this.sYa);
        parcel.writeString(this.fJH);
        parcel.writeString(this.mry);
        parcel.writeString(this.appId);
        parcel.writeString(this.rPJ);
        parcel.writeString(this.partnerId);
        parcel.writeString(this.sYc);
        parcel.writeString(this.fGa);
        parcel.writeString(this.fPf);
        parcel.writeInt(this.fRr);
        parcel.writeInt(this.fRw);
        parcel.writeInt(this.mqD ? 1 : 0);
        if (!this.sYb) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeBundle(this.sYe);
        parcel.writeInt(this.sYf);
        parcel.writeString(this.fLU);
        parcel.writeString(this.fLV);
        parcel.writeInt(this.fLS);
        parcel.writeLong(this.sYi);
        parcel.writeString(this.fRe);
        parcel.writeString(this.sYk);
        parcel.writeString(this.sYl);
        parcel.writeInt(this.sYm);
        parcel.writeString(this.kdW);
        parcel.writeString(this.iBi);
    }

    public String toString() {
        return String.format("sense : %d, reqKey : %s, uuid : %s, appId : %s, appSource : %s, partnerId : %s, paySign : %s, productId : %s, soterAuth: %s", new Object[]{Integer.valueOf(this.fRv), this.fJH, this.mry, this.appId, this.rPJ, this.partnerId, this.sYc, this.fGa, this.fRe});
    }
}
