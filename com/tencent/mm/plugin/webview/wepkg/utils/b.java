package com.tencent.mm.plugin.webview.wepkg.utils;

import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.webview.wepkg.model.f;
import com.tencent.mm.sdk.platformtools.bg;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class b {
    public static final String iAV;
    public static final Set<Integer> srt = new HashSet();
    public static a sru = new a();
    public static boolean srv = false;

    public static class a {
        public final Map<String, f> srw = new ConcurrentHashMap();

        public final f KM(String str) {
            if (bg.mA(str)) {
                return null;
            }
            return (f) this.srw.get(str);
        }
    }

    static {
        String str = e.hgu;
        if (!str.endsWith("/")) {
            str = str + "/";
        }
        iAV = str + "wepkg/pkgfiles/";
    }
}
