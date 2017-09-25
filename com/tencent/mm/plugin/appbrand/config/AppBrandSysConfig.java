package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.ipcinvoker.extension.c;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.permission.AppRuntimeApiPermissionBundle;
import com.tencent.mm.protocal.c.cw;
import java.util.ArrayList;

public class AppBrandSysConfig implements Parcelable {
    public static final Creator<AppBrandSysConfig> CREATOR = new Creator<AppBrandSysConfig>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandSysConfig(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandSysConfig[i];
        }
    };
    public String appId;
    public String fCJ;
    public String fGs;
    public String iEP;
    public String iEQ;
    public boolean iER;
    public boolean iES;
    public AppRuntimeApiPermissionBundle iET;
    public int iEU;
    public int iEV;
    public int iEW;
    public int iEX;
    public int iEY;
    public long iEZ;
    public int iFa;
    public boolean iFb;
    public boolean iFc;
    public ArrayList<String> iFd;
    public ArrayList<String> iFe;
    public ArrayList<String> iFf;
    public ArrayList<String> iFg;
    public boolean iFh;
    public int iFi;
    public int iFj;
    public final WxaPkgWrappingInfo iFk;
    public final WxaPkgWrappingInfo iFl;
    public AppBrandGlobalSystemConfig iFm;
    cw iFn;
    public transient int iFo;
    public transient String iFp;
    public int uin;

    public final long RE() {
        return this.iFn == null ? 0 : this.iFn.tgd;
    }

    public AppBrandSysConfig() {
        this.iER = false;
        this.iES = false;
        this.iFk = new WxaPkgWrappingInfo();
        this.iFl = new WxaPkgWrappingInfo();
    }

    public String toString() {
        return "AppBrandSysConfig{uin=" + this.uin + ", brandId='" + this.fCJ + '\'' + ", brandName='" + this.fGs + '\'' + ", appId='" + this.appId + '\'' + ", appIconUrl='" + this.iEP + '\'' + ", debugEnabled=" + this.iER + ", performancePanelEnabled=" + this.iES + ", maxWebViewDepth=" + this.iEU + ", maxBackgroundLifeSpan=" + this.iEV + ", maxRequestConcurrent=" + this.iEW + ", maxUploadConcurrent=" + this.iEX + ", maxDownloadConcurrent=" + this.iEY + ", requestDomains=" + this.iFd + ", socketDomains=" + this.iFe + ", uploadDomains=" + this.iFf + ", downloadDomains=" + this.iFg + ", appPkgInfo=" + this.iFk + ", libPkgInfo=" + this.iFl + ", systemSettings=" + this.iFm + ", runningFlag=" + SysConfigUtil.a(this.iFn) + '}';
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        byte b;
        byte b2 = (byte) 1;
        parcel.writeInt(this.uin);
        parcel.writeString(this.fCJ);
        parcel.writeString(this.fGs);
        parcel.writeString(this.appId);
        parcel.writeString(this.iEP);
        parcel.writeString(this.iEQ);
        parcel.writeByte(this.iER ? (byte) 1 : (byte) 0);
        if (this.iES) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeParcelable(this.iET, i);
        parcel.writeInt(this.iEU);
        parcel.writeInt(this.iEV);
        parcel.writeInt(this.iEW);
        parcel.writeInt(this.iEX);
        parcel.writeInt(this.iEY);
        parcel.writeLong(this.iEZ);
        parcel.writeInt(this.iFa);
        if (this.iFb) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        if (this.iFc) {
            b = (byte) 1;
        } else {
            b = (byte) 0;
        }
        parcel.writeByte(b);
        parcel.writeStringList(this.iFd);
        parcel.writeStringList(this.iFe);
        parcel.writeStringList(this.iFf);
        parcel.writeStringList(this.iFg);
        parcel.writeParcelable(this.iFk, i);
        parcel.writeParcelable(this.iFl, i);
        parcel.writeParcelable(this.iFm, i);
        if (!this.iFh) {
            b2 = (byte) 0;
        }
        parcel.writeByte(b2);
        parcel.writeInt(this.iFi);
        parcel.writeInt(this.iFj);
        c.a(this.iFn, parcel);
    }

    protected AppBrandSysConfig(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.iER = false;
        this.iES = false;
        this.uin = parcel.readInt();
        this.fCJ = parcel.readString();
        this.fGs = parcel.readString();
        this.appId = parcel.readString();
        this.iEP = parcel.readString();
        this.iEQ = parcel.readString();
        this.iER = parcel.readByte() != (byte) 0;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iES = z;
        this.iET = (AppRuntimeApiPermissionBundle) parcel.readParcelable(AppRuntimeApiPermissionBundle.class.getClassLoader());
        this.iEU = parcel.readInt();
        this.iEV = parcel.readInt();
        this.iEW = parcel.readInt();
        this.iEX = parcel.readInt();
        this.iEY = parcel.readInt();
        this.iEZ = parcel.readLong();
        this.iFa = parcel.readInt();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iFb = z;
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.iFc = z;
        this.iFd = parcel.createStringArrayList();
        this.iFe = parcel.createStringArrayList();
        this.iFf = parcel.createStringArrayList();
        this.iFg = parcel.createStringArrayList();
        this.iFk = (WxaPkgWrappingInfo) parcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader());
        this.iFl = (WxaPkgWrappingInfo) parcel.readParcelable(WxaPkgWrappingInfo.class.getClassLoader());
        this.iFm = (AppBrandGlobalSystemConfig) parcel.readParcelable(AppBrandGlobalSystemConfig.class.getClassLoader());
        if (parcel.readByte() <= (byte) 0) {
            z2 = false;
        }
        this.iFh = z2;
        this.iFi = parcel.readInt();
        this.iFj = parcel.readInt();
        this.iFn = (cw) c.a(com.tencent.mm.ipcinvoker.wx_extension.c.class.getName(), parcel);
    }
}
