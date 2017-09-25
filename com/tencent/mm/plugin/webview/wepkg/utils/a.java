package com.tencent.mm.plugin.webview.wepkg.utils;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    public static void b(String str, String str2, String str3, String str4, long j, long j2, String str5) {
        try {
            if (bg.mA(str5)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(DownloadInfo.NETTYPE, am.ee(ab.getContext()));
                str5 = URLEncoder.encode(jSONObject.toString(), "UTF-8");
            } else {
                JSONObject jSONObject2 = new JSONObject(URLDecoder.decode(str5, "UTF-8"));
                jSONObject2.put(DownloadInfo.NETTYPE, am.ee(ab.getContext()));
                str5 = URLEncoder.encode(jSONObject2.toString(), "UTF-8");
            }
        } catch (Exception e) {
        }
        g.oUh.i(13980, new Object[]{str, str2, str3, str4, Long.valueOf(j), str5, Long.valueOf(j2)});
    }

    public static String KL(String str) {
        if (str == null) {
            return "";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(SlookSmartClipMetaTag.TAG_TYPE_URL, str);
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (JSONException e) {
            w.e("MicroMsg.WePkgReport", e.getMessage());
            return "";
        } catch (UnsupportedEncodingException e2) {
            w.e("MicroMsg.WePkgReport", e2.getMessage());
            return "";
        }
    }

    public static String wN(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("subCode", i);
            return URLEncoder.encode(jSONObject.toString(), "UTF-8");
        } catch (JSONException e) {
            return null;
        } catch (UnsupportedEncodingException e2) {
            return null;
        }
    }
}
