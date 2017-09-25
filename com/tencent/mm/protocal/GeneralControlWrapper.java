package com.tencent.mm.protocal;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.protocal.c.tk;
import com.tencent.mm.sdk.platformtools.w;

public class GeneralControlWrapper implements Parcelable {
    public static final Creator<GeneralControlWrapper> CREATOR = new Creator<GeneralControlWrapper>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new GeneralControlWrapper(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GeneralControlWrapper[i];
        }
    };
    public static final GeneralControlWrapper sYW = new GeneralControlWrapper(10);
    public static final GeneralControlWrapper sYX = new GeneralControlWrapper(1);
    public int sYY;

    public GeneralControlWrapper(tk tkVar) {
        this.sYY = tkVar.tBp;
        w.d("MicroMsg.GeneralControlWrapper", "edw <init>, " + this);
    }

    public GeneralControlWrapper(int i) {
        this.sYY = i;
        w.d("MicroMsg.GeneralControlWrapper", "edw <init>, " + this);
    }

    public final boolean bHg() {
        boolean z = (this.sYY & 8192) != 0;
        w.d("MicroMsg.GeneralControlWrapper", "allowOuterOpenUrl, ret = " + z);
        return z;
    }

    public final boolean bHh() {
        boolean z = (this.sYY & 2) > 0;
        w.d("MicroMsg.GeneralControlWrapper", "allowInnerOpenUrl, ret = " + z);
        return z;
    }

    public final boolean bHi() {
        boolean z = (this.sYY & 64) > 0;
        w.d("MicroMsg.GeneralControlWrapper", "allowScanQRCode, ret = " + z);
        return z;
    }

    public final boolean bHj() {
        boolean z = (this.sYY & 2048) > 0;
        w.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = " + z);
        return z;
    }

    public final boolean bHk() {
        boolean z = (this.sYY & 16384) > 0;
        w.d("MicroMsg.GeneralControlWrapper", "allowReportPageEvent, ret = " + z);
        return z;
    }

    public final boolean bHl() {
        boolean z = (this.sYY & WXMediaMessage.THUMB_LENGTH_LIMIT) > 0;
        w.d("MicroMsg.GeneralControlWrapper", "allowFavImage, ret = " + z);
        return z;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[bitset=0x");
        stringBuilder.append(Integer.toHexString(this.sYY));
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.sYY);
    }

    public GeneralControlWrapper(Parcel parcel) {
        this.sYY = parcel.readInt();
    }
}
