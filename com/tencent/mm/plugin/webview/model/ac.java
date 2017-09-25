package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public final class ac {
    private static ac rWY = new ac();
    HashMap<String, WebViewJSSDKFileItem> rWZ = new HashMap();

    public static final ac bwp() {
        return rWY;
    }

    public final void b(WebViewJSSDKFileItem webViewJSSDKFileItem) {
        if (webViewJSSDKFileItem == null || bg.mA(webViewJSSDKFileItem.fJz)) {
            w.e("MicroMsg.WebViewJSSDKFileItemManager", "item is null or local id is null, ignore this add");
            return;
        }
        w.i("MicroMsg.WebViewJSSDKFileItemManager", "add jssdk file item, local id : %s, file path : %s", new Object[]{webViewJSSDKFileItem.fJz, webViewJSSDKFileItem.iDA});
        this.rWZ.put(webViewJSSDKFileItem.fJz, webViewJSSDKFileItem);
    }

    public final WebViewJSSDKFileItem IS(String str) {
        if (!bg.mA(str)) {
            return (WebViewJSSDKFileItem) this.rWZ.get(str);
        }
        w.e("MicroMsg.WebViewJSSDKFileItemManager", "get by local id error, local id is null or nil");
        return null;
    }
}
