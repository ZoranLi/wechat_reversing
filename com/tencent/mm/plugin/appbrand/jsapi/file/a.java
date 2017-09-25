package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.mm.a.g;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.c;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class a extends com.tencent.mm.plugin.appbrand.jsapi.a {
    private static final int CTRL_INDEX = 278;
    private static final String NAME = "getFileInfo";

    public final void a(m mVar, JSONObject jSONObject, int i) {
        String str;
        final String str2 = mVar.ivH;
        final String optString = jSONObject.optString(DownloadInfoColumns.FILEPATH, "");
        if ("sha1".equalsIgnoreCase(jSONObject.optString("digestAlgorithm", "md5"))) {
            str = "sha1";
        } else {
            str = "md5";
        }
        if (bg.mA(optString)) {
            mVar.x(i, d("fail:invalid data", null));
            return;
        }
        final m mVar2 = mVar;
        final int i2 = i;
        e.post(new Runnable(this) {
            final /* synthetic */ a iSn;

            public final void run() {
                AppBrandLocalMediaObject aH = c.aH(str2, optString);
                if (aH == null) {
                    mVar2.x(i2, this.iSn.d("fail:file doesn't exist", null));
                    return;
                }
                File file = new File(aH.hos);
                String str = str;
                Object obj = -1;
                switch (str.hashCode()) {
                    case 107902:
                        if (str.equals("md5")) {
                            obj = null;
                            break;
                        }
                        break;
                    case 3528965:
                        if (str.equals("sha1")) {
                            obj = 1;
                            break;
                        }
                        break;
                }
                switch (obj) {
                    case null:
                        obj = g.f(file);
                        break;
                    case 1:
                        obj = a.p(file);
                        break;
                    default:
                        obj = "";
                        break;
                }
                Map hashMap = new HashMap(2);
                hashMap.put("size", Long.valueOf(file.length()));
                hashMap.put("digest", obj);
                mVar2.x(i2, this.iSn.d("ok", hashMap));
            }
        }, "AppBrandJsApiGetFileInfo");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String p(java.io.File r7) {
        /*
        r6 = 1;
        r5 = 0;
        r0 = "SHA1";
        r0 = java.security.MessageDigest.getInstance(r0);	 Catch:{ NoSuchAlgorithmException -> 0x0025 }
        r1 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0037 }
        r1.<init>(r7);	 Catch:{ FileNotFoundException -> 0x0037 }
        r2 = 8192; // 0x2000 float:1.14794E-41 double:4.0474E-320;
        r2 = new byte[r2];
    L_0x0012:
        r3 = r1.read(r2);	 Catch:{ IOException -> 0x001d, all -> 0x007b }
        if (r3 <= 0) goto L_0x0049;
    L_0x0018:
        r4 = 0;
        r0.update(r2, r4, r3);	 Catch:{ IOException -> 0x001d, all -> 0x007b }
        goto L_0x0012;
    L_0x001d:
        r0 = move-exception;
        r0 = "";
        r1.close();	 Catch:{ IOException -> 0x006c }
    L_0x0024:
        return r0;
    L_0x0025:
        r0 = move-exception;
        r1 = "MicroMsg.JsApiGetFileInfo";
        r2 = "Exception while getting Digest";
        r3 = new java.lang.Object[r6];
        r3[r5] = r0;
        com.tencent.mm.sdk.platformtools.w.e(r1, r2, r3);
        r0 = "";
        goto L_0x0024;
    L_0x0037:
        r0 = move-exception;
        r1 = "MicroMsg.JsApiGetFileInfo";
        r2 = "Exception while getting FileInputStream";
        r3 = new java.lang.Object[r6];
        r3[r5] = r0;
        com.tencent.mm.sdk.platformtools.w.e(r1, r2, r3);
        r0 = "";
        goto L_0x0024;
    L_0x0049:
        r0 = r0.digest();	 Catch:{ IOException -> 0x001d, all -> 0x007b }
        r2 = new java.math.BigInteger;	 Catch:{ IOException -> 0x001d, all -> 0x007b }
        r3 = 1;
        r2.<init>(r3, r0);	 Catch:{ IOException -> 0x001d, all -> 0x007b }
        r0 = 16;
        r0 = r2.toString(r0);	 Catch:{ IOException -> 0x001d, all -> 0x007b }
        r1.close();	 Catch:{ IOException -> 0x005d }
        goto L_0x0024;
    L_0x005d:
        r1 = move-exception;
        r2 = "MicroMsg.JsApiGetFileInfo";
        r3 = "Exception on closing MD5 input stream";
        r4 = new java.lang.Object[r6];
        r4[r5] = r1;
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
        goto L_0x0024;
    L_0x006c:
        r1 = move-exception;
        r2 = "MicroMsg.JsApiGetFileInfo";
        r3 = "Exception on closing MD5 input stream";
        r4 = new java.lang.Object[r6];
        r4[r5] = r1;
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
        goto L_0x0024;
    L_0x007b:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x0080 }
    L_0x007f:
        throw r0;
    L_0x0080:
        r1 = move-exception;
        r2 = "MicroMsg.JsApiGetFileInfo";
        r3 = "Exception on closing MD5 input stream";
        r4 = new java.lang.Object[r6];
        r4[r5] = r1;
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
        goto L_0x007f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.jsapi.file.a.p(java.io.File):java.lang.String");
    }
}
