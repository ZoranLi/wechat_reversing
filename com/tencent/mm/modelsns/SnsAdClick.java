package com.tencent.mm.modelsns;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.e.a.mj;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bg;

public class SnsAdClick implements Parcelable {
    public static final Creator<SnsAdClick> CREATOR = new Creator<SnsAdClick>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            SnsAdClick snsAdClick = new SnsAdClick();
            snsAdClick.hTm = parcel.readString();
            snsAdClick.scene = parcel.readInt();
            snsAdClick.hTp = parcel.readInt();
            snsAdClick.hTn = parcel.readLong();
            snsAdClick.hTo = parcel.readString();
            snsAdClick.hTq = parcel.readLong();
            snsAdClick.hTs = parcel.readInt();
            snsAdClick.hTr = parcel.readInt();
            return snsAdClick;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SnsAdClick[i];
        }
    };
    public String hTm = "";
    public long hTn = 0;
    public String hTo = "";
    public int hTp = 0;
    public long hTq = 0;
    public int hTr = 0;
    public int hTs = 0;
    public int scene = 0;

    public SnsAdClick(String str, int i, long j, String str2, int i2) {
        this.hTm = str;
        this.scene = i;
        this.hTn = j;
        this.hTo = str2;
        this.hTr = i2;
        this.hTs = 1;
        this.hTq = System.currentTimeMillis();
    }

    public SnsAdClick(String str, int i, long j, String str2, int i2, byte b) {
        this.hTm = str;
        this.scene = i;
        this.hTn = j;
        this.hTo = str2;
        this.hTr = i2;
        this.hTs = 0;
        this.hTq = System.currentTimeMillis();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hTm);
        parcel.writeInt(this.scene);
        parcel.writeInt(this.hTp);
        parcel.writeLong(this.hTn);
        parcel.writeString(bg.ap(this.hTo, ""));
        parcel.writeLong(this.hTq);
        parcel.writeInt(this.hTs);
        parcel.writeInt(this.hTr);
    }

    public final void gy(int i) {
        b mjVar = new mj();
        this.hTp = i;
        mjVar.fTF.fTG = this;
        a.urY.m(mjVar);
    }
}
