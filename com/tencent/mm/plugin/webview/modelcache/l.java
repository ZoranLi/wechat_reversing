package com.tencent.mm.plugin.webview.modelcache;

import com.tencent.mm.sdk.platformtools.w;

public final class l {
    final String appId;
    final String fQE;
    final String gaj;
    final String gak;
    final int gal;
    final String rYh;
    final a rYi;

    public l(String str, String str2, int i, String str3, String str4) {
        this.appId = str;
        this.gaj = str2;
        this.rYh = str3;
        this.gal = i;
        this.gak = str4;
        w.i("MicroMsg.WebViewCacheResWriter", "init WebViewCacheResWriter, appId = %s, domain = %s, mainURL = %s, cacheType = %d", new Object[]{str, str2, str3, Integer.valueOf(i)});
        this.rYi = a.Ja(str);
        if (this.rYi != null) {
            a aVar = this.rYi;
            this.fQE = aVar.path + "/" + String.format("%d_%d_%d_%d", new Object[]{Integer.valueOf(str2.hashCode()), Integer.valueOf(i), Integer.valueOf(str3.hashCode()), Integer.valueOf(str4.hashCode())});
            return;
        }
        this.fQE = null;
        w.e("MicroMsg.WebViewCacheResWriter", "get null appIdResDir");
    }
}
