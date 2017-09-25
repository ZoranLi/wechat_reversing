package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;

public class MallFunction implements Parcelable {
    public static final Creator<MallFunction> CREATOR = new Creator<MallFunction>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MallFunction(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallFunction[i];
        }
    };
    public String fXa;
    public String fZF;
    public String mER;
    public String nvR;
    public String nvS;
    public String oKW;
    public String rIB;
    public ArrayList<String> rIC;
    public MallNews rID;
    public String rIE;
    public int type;

    public int describeContents() {
        return 0;
    }

    public MallFunction(Parcel parcel) {
        this.oKW = parcel.readString();
        this.fXa = parcel.readString();
        this.rIB = parcel.readString();
        this.nvR = parcel.readString();
        this.nvS = parcel.readString();
        this.fZF = parcel.readString();
        this.mER = parcel.readString();
        this.rIC = new ArrayList();
        parcel.readStringList(this.rIC);
        this.rID = (MallNews) parcel.readParcelable(MallNews.class.getClassLoader());
        this.type = parcel.readInt();
        this.rIE = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.oKW);
        parcel.writeString(this.fXa);
        parcel.writeString(this.rIB);
        parcel.writeString(this.nvR);
        parcel.writeString(this.nvS);
        parcel.writeString(this.fZF);
        parcel.writeString(this.mER);
        parcel.writeStringList(this.rIC);
        parcel.writeParcelable(this.rID, i);
        parcel.writeInt(this.type);
        parcel.writeString(this.rIE);
    }
}
