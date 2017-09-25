package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.aks;
import com.tencent.mm.sdk.platformtools.w;

public class SightCaptureResult implements Parcelable {
    public static final Creator<SightCaptureResult> CREATOR = new Creator<SightCaptureResult>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SightCaptureResult(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SightCaptureResult[i];
        }
    };
    public int nAA = 0;
    public aks nAB = new aks();
    public String nAC = "";
    public boolean nAt = false;
    public boolean nAu = false;
    public boolean nAv = true;
    public String nAw = "";
    public String nAx = "";
    public String nAy = "";
    public String nAz = "";

    public SightCaptureResult(boolean z, String str, String str2, String str3, String str4, int i, aks com_tencent_mm_protocal_c_aks) {
        this.nAv = z;
        this.nAw = str;
        this.nAx = str2;
        this.nAy = str3;
        this.nAA = i;
        this.nAB = com_tencent_mm_protocal_c_aks;
        this.nAz = str4;
        this.nAt = true;
        this.nAu = false;
    }

    public SightCaptureResult(boolean z, String str) {
        this.nAv = z;
        this.nAC = str;
        this.nAt = false;
        this.nAu = true;
    }

    protected SightCaptureResult(Parcel parcel) {
        boolean z;
        this.nAt = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.nAu = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.nAv = z;
        this.nAw = parcel.readString();
        this.nAx = parcel.readString();
        this.nAy = parcel.readString();
        this.nAz = parcel.readString();
        this.nAA = parcel.readInt();
        this.nAC = parcel.readString();
        try {
            byte[] bArr = new byte[parcel.readInt()];
            parcel.readByteArray(bArr);
            this.nAB = new aks();
            this.nAB.aD(bArr);
        } catch (Exception e) {
            w.e("MicroMsg.SightCaptureResult", "read ext info error: %s", e.getMessage());
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeByte((byte) (this.nAt ? 1 : 0));
        if (this.nAu) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.nAv) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeString(this.nAw);
        parcel.writeString(this.nAx);
        parcel.writeString(this.nAy);
        parcel.writeString(this.nAz);
        parcel.writeInt(this.nAA);
        parcel.writeString(this.nAC);
        try {
            byte[] toByteArray = this.nAB.toByteArray();
            parcel.writeInt(toByteArray.length);
            parcel.writeByteArray(toByteArray);
        } catch (Exception e) {
            w.e("MicroMsg.SightCaptureResult", "write ext info error");
        }
    }
}
