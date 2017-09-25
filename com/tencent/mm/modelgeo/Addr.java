package com.tencent.mm.modelgeo;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bg;

public class Addr implements Parcelable {
    public static final Creator<Addr> CREATOR = new Creator<Addr>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            Addr addr = new Addr();
            addr.hCE = parcel.readString();
            addr.country = parcel.readString();
            addr.hCF = parcel.readString();
            addr.hCG = parcel.readString();
            addr.hCH = parcel.readString();
            addr.hCI = parcel.readString();
            addr.hCJ = parcel.readString();
            addr.hCK = parcel.readString();
            addr.hCL = parcel.readString();
            addr.hCM = parcel.readString();
            addr.hCN = parcel.readString();
            addr.hCP = parcel.readFloat();
            addr.hCQ = parcel.readFloat();
            return addr;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Addr[i];
        }
    };
    public String country;
    public String hCE;
    public String hCF;
    public String hCG;
    public String hCH;
    public String hCI;
    public String hCJ;
    public String hCK;
    public String hCL;
    public String hCM;
    public String hCN;
    public String hCO;
    public float hCP;
    public float hCQ;
    public Object tag = "";

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("address='" + this.hCE + '\'');
        stringBuilder.append(", country='" + this.country + '\'');
        stringBuilder.append(", administrative_area_level_1='" + this.hCF + '\'');
        stringBuilder.append(", locality='" + this.hCG + '\'');
        stringBuilder.append(", locality_shi='" + this.hCH + '\'');
        stringBuilder.append(", sublocality='" + this.hCI + '\'');
        stringBuilder.append(", neighborhood='" + this.hCJ + '\'');
        stringBuilder.append(", route='" + this.hCK + '\'');
        stringBuilder.append(", streetNum='" + this.hCL + '\'');
        stringBuilder.append(", roughAddr='" + this.hCM + '\'');
        stringBuilder.append(", poi_name='" + this.hCN + '\'');
        stringBuilder.append(", lat=" + this.hCP);
        stringBuilder.append(", lng=" + this.hCQ);
        stringBuilder.append(", tag=" + this.tag);
        return stringBuilder.toString();
    }

    public final String Gh() {
        return bg.ap(this.hCH, "") + bg.ap(this.hCI, "") + bg.ap(this.hCJ, "") + bg.ap(this.hCK, "") + bg.ap(this.hCL, "");
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(bg.ap(this.hCE, ""));
        parcel.writeString(bg.ap(this.country, ""));
        parcel.writeString(bg.ap(this.hCF, ""));
        parcel.writeString(bg.ap(this.hCG, ""));
        parcel.writeString(bg.ap(this.hCH, ""));
        parcel.writeString(bg.ap(this.hCI, ""));
        parcel.writeString(bg.ap(this.hCJ, ""));
        parcel.writeString(bg.ap(this.hCK, ""));
        parcel.writeString(bg.ap(this.hCL, ""));
        parcel.writeString(bg.ap(this.hCM, ""));
        parcel.writeString(bg.ap(this.hCN, ""));
        parcel.writeFloat(this.hCP);
        parcel.writeFloat(this.hCQ);
    }
}
