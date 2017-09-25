package com.tencent.mm.plugin.appbrand.appcache;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.appcache.f.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Map;

public final class WxaPkgWrappingInfo implements Parcelable {
    public static final Creator<WxaPkgWrappingInfo> CREATOR = new Creator<WxaPkgWrappingInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WxaPkgWrappingInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WxaPkgWrappingInfo[i];
        }
    };
    public transient String iAa;
    public volatile transient Map<String, WxaPkgItemInfo> iAb = null;
    public ArrayList<WxaPkgItemInfo> iAc = null;
    public boolean iAd = false;
    public String iAe;
    public int izV;
    public int izW;
    public long izX;
    public boolean izY;
    public String izZ;

    public static WxaPkgWrappingInfo nH(String str) {
        if (bg.mA(str)) {
            return null;
        }
        f fVar = new f(new File(str));
        if (!fVar.iyK) {
            w.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg invalid, path = %s ", new Object[]{str});
            return null;
        } else if (fVar.Qg()) {
            Collection linkedList = new LinkedList();
            for (a aVar : fVar.Qh()) {
                linkedList.add(new WxaPkgItemInfo(aVar.fyF, aVar.iyQ, aVar.iyP));
            }
            fVar.close();
            WxaPkgWrappingInfo wxaPkgWrappingInfo = new WxaPkgWrappingInfo();
            wxaPkgWrappingInfo.iAd = true;
            wxaPkgWrappingInfo.iAc = new ArrayList(linkedList);
            wxaPkgWrappingInfo.iAe = str;
            wxaPkgWrappingInfo.izY = false;
            return wxaPkgWrappingInfo;
        } else {
            w.e("MicroMsg.WxaPkgWrappingInfo#obtain", "wxPkg read info failed, path = %s ", new Object[]{str});
            return null;
        }
    }

    public final void a(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        this.izV = wxaPkgWrappingInfo.izV;
        this.izW = wxaPkgWrappingInfo.izW;
        this.izX = wxaPkgWrappingInfo.izX;
        if (wxaPkgWrappingInfo.iAd) {
            this.izY = wxaPkgWrappingInfo.izY;
            this.iAd = true;
            this.iAc = wxaPkgWrappingInfo.iAc;
            this.iAe = wxaPkgWrappingInfo.iAe;
        }
    }

    public final String toString() {
        Object obj;
        StringBuilder append = new StringBuilder("WxaPkgWrappingInfo{pkgDebugType=").append(this.izV).append(", pkgVersion=").append(this.izW).append(", pkgCreateTime=").append(this.izX).append(", localPkg=").append(this.izY).append(", pkgMd5='").append(this.izZ).append('\'').append(", pkgFileInfoList.size=");
        if (this.iAc == null) {
            obj = "null";
        } else {
            obj = Integer.valueOf(this.iAc.size());
        }
        return append.append(obj).append(", hasPkgFileInfoList=").append(this.iAd).append(", pkgPath='").append(this.iAe).append('\'').append('}').toString();
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        byte b = (byte) 1;
        parcel.writeInt(this.izV);
        parcel.writeInt(this.izW);
        parcel.writeLong(this.izX);
        parcel.writeByte(this.izY ? (byte) 1 : (byte) 0);
        parcel.writeString(this.izZ);
        parcel.writeTypedList(this.iAc);
        if (!this.iAd) {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeString(this.iAe);
    }

    public WxaPkgWrappingInfo(Parcel parcel) {
        boolean z = true;
        this.izV = parcel.readInt();
        this.izW = parcel.readInt();
        this.izX = parcel.readLong();
        this.izY = parcel.readByte() != (byte) 0;
        this.izZ = parcel.readString();
        this.iAc = parcel.createTypedArrayList(WxaPkgItemInfo.CREATOR);
        if (parcel.readByte() == (byte) 0) {
            z = false;
        }
        this.iAd = z;
        this.iAe = parcel.readString();
    }
}
