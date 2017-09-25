package com.tencent.mm.plugin.voiceprint.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bg;

public class VertifyInfo implements Parcelable {
    public static final Creator<VertifyInfo> CREATOR = new Creator<VertifyInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            boolean z = true;
            VertifyInfo vertifyInfo = new VertifyInfo();
            vertifyInfo.rcA = parcel.readInt();
            vertifyInfo.rcB = parcel.readInt();
            vertifyInfo.rcC = parcel.readInt();
            vertifyInfo.rcr = parcel.readInt();
            vertifyInfo.jqT = parcel.readString();
            vertifyInfo.rck = parcel.readString();
            vertifyInfo.mFileName = parcel.readString();
            vertifyInfo.rcD = parcel.readInt() > 0;
            if (parcel.readInt() <= 0) {
                z = false;
            }
            vertifyInfo.rcE = z;
            vertifyInfo.rcr = vertifyInfo.rcA;
            return vertifyInfo;
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new VertifyInfo[i];
        }
    };
    public String jqT = "";
    public String mFileName = "";
    public int rcA;
    public int rcB;
    public int rcC = 0;
    public boolean rcD = false;
    public boolean rcE = false;
    public String rck = "";
    public int rcr = 0;
    public String rcw = "";

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeInt(this.rcA);
        parcel.writeInt(this.rcB);
        parcel.writeInt(this.rcC);
        parcel.writeInt(this.rcr);
        parcel.writeString(bg.ap(this.jqT, ""));
        parcel.writeString(bg.ap(this.rck, ""));
        parcel.writeString(bg.ap(this.mFileName, ""));
        if (this.rcD) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (!this.rcE) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
