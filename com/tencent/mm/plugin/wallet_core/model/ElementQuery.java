package com.tencent.mm.plugin.wallet_core.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public class ElementQuery implements Parcelable {
    public static final Creator<ElementQuery> CREATOR = new Creator<ElementQuery>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ElementQuery(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ElementQuery[i];
        }
    };
    public static String rEJ = "bind_serial";
    public JSONObject hux;
    public String mMa;
    public String ofd;
    public String ofe;
    public int rBY;
    public String rDK;
    public String rEK;
    public boolean rEL;
    public boolean rEM;
    public boolean rEN;
    public boolean rEO;
    public String rEP;
    public boolean rEQ;
    public int rER;
    public int rES;
    public String rET;
    public String rEU;
    public String rEV;
    public String rEW;
    public String rEX;
    public String rEY;
    public boolean rEZ;
    public boolean rFa;
    public boolean rFb;
    public boolean rFc;
    public boolean rFd;
    public boolean rFe;
    public boolean rFf;
    public boolean rFg;
    public boolean rFh;
    public String rFi;
    private List<Integer> rFj = null;
    public boolean rFk;
    public boolean rFl = false;

    public final boolean isError() {
        return "0".equals(bg.ap(this.rEU, "").trim());
    }

    public final boolean btH() {
        return 1 == this.rES;
    }

    public final List<Integer> btI() {
        this.rFi = "1|2|5|9";
        if (this.rFj != null) {
            return this.rFj;
        }
        if (bg.mA(this.rFi)) {
            return null;
        }
        this.rFj = new ArrayList();
        for (String str : this.rFi.split("\\|")) {
            int i = bg.getInt(str, 0);
            if (i > 0) {
                this.rFj.add(Integer.valueOf(i));
            }
        }
        return this.rFj;
    }

    public ElementQuery(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.ofe = parcel.readString();
        this.mMa = parcel.readString();
        this.rEK = parcel.readString();
        this.rEL = 1 == parcel.readInt();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.rEM = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.rEN = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.rEO = z;
        this.rEP = parcel.readString();
        this.ofe = parcel.readString();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.rEQ = z;
        this.rER = parcel.readInt();
        this.rES = parcel.readInt();
        this.ofd = parcel.readString();
        this.rET = parcel.readString();
        this.rEU = parcel.readString();
        this.rEV = parcel.readString();
        this.rEY = parcel.readString();
        this.rEX = parcel.readString();
        this.rEW = parcel.readString();
        this.rEZ = 1 == parcel.readInt();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.rFa = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.rFb = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.rFc = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.rFd = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.rFe = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.rFg = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.rFf = z;
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.rFh = z;
        this.rBY = parcel.readInt();
        this.rFi = parcel.readString();
        if (1 == parcel.readInt()) {
            z = true;
        } else {
            z = false;
        }
        this.rFl = z;
        this.rDK = parcel.readString();
        if (1 != parcel.readInt()) {
            z2 = false;
        }
        this.rFk = z2;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(bg.ap(this.ofe, ""));
        parcel.writeString(bg.ap(this.mMa, ""));
        parcel.writeString(bg.ap(this.rEK, ""));
        parcel.writeInt(this.rEL ? 1 : 0);
        if (this.rEM) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.rEN) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.rEO) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(bg.ap(this.rEP, ""));
        parcel.writeString(bg.ap(this.ofe, ""));
        if (this.rEQ) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.rER);
        parcel.writeInt(this.rES);
        parcel.writeString(bg.ap(this.ofd, ""));
        parcel.writeString(bg.ap(this.rET, ""));
        parcel.writeString(bg.ap(this.rEU, ""));
        parcel.writeString(bg.ap(this.rEV, ""));
        parcel.writeString(bg.ap(this.rEY, ""));
        parcel.writeString(bg.ap(this.rEX, ""));
        parcel.writeString(bg.ap(this.rEW, ""));
        parcel.writeInt(this.rEZ ? 1 : 0);
        if (this.rFa) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.rFb) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.rFc) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.rFd) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.rFe) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.rFg) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.rFf) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        if (this.rFh) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeInt(this.rBY);
        parcel.writeString(this.rFi);
        if (this.rFl) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.rDK);
        if (!this.rFk) {
            i3 = 0;
        }
        parcel.writeInt(i3);
    }
}
