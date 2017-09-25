package com.tencent.mm.plugin.webview.wepkg.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.webview.wepkg.a.a;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import org.json.JSONException;
import org.json.JSONObject;

public class WepkgPreloadFile implements Parcelable {
    public static final Creator<WepkgPreloadFile> CREATOR = new Creator<WepkgPreloadFile>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WepkgPreloadFile(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WepkgPreloadFile[i];
        }
    };
    public String arH;
    public String downloadUrl;
    public String fFW;
    public String filePath;
    public long iam;
    public String mimeType;
    public int size;
    public String sqL;
    public boolean sqM;
    public String sqw;
    public int sqy;
    public String version;

    public WepkgPreloadFile(Parcel parcel) {
        this.arH = parcel.readString();
        this.sqL = parcel.readString();
        this.version = parcel.readString();
        this.filePath = parcel.readString();
        this.sqw = parcel.readString();
        this.mimeType = parcel.readString();
        this.fFW = parcel.readString();
        this.downloadUrl = parcel.readString();
        this.size = parcel.readInt();
        this.sqy = parcel.readInt();
        this.sqM = parcel.readByte() != (byte) 0;
        this.iam = parcel.readLong();
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.arH = aVar.field_key;
            this.sqL = aVar.field_pkgId;
            this.version = aVar.field_version;
            this.filePath = aVar.field_filePath;
            this.sqw = aVar.field_rid;
            this.mimeType = aVar.field_mimeType;
            this.fFW = aVar.field_md5;
            this.downloadUrl = aVar.field_downloadUrl;
            this.size = aVar.field_size;
            this.sqy = aVar.field_downloadNetType;
            this.sqM = aVar.field_completeDownload;
            this.iam = aVar.field_createTime;
        }
    }

    public final JSONObject bAA() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("key", this.arH);
            jSONObject.put("pkgId", this.sqL);
            jSONObject.put("version", this.version);
            jSONObject.put(DownloadInfoColumns.FILEPATH, this.filePath);
            jSONObject.put("rid", this.sqw);
            jSONObject.put("mimeType", this.mimeType);
            jSONObject.put("md5", this.fFW);
            jSONObject.put("downloadUrl", this.downloadUrl);
            jSONObject.put("size", this.size);
            jSONObject.put("downloadNetType", this.sqy);
            jSONObject.put("completeDownload", this.sqM);
            jSONObject.put("createTime", this.iam);
        } catch (JSONException e) {
        }
        return jSONObject;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.arH);
        parcel.writeString(this.sqL);
        parcel.writeString(this.version);
        parcel.writeString(this.filePath);
        parcel.writeString(this.sqw);
        parcel.writeString(this.mimeType);
        parcel.writeString(this.fFW);
        parcel.writeString(this.downloadUrl);
        parcel.writeInt(this.size);
        parcel.writeInt(this.sqy);
        parcel.writeByte((byte) (this.sqM ? 1 : 0));
        parcel.writeLong(this.iam);
    }
}
