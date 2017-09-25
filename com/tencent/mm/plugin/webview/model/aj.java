package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;
import java.util.Map;

public final class aj {
    private static Map<String, String> rXR = new HashMap();

    public static void dP(String str, String str2) {
        w.i("MicroMsg.WebviewSharedUrlCache", "rawurl:[%s], shareUrl:[%s]", new Object[]{str, str2});
        if (bg.mA(str) || bg.mA(str2)) {
            w.e("MicroMsg.WebviewSharedUrlCache", "rawurl is null or share url is null");
        } else if (rXR.containsKey(str)) {
            w.i("MicroMsg.WebviewSharedUrlCache", "has add this rawurl");
        } else {
            rXR.put(str, str2);
        }
    }

    public static String xH(String str) {
        w.i("MicroMsg.WebviewSharedUrlCache", "rawUrl:[%s]", new Object[]{str});
        if (bg.mA(str)) {
            w.e("MicroMsg.WebviewSharedUrlCache", "rawUrl is null");
            return null;
        }
        String str2 = (String) rXR.get(str);
        if (bg.mA(str2)) {
            int indexOf = str.indexOf("#");
            str2 = (String) rXR.get(indexOf < 0 ? str : str.substring(0, indexOf));
        }
        return !bg.mA(str2) ? str2 : str;
    }

    public static void clear() {
        rXR.clear();
    }
}
