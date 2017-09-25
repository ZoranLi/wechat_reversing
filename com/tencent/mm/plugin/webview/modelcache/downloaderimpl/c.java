package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.k.a.d.j;
import com.tencent.mm.pluginsdk.k.a.d.l;
import com.tencent.mm.pluginsdk.k.a.d.m.a;
import com.tencent.mm.sdk.platformtools.w;
import java.util.concurrent.ConcurrentHashMap;

public final class c extends a<e> {
    private static final ConcurrentHashMap<String, Boolean> rYM = new ConcurrentHashMap();

    public c(e eVar) {
        super(eVar);
    }

    public final boolean Qp() {
        return true;
    }

    public final boolean Qq() {
        return false;
    }

    public final boolean Qr() {
        return true;
    }

    public final boolean Qt() {
        return false;
    }

    public final String Qo() {
        return "WebViewCache";
    }

    public final boolean dW(long j) {
        if (super.dW(j) && j < 5242880) {
            return true;
        }
        return false;
    }

    protected final l a(j jVar) {
        if (rYM.putIfAbsent(((e) Qv()).getFilePath(), Boolean.TRUE) != null) {
            w.i("MicroMsg.ResDownloader.WebViewCacheDownloadNetworkRequestHandler", "request urlKey = %s, already downloading this file", new Object[]{((e) Qv()).sEX});
            return null;
        }
        l a = super.a(jVar);
        rYM.remove(((e) Qv()).getFilePath());
        return a;
    }

    public static void clearCache() {
        rYM.clear();
    }
}
