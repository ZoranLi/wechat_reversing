package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.sdk.platformtools.bg;
import java.util.Map;

public final class k {
    public static void a(Map<String, Object> map, boolean z, String str, String str2) {
        if (map != null) {
            map.put("fromMenu", Boolean.valueOf(z));
            map.put("keyParam", str);
            if (bg.mA((String) map.get("appId"))) {
                map.put("appId", str2);
            }
        }
    }
}
