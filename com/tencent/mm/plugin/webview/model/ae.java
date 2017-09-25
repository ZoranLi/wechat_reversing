package com.tencent.mm.plugin.webview.model;

import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;

public final class ae extends i<ad> {
    public static final String[] gUx = new String[]{i.a(ad.gTP, "WebviewLocalData")};

    public ae(e eVar) {
        super(eVar, ad.gTP, "WebviewLocalData", null);
    }

    public static int U(String str, String str2, String str3) {
        return (str + str2 + str3).hashCode();
    }
}
