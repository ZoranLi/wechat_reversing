package com.tencent.mm.plugin.mmsight;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelcontrol.d;

public class SightParams implements Parcelable {
    public static final Creator<SightParams> CREATOR = new Creator<SightParams>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new SightParams(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new SightParams[i];
        }
    };
    public int mode = 0;
    public int nAD = 2;
    public VideoTransPara nAE;
    public String nAF = "";
    public String nAG = "";
    public String nAH = "";
    public String nAI = "";
    public String nAJ = "";
    public boolean nAK = true;
    public int nAL;
    public int scene = -1;

    public SightParams(int i, int i2) {
        if (i == 1) {
            this.nAE = d.Eu().Ev();
        } else if (i == 2 || i == 3 || i == 4) {
            this.nAE = d.Eu().Ew();
        } else {
            this.nAE = d.Eu().Ew();
        }
        this.scene = i;
        this.mode = i2;
        h.vJ();
        this.nAL = ((Integer) h.vI().vr().get(344066, Integer.valueOf(0))).intValue();
    }

    protected SightParams(Parcel parcel) {
        this.mode = parcel.readInt();
        this.nAE = (VideoTransPara) parcel.readParcelable(VideoTransPara.class.getClassLoader());
        this.nAF = parcel.readString();
        this.nAG = parcel.readString();
        this.nAH = parcel.readString();
        this.nAI = parcel.readString();
        this.nAL = parcel.readInt();
        this.nAD = parcel.readInt();
        this.nAK = parcel.readInt() > 0;
        this.scene = parcel.readInt();
    }

    public final SightParams h(String str, String str2, String str3, String str4) {
        this.nAH = str;
        this.nAF = str2;
        this.nAG = str3;
        this.nAI = str4;
        return this;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.mode);
        parcel.writeParcelable(this.nAE, i);
        parcel.writeString(this.nAF);
        parcel.writeString(this.nAG);
        parcel.writeString(this.nAH);
        parcel.writeString(this.nAI);
        parcel.writeInt(this.nAL);
        parcel.writeInt(this.nAD);
        parcel.writeInt(this.nAK ? 1 : 0);
        parcel.writeInt(this.scene);
    }
}
