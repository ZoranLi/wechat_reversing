package com.tencent.mm.plugin.webview.d;

import android.net.Uri;
import android.os.Bundle;
import com.tencent.mm.plugin.webview.stub.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.sdk.CookieManager;
import com.tencent.smtt.sdk.CookieSyncManager;
import java.util.LinkedList;
import java.util.List;

public final class b {
    public static final String rYN = Integer.toString(100028);

    public static void c(d dVar) {
        Bundle d;
        try {
            d = dVar.d(24, new Bundle(0));
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.WebView.CookiesCleanup", e, "", new Object[0]);
            d = null;
        }
        if (d == null) {
            w.i("MicroMsg.WebView.CookiesCleanup", "bundle is null, skip cookies cleanup");
            return;
        }
        List stringArrayList = d.getStringArrayList("cookies_cleanup_url_list");
        if (bg.bV(stringArrayList)) {
            w.i("MicroMsg.WebView.CookiesCleanup", "url list is empty, skip cookies cleanup");
            return;
        }
        bM(stringArrayList);
        CookieSyncManager.createInstance(ab.getContext()).sync();
        w.i("MicroMsg.WebView.CookiesCleanup", "cleanup cookies end");
    }

    private static void bM(List<String> list) {
        CookieManager instance = CookieManager.getInstance();
        for (String str : list) {
            List list2;
            w.i("MicroMsg.WebView.CookiesCleanup", "cookies cleanup: url(%s)", new Object[]{str});
            String cookie = instance.getCookie(str);
            if (bg.mA(cookie)) {
                list2 = null;
            } else {
                String[] split = cookie.split(";");
                int length = split.length;
                for (int i = 0; i < length; i++) {
                    split[i] = split[i].trim();
                }
                list2 = new LinkedList();
                for (String str2 : split) {
                    if (!bg.mA(str2) && str2.contains("=")) {
                        list2.add(str2.split("=")[0]);
                    }
                }
                if (list2.isEmpty()) {
                    list2 = null;
                }
            }
            a(str, list2, instance);
        }
    }

    private static void a(String str, List<String> list, CookieManager cookieManager) {
        if (!bg.bV(list)) {
            String str2;
            String[] split = Uri.parse(str).getHost().split("\\.");
            if (split.length <= 1) {
                str2 = "";
            } else {
                str2 = split[split.length - 2] + "." + split[split.length - 1];
            }
            w.d("MicroMsg.WebView.CookiesCleanup", "host(%s)", new Object[]{r2});
            w.d("MicroMsg.WebView.CookiesCleanup", "domain(%s)", new Object[]{str2});
            for (String str3 : list) {
                if (!bg.mA(str3)) {
                    cookieManager.setCookie(str, str3 + "=");
                    cookieManager.setCookie(str, str3 + "=;path=/");
                    if (!bg.mA(str2)) {
                        cookieManager.setCookie(str2, str3 + "=;domain=." + str2 + ";path=/");
                    }
                }
            }
        }
    }
}
