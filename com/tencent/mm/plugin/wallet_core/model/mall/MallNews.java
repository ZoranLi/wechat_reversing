package com.tencent.mm.plugin.wallet_core.model.mall;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MallNews implements Parcelable {
    public static final Creator<MallNews> CREATOR = new Creator<MallNews>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new MallNews(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new MallNews[i];
        }
    };
    public String fGV;
    public String qSx;
    public int rGH;
    public String rII = "0";
    public String rIJ = "0";
    public String rIK;
    public String rIL;
    public String rIM;
    public String rIN;
    public int rIO;
    public String rIP;
    public int rIQ;
    public String rIR;
    public String rIS;
    public int showType;
    public String type;

    public MallNews(String str) {
        this.rIK = str;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof MallNews)) {
            return false;
        }
        MallNews mallNews = (MallNews) obj;
        if (this.rIK == null || !this.rIK.equals(mallNews.rIK) || this.qSx == null || !this.qSx.equals(mallNews.qSx)) {
            return false;
        }
        return true;
    }

    public MallNews(Parcel parcel) {
        this.rIK = parcel.readString();
        this.qSx = parcel.readString();
        this.fGV = parcel.readString();
        this.rIL = parcel.readString();
        this.rIM = parcel.readString();
        this.rIN = parcel.readString();
        this.rIO = parcel.readInt();
        this.rIP = parcel.readString();
        this.rII = parcel.readString();
        this.rIJ = parcel.readString();
        this.showType = parcel.readInt();
        this.rIR = parcel.readString();
        this.rGH = parcel.readInt();
        this.rIS = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.rIK);
        parcel.writeString(this.qSx);
        parcel.writeString(this.fGV);
        parcel.writeString(this.rIL);
        parcel.writeString(this.rIM);
        parcel.writeString(this.rIN);
        parcel.writeInt(this.rIO);
        parcel.writeString(this.rIP);
        parcel.writeString(this.rII);
        parcel.writeString(this.rIJ);
        parcel.writeInt(this.showType);
        parcel.writeString(this.rIR);
        parcel.writeInt(this.rGH);
        parcel.writeString(this.rIS);
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return String.format("functionId : %s, activityId : %s, ticket : %s, activityMsg : %s, activityLink : %s, activityIconLink : %s, showFlag : %s, orgStr : %s, activityTips: %s, activityType: %d, activityUrl: %s", new Object[]{this.rIK, this.qSx, this.fGV, this.rIL, this.rIM, this.rIN, this.rII, this.rIR, this.rIP, Integer.valueOf(this.rGH), this.rIS});
    }
}
