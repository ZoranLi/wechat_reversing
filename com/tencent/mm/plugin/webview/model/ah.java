package com.tencent.mm.plugin.webview.model;

import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.mmsight.segment.FFmpegMetadataRetriever;
import com.tencent.mm.plugin.webview.d.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.k;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONStringer;

public final class ah {
    public static String IT(String str) {
        File file = new File(e.gSz);
        if (!file.mkdirs()) {
            w.i("MicroMsg.WebviewJSSDKUtil", "mkdirs failed.File is exist = " + file.exists());
        }
        if (!file.exists()) {
            w.e("MicroMsg.WebviewJSSDKUtil", "camera storage path do not exist.(%s)", new Object[]{e.gSz});
        }
        w.i("MicroMsg.WebviewJSSDKUtil", "get file path from capture file name : %s == %s", new Object[]{str, file.getAbsolutePath() + File.separator + str + ".jpg"});
        return file.getAbsolutePath() + File.separator + str + ".jpg";
    }

    public static Intent IU(String str) {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra("output", Uri.fromFile(new File(IT(str))));
        return intent;
    }

    public static Intent bws() {
        return new Intent("android.media.action.VIDEO_CAPTURE");
    }

    public static Intent bwt() {
        return new Intent("android.provider.MediaStore.RECORD_SOUND");
    }

    public static String IV(String str) {
        w.i("MicroMsg.WebviewJSSDKUtil", "genLocalIdByFilePath, file path is ：%s", new Object[]{str});
        if (bg.mA(str)) {
            return null;
        }
        w.i("MicroMsg.WebviewJSSDKUtil", "gen local id by filepath, filepath : %s, localid : %s", new Object[]{str, "weixin://resourceid/" + aa.Pq(str)});
        return "weixin://resourceid/" + aa.Pq(str);
    }

    public static String IW(String str) {
        WebViewJSSDKFileItem IS = f.bwZ().IS(str);
        if (IS != null) {
            w.i("MicroMsg.WebviewJSSDKUtil", "get local thumb filepath from local id :%s", new Object[]{IS.rWW});
            return IS.rWW;
        }
        w.e("MicroMsg.WebviewJSSDKUtil", "fromLocalIdToFilePath, local map not contains the local id : %s", new Object[]{str});
        return null;
    }

    public static String X(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            w.e("MicroMsg.WebviewJSSDKUtil", "data is null");
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayList.size(); i++) {
            jSONArray.put((String) arrayList.get(i));
        }
        return jSONArray.toString();
    }

    public static String Y(ArrayList<String> arrayList) {
        if (arrayList.size() == 0) {
            w.e("MicroMsg.WebviewJSSDKUtil", "data is null");
            return "";
        }
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            jSONStringer.object();
            for (int i = 0; i < arrayList.size(); i++) {
                String str = (String) arrayList.get(i);
                jSONStringer.key("localId");
                jSONStringer.value(str);
            }
            jSONStringer.endObject();
            jSONStringer.endArray();
            return jSONStringer.toString();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", e, "", new Object[0]);
            return "";
        }
    }

    public static String a(String str, String str2, int i, int i2, int i3, int i4) {
        if (bg.mA(str)) {
            w.e("MicroMsg.WebviewJSSDKUtil", "parseVideoItemToJson localId is null");
            return "";
        }
        JSONStringer jSONStringer = new JSONStringer();
        try {
            jSONStringer.array();
            jSONStringer.object();
            jSONStringer.key("localId");
            jSONStringer.value(str);
            jSONStringer.key("thumbLocalId");
            jSONStringer.value(str2);
            jSONStringer.key(FFmpegMetadataRetriever.METADATA_KEY_DURATION);
            jSONStringer.value(String.valueOf(i));
            jSONStringer.key("height");
            jSONStringer.value(String.valueOf(i2));
            jSONStringer.key("width");
            jSONStringer.value(String.valueOf(i3));
            jSONStringer.key("size");
            jSONStringer.value(String.valueOf(i4));
            jSONStringer.endObject();
            jSONStringer.endArray();
            return jSONStringer.toString();
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.WebviewJSSDKUtil", e, "", new Object[0]);
            return "";
        }
    }

    private static InputStream IX(String str) {
        w.i("MicroMsg.WebviewJSSDKUtil", "getDataFromLocalId : %s", new Object[]{str});
        if (bg.mA(str) || bg.mA(str) || !com.tencent.mm.a.e.aO(str)) {
            return null;
        }
        try {
            return new FileInputStream(str);
        } catch (Exception e) {
            w.e("MicroMsg.WebviewJSSDKUtil", "init file input stream error : %s", new Object[]{e.getMessage()});
            return null;
        }
    }

    public static InputStream IY(String str) {
        if (!bg.mA(str)) {
            return IX(str);
        }
        w.e("MicroMsg.WebviewJSSDKUtil", "local is is null or nil");
        return null;
    }

    public static String IZ(String str) {
        return "_USER_FOR_WEBVIEW_JSAPI" + k.f(str, bg.Nz());
    }
}
