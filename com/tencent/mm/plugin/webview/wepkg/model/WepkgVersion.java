package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.wepkg.a.c;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgVersion implements Parcelable {
    public static final Creator<WepkgVersion> CREATOR = new Creator<WepkgVersion>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WepkgVersion(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WepkgVersion[i];
        }
    };
    public String appId;
    public String charset;
    public String downloadUrl;
    public String fFW;
    public String gaj;
    public String iAe;
    public long iam;
    public String sqL;
    public int sqy;
    public boolean srb;
    public long srd;
    public long sre;
    public int srf;
    public int srg;
    public long srh;
    public boolean sri;
    public boolean srj;
    public boolean srk;
    public int srl;
    public String version;

    public WepkgVersion(Parcel parcel) {
        boolean z;
        boolean z2 = true;
        this.sqL = parcel.readString();
        this.appId = parcel.readString();
        this.version = parcel.readString();
        this.iAe = parcel.readString();
        if (parcel.readByte() != (byte) 0) {
            z = true;
        } else {
            z = false;
        }
        this.srb = z;
        this.srd = parcel.readLong();
        this.sre = parcel.readLong();
        this.srf = parcel.readInt();
        this.gaj = parcel.readString();
        this.fFW = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.srg = parcel.readInt();
        this.sqy = parcel.readInt();
        this.srh = parcel.readLong();
        this.iam = parcel.readLong();
        this.charset = parcel.readString();
        this.sri = parcel.readByte() != (byte) 0;
        this.srj = parcel.readByte() != (byte) 0;
        if (parcel.readByte() == (byte) 0) {
            z2 = false;
        }
        this.srk = z2;
        this.srl = parcel.readInt();
    }

    public final void a(c cVar) {
        if (cVar != null) {
            this.sqL = cVar.field_pkgId;
            this.appId = cVar.field_appId;
            this.version = cVar.field_version;
            this.iAe = cVar.field_pkgPath;
            this.srb = cVar.field_disableWvCache;
            this.srd = cVar.field_clearPkgTime;
            this.sre = cVar.field_checkIntervalTime;
            this.srf = cVar.field_packMethod;
            this.gaj = cVar.field_domain;
            this.fFW = cVar.field_md5;
            this.downloadUrl = cVar.field_downloadUrl;
            this.srg = cVar.field_pkgSize;
            this.sqy = cVar.field_downloadNetType;
            this.srh = cVar.field_nextCheckTime;
            this.iam = cVar.field_createTime;
            this.charset = cVar.field_charset;
            this.sri = cVar.field_bigPackageReady;
            this.srj = cVar.field_preloadFilesReady;
            this.srk = cVar.field_preloadFilesAtomic;
            this.srl = cVar.field_totalDownloadCount;
        }
    }

    public final JSONObject bAA() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("appId", this.appId);
            jSONObject.put("version", this.version);
            jSONObject.put("pkgPath", this.iAe);
            jSONObject.put("disableWvCache", this.srb);
            jSONObject.put("clearPkgTime", this.srd);
            jSONObject.put("checkIntervalTime", this.sre);
            jSONObject.put("packMethod", this.srf);
            jSONObject.put("domain", this.gaj);
            jSONObject.put("md5", this.fFW);
            jSONObject.put("downloadUrl", this.downloadUrl);
            jSONObject.put("pkgSize", this.srg);
            jSONObject.put("downloadNetType", this.sqy);
            jSONObject.put("nextCheckTime", this.srh);
            jSONObject.put("charset", this.charset);
            jSONObject.put("bigPackageReady", this.sri);
            jSONObject.put("preloadFilesReady", this.srj);
            jSONObject.put("preloadFilesAtomic", this.srk);
            jSONObject.put("totalDownloadCount", this.srl);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2;
        int i3 = 1;
        parcel.writeString(this.sqL);
        parcel.writeString(this.appId);
        parcel.writeString(this.version);
        parcel.writeString(this.iAe);
        parcel.writeByte((byte) (this.srb ? 1 : 0));
        parcel.writeLong(this.srd);
        parcel.writeLong(this.sre);
        parcel.writeInt(this.srf);
        parcel.writeString(this.gaj);
        parcel.writeString(this.fFW);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.srg);
        parcel.writeInt(this.sqy);
        parcel.writeLong(this.srh);
        parcel.writeLong(this.iam);
        parcel.writeString(this.charset);
        parcel.writeByte((byte) (this.sri ? 1 : 0));
        if (this.srj) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        parcel.writeByte((byte) i2);
        if (!this.srk) {
            i3 = 0;
        }
        parcel.writeByte((byte) i3);
        parcel.writeInt(this.srl);
    }
}
