package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.pluginsdk.wallet.PayInfo;
import com.tencent.mm.sdk.platformtools.bg;

public class Authen implements Parcelable {
    public static final Creator<Authen> CREATOR = new Creator<Authen>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Authen(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Authen[i];
        }
    };
    public String country;
    public int fRW;
    public String gkB;
    public String gkC;
    public String gku;
    public String hCE;
    public String itg;
    public String mMc;
    public PayInfo oLz = new PayInfo();
    public String ofd;
    public String ofe;
    public String rBT;
    public int rDB = 0;
    public String rDC;
    public String rDD;
    public String rDE;
    public int rDF;
    public String rDG;
    public String rDH;
    public String rDI;
    public String rDJ;
    public String rDK;
    public String rDL;
    public String rDM;
    public String rDN;
    public String rDO;
    public String rDP;
    public String rDQ;
    public String rDR;
    public String rDS;
    public String rws;
    public String token;

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.fRW);
        parcel.writeString(bg.ap(this.rDC, ""));
        parcel.writeString(bg.ap(this.ofd, ""));
        parcel.writeString(bg.ap(this.ofe, ""));
        parcel.writeString(bg.ap(this.rDD, ""));
        parcel.writeString(bg.ap(this.rDE, ""));
        parcel.writeInt(this.rDF);
        parcel.writeString(bg.ap(this.rBT, ""));
        parcel.writeString(bg.ap(this.rDG, ""));
        parcel.writeString(bg.ap(this.rDH, ""));
        parcel.writeString(bg.ap(this.rDI, ""));
        parcel.writeString(bg.ap(this.token, ""));
        parcel.writeString(bg.ap(this.rDL, ""));
        parcel.writeString(bg.ap(this.rDM, ""));
        parcel.writeString(bg.ap(this.country, ""));
        parcel.writeString(bg.ap(this.gkB, ""));
        parcel.writeString(bg.ap(this.gkC, ""));
        parcel.writeString(bg.ap(this.hCE, ""));
        parcel.writeString(bg.ap(this.mMc, ""));
        parcel.writeString(bg.ap(this.itg, ""));
        parcel.writeString(bg.ap(this.gku, ""));
        parcel.writeString(bg.ap(this.rws, ""));
        parcel.writeString(bg.ap(this.rDN, ""));
        parcel.writeString(bg.ap(this.rDO, ""));
        parcel.writeString(bg.ap(this.rDK, ""));
        parcel.writeString(bg.ap(this.rDP, ""));
        parcel.writeString(bg.ap(this.rDQ, ""));
        parcel.writeString(bg.ap(this.rDR, ""));
        parcel.writeString(bg.ap(this.rDS, ""));
    }

    public Authen(Parcel parcel) {
        this.fRW = parcel.readInt();
        this.rDC = parcel.readString();
        this.ofd = parcel.readString();
        this.ofe = parcel.readString();
        this.rDD = parcel.readString();
        this.rDE = parcel.readString();
        this.rDF = parcel.readInt();
        this.rBT = parcel.readString();
        this.rDG = parcel.readString();
        this.rDH = parcel.readString();
        this.rDI = parcel.readString();
        this.token = parcel.readString();
        this.rDL = parcel.readString();
        this.rDM = parcel.readString();
        this.country = parcel.readString();
        this.gkB = parcel.readString();
        this.gkC = parcel.readString();
        this.hCE = parcel.readString();
        this.mMc = parcel.readString();
        this.itg = parcel.readString();
        this.gku = parcel.readString();
        this.rws = parcel.readString();
        this.rDN = parcel.readString();
        this.rDO = parcel.readString();
        this.rDK = parcel.readString();
        this.rDP = parcel.readString();
        this.rDQ = parcel.readString();
        this.rDR = parcel.readString();
        this.rDS = parcel.readString();
    }
}
