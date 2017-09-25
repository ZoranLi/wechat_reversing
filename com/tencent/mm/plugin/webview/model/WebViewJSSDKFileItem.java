package com.tencent.mm.plugin.webview.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.tencent.mm.modelcdntran.d;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;

public abstract class WebViewJSSDKFileItem implements Parcelable {
    public String appId;
    public int fIL;
    public String fJz;
    public String fyF;
    public String iDA;
    public String iDB;
    public boolean iDD;
    public boolean iDE = true;
    public boolean iDF = true;
    public String mediaId;
    public String rWW;
    public a rWX;

    public static class a {
        public String field_aesKey;
        public String field_fileId;
        public int field_fileLength;
        public String field_fileUrl;
    }

    public abstract WebViewJSSDKFileItem bwm();

    public abstract String bwn();

    public abstract String bwo();

    public static WebViewJSSDKFileItem IP(String str) {
        WebViewJSSDKFileItem webViewJSSDKImageItem = new WebViewJSSDKImageItem();
        webViewJSSDKImageItem.iDA = str;
        webViewJSSDKImageItem.bwm();
        webViewJSSDKImageItem.mediaId = d.a("jsupimg", bg.Nz(), webViewJSSDKImageItem.fJz, webViewJSSDKImageItem.fJz);
        return webViewJSSDKImageItem;
    }

    public static WebViewJSSDKFileItem IQ(String str) {
        WebViewJSSDKFileItem webViewJSSDKVoiceItem = new WebViewJSSDKVoiceItem();
        webViewJSSDKVoiceItem.fyF = str;
        webViewJSSDKVoiceItem.bwm();
        webViewJSSDKVoiceItem.mediaId = d.a("jsupvoice", bg.Nz(), webViewJSSDKVoiceItem.fJz, webViewJSSDKVoiceItem.fJz);
        return webViewJSSDKVoiceItem;
    }

    public static WebViewJSSDKFileItem s(int i, String str, String str2) {
        WebViewJSSDKFileItem webViewJSSDKUpFileItem = new WebViewJSSDKUpFileItem();
        webViewJSSDKUpFileItem.fileType = i;
        webViewJSSDKUpFileItem.mlG = str;
        webViewJSSDKUpFileItem.iDA = str2;
        webViewJSSDKUpFileItem.bwm();
        webViewJSSDKUpFileItem.mediaId = d.a("jsupfile", bg.Nz(), webViewJSSDKUpFileItem.fJz, webViewJSSDKUpFileItem.fJz);
        w.d("MicroMsg.WebViewJSSDKFileItem", "fileType=%d, origFilePath=%s, localId=%s", new Object[]{Integer.valueOf(i), str2, webViewJSSDKUpFileItem.fJz});
        return webViewJSSDKUpFileItem;
    }

    public static WebViewJSSDKVideoItem IR(String str) {
        WebViewJSSDKVideoItem webViewJSSDKVideoItem = new WebViewJSSDKVideoItem();
        webViewJSSDKVideoItem.iDA = str;
        webViewJSSDKVideoItem.bwm();
        webViewJSSDKVideoItem.mediaId = d.a("jsvideofile", bg.Nz(), webViewJSSDKVideoItem.fJz, webViewJSSDKVideoItem.fJz);
        w.d("MicroMsg.WebViewJSSDKFileItem", "filepath = %s, localid = %s, mediaid = %s", new Object[]{str, webViewJSSDKVideoItem.fJz, webViewJSSDKVideoItem.mediaId});
        return webViewJSSDKVideoItem;
    }

    public void b(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        if (this.rWX == null) {
            this.rWX = new a();
        }
        if (com_tencent_mm_modelcdntran_keep_SceneResult == null) {
            w.e("MicroMsg.WebViewJSSDKFileItem", "sceneResult info is null");
            return;
        }
        this.rWX.field_aesKey = com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey;
        this.rWX.field_fileId = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId;
        this.rWX.field_fileUrl = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileUrl;
        this.rWX.field_fileLength = com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength;
    }

    protected WebViewJSSDKFileItem(Parcel parcel) {
        this.appId = parcel.readString();
        this.fJz = parcel.readString();
        this.rWW = parcel.readString();
        this.iDA = parcel.readString();
        this.fIL = parcel.readInt();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.appId);
        parcel.writeString(this.fJz);
        parcel.writeString(this.rWW);
        parcel.writeString(this.iDA);
        parcel.writeInt(this.fIL);
    }
}
