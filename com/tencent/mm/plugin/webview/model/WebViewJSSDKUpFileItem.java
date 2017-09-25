package com.tencent.mm.plugin.webview.model;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.modelcdntran.keep_SceneResult;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class WebViewJSSDKUpFileItem extends WebViewJSSDKFileItem {
    public static final Creator<WebViewJSSDKUpFileItem> CREATOR = new Creator<WebViewJSSDKUpFileItem>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new WebViewJSSDKUpFileItem((byte) 0);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new WebViewJSSDKUpFileItem[i];
        }
    };
    public int fileType;
    public String mlG;

    public WebViewJSSDKUpFileItem() {
        this.fileType = -1;
        this.fIL = 3;
    }

    public final WebViewJSSDKFileItem bwm() {
        this.fJz = ah.IV(this.iDA);
        return this;
    }

    public final void b(keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult) {
        super.b(com_tencent_mm_modelcdntran_keep_SceneResult);
        List arrayList = new ArrayList();
        arrayList.add(this.fileType);
        arrayList.add(this.mlG);
        arrayList.add(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId);
        arrayList.add(com_tencent_mm_modelcdntran_keep_SceneResult.field_aesKey);
        arrayList.add(com_tencent_mm_modelcdntran_keep_SceneResult.field_fileLength);
        Context context = ab.getContext();
        if (am.isWifi(context)) {
            arrayList.add("1");
        } else if (am.is3G(context)) {
            arrayList.add("4");
        } else if (am.is4G(context)) {
            arrayList.add("5");
        } else if (am.is2G(context)) {
            arrayList.add(TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL);
        } else if (am.isWap(context)) {
            arrayList.add("2");
        } else {
            arrayList.add("0");
        }
        w.d("MicroMsg.WebViewJSSDKVoiceItem", "fileType=%d, initUrl=%s, field_fileId=%s", new Object[]{Integer.valueOf(this.fileType), this.mlG, com_tencent_mm_modelcdntran_keep_SceneResult.field_fileId});
        g.oUh.d(12018, arrayList);
        String str = this.iDA;
        if (!bg.mA(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public final String bwn() {
        return "file";
    }

    public final String bwo() {
        return "nomal";
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
    }

    public WebViewJSSDKUpFileItem(byte b) {
        this.fileType = -1;
    }
}
