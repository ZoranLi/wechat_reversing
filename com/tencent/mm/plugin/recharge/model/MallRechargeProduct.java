package com.tencent.mm.plugin.recharge.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MallRechargeProduct implements Parcelable {
    public static final Creator<MallRechargeProduct> CREATOR = new Creator<MallRechargeProduct>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MallRechargeProduct(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallRechargeProduct[i];
        }
    };
    public String appId;
    public String fGa;
    public boolean isDefault;
    public String kSV;
    public String oKW;
    public String oKX;
    public float oKY = 0.0f;
    public float oKZ = 0.0f;
    public boolean oLa;
    public int oLb;
    public int oLc;
    public int oLd;
    public final boolean oLe;
    public boolean oLf = true;

    public MallRechargeProduct(boolean z) {
        this.oLe = z;
    }

    public final boolean isValid() {
        if (!this.oLa || this.oLb > 0) {
            return true;
        }
        return false;
    }

    public static void a(MallRechargeProduct mallRechargeProduct, MallRechargeProduct mallRechargeProduct2) {
        mallRechargeProduct2.appId = mallRechargeProduct.appId;
        mallRechargeProduct2.oKW = mallRechargeProduct.oKW;
        mallRechargeProduct2.fGa = mallRechargeProduct.fGa;
        mallRechargeProduct2.kSV = mallRechargeProduct.kSV;
        mallRechargeProduct2.oKX = mallRechargeProduct.oKX;
        mallRechargeProduct2.oKY = mallRechargeProduct.oKY;
        mallRechargeProduct2.oKZ = mallRechargeProduct.oKZ;
        mallRechargeProduct2.oLa = mallRechargeProduct.oLa;
        mallRechargeProduct2.oLb = mallRechargeProduct.oLb;
        mallRechargeProduct2.oLc = mallRechargeProduct.oLc;
        mallRechargeProduct2.isDefault = mallRechargeProduct.isDefault;
        mallRechargeProduct2.oLf = mallRechargeProduct.oLf;
        mallRechargeProduct2.oLd = mallRechargeProduct.oLd;
    }

    public int describeContents() {
        return 0;
    }

    public MallRechargeProduct(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.oKW = parcel.readString();
        this.appId = parcel.readString();
        this.fGa = parcel.readString();
        this.kSV = parcel.readString();
        this.oKX = parcel.readString();
        this.oKY = parcel.readFloat();
        this.oKZ = parcel.readFloat();
        this.oLa = parcel.readInt() == 1;
        this.oLb = parcel.readInt();
        this.oLc = parcel.readInt();
        if (parcel.readInt() == 1) {
            z = true;
        } else {
            z = false;
        }
        this.isDefault = z;
        if (parcel.readInt() != 1) {
            z2 = false;
        }
        this.oLe = z2;
        this.oLd = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.oKW);
        parcel.writeString(this.appId);
        parcel.writeString(this.fGa);
        parcel.writeString(this.kSV);
        parcel.writeString(this.oKX);
        parcel.writeFloat(this.oKY);
        parcel.writeFloat(this.oKZ);
        parcel.writeInt(this.oLa ? 1 : 0);
        parcel.writeInt(this.oLb);
        parcel.writeInt(this.oLc);
        if (this.isDefault) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.oLe) {
            i3 = 0;
        }
        parcel.writeInt(i3);
        parcel.writeInt(this.oLd);
    }
}
