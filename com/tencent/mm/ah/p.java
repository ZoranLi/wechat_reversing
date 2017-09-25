package com.tencent.mm.ah;

import android.content.Context;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.zero.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.b;

public final class p {
    private static String[] hIa = null;

    public static boolean Ha() {
        boolean z;
        if (hIa == null) {
            Hb();
        }
        if (VERSION.SDK_INT < 14 || hIa == null || hIa.length <= 0 || com.tencent.mm.compatible.d.p.gRl.gQH != 1) {
            z = false;
        } else {
            z = true;
        }
        w.d("MicroMsg.WebpUtil", "isSupportWebp: %b", Boolean.valueOf(z));
        return z;
    }

    private static void Hb() {
        try {
            String value = ((a) h.h(a.class)).sV().getValue("BizEnableWebpUrl");
            w.d("MicroMsg.WebpUtil", "initCdnUrlList, urllist: %s", value);
            if (!bg.mA(value)) {
                hIa = value.split(";");
                w.d("MicroMsg.WebpUtil", "initCdnUrlList, CDN_URL_LIST.length: %d", Integer.valueOf(hIa.length));
            }
        } catch (b e) {
            w.w("MicroMsg.WebpUtil", "initCdnUrlList fail, AccountNotReady");
        } catch (Exception e2) {
            w.d("MicroMsg.WebpUtil", "initCdnUrlList error: %s", e2.getMessage());
        }
    }

    private static boolean jD(String str) {
        if (hIa == null || hIa.length <= 0 || bg.mA(str)) {
            return false;
        }
        for (String startsWith : hIa) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    public static String jE(String str) {
        if (hIa == null || hIa.length == 0) {
            w.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, cdn url is null");
            Hb();
        }
        if (jD(str)) {
            try {
                Uri parse = Uri.parse(str);
                String queryParameter = parse.getQueryParameter("wxtype");
                if (bg.mA(queryParameter)) {
                    return str;
                }
                queryParameter = queryParameter.toLowerCase();
                w.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, wxtype:%s", queryParameter);
                if (queryParameter.equals("gif") || queryParameter.contains("gif")) {
                    return str;
                }
                String queryParameter2 = parse.getQueryParameter("tp");
                if ((!bg.mA(queryParameter2) && queryParameter2.equals("webp")) || bg.mA(queryParameter)) {
                    return str;
                }
                w.d("MicroMsg.WebpUtil", "webpURL: %s", parse.buildUpon().appendQueryParameter("tp", "webp").build().toString());
                return parse.buildUpon().appendQueryParameter("tp", "webp").build().toString();
            } catch (Exception e) {
                return str;
            }
        }
        w.d("MicroMsg.WebpUtil", "addWebpURLIfNecessary, is not cdn url");
        return str;
    }

    public static boolean jF(String str) {
        try {
            if (bg.mA(str) || !jD(str)) {
                return false;
            }
            String queryParameter = Uri.parse(str).getQueryParameter("tp");
            if (bg.mA(queryParameter) || !queryParameter.equals("webp")) {
                return false;
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static int Hc() {
        Context context = ab.getContext();
        if (am.isWifi(context)) {
            return 1;
        }
        if (am.is4G(context)) {
            return 4;
        }
        if (am.is3G(context)) {
            return 3;
        }
        if (am.is2G(context)) {
            return 2;
        }
        return 0;
    }

    public static String gb(int i) {
        return String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(Hc()), Integer.valueOf(2)});
    }

    public static String gc(int i) {
        return String.format("System=android-%d,ClientVersion=%d,NetworkType=%d,Scene=%d", new Object[]{Integer.valueOf(VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(Hc()), Integer.valueOf(1)});
    }

    public static String jG(String str) {
        String str2 = null;
        try {
            if (jD(str)) {
                String toLowerCase = Uri.parse(str).getQueryParameter("wxtype").toLowerCase();
                if (!bg.mA(toLowerCase)) {
                    str2 = toLowerCase.toLowerCase();
                }
            }
        } catch (Exception e) {
        }
        return str2;
    }
}
