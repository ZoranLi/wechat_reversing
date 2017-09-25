package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.LinkedList;
import java.util.List;

public class FavorPayInfo implements Parcelable {
    public static final Creator<FavorPayInfo> CREATOR = new Creator<FavorPayInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new FavorPayInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FavorPayInfo[i];
        }
    };
    public String rFm;
    public int rFn;
    public String rFo;
    public String rFp;
    public String rFq;
    public List<String> rFr = new LinkedList();

    public FavorPayInfo(Parcel parcel) {
        this.rFm = parcel.readString();
        this.rFn = parcel.readInt();
        this.rFo = parcel.readString();
        this.rFp = parcel.readString();
        this.rFq = parcel.readString();
        this.rFr = parcel.createStringArrayList();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.rFm);
        parcel.writeInt(this.rFn);
        parcel.writeString(this.rFo);
        parcel.writeString(this.rFp);
        parcel.writeString(this.rFq);
        parcel.writeStringList(this.rFr);
    }

    public int describeContents() {
        return 0;
    }
}
