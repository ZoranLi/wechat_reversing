package com.tencent.mm.pluginsdk.k.a.d;

import android.annotation.SuppressLint;
import com.tencent.mm.pluginsdk.k.a.b.b.a;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

@SuppressLint({"UseSparseArrays"})
public final class p {
    private static final HashMap<Integer, g> sGR;
    private static volatile List<g> sGS = null;

    static {
        HashMap hashMap = new HashMap(2);
        sGR = hashMap;
        hashMap.put(Integer.valueOf("CheckResUpdatePlugin".hashCode()), new a());
        try {
            sGR.put(Integer.valueOf("WebViewCacheDownload".hashCode()), (g) Class.forName("com.tencent.mm.plugin.webview.modelcache.downloaderimpl.WebViewCacheDownloadHelper$ResDownloaderPlugin").newInstance());
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.ResDownloaderPluginMap", e, "", new Object[0]);
        }
    }

    public static void init() {
    }

    public static Collection<g> bDH() {
        if (sGS != null) {
            return sGS;
        }
        List linkedList = new LinkedList();
        for (Integer intValue : sGR.keySet()) {
            g gVar = (g) sGR.get(Integer.valueOf(intValue.intValue()));
            if (gVar != null) {
                linkedList.add(gVar);
            }
        }
        sGS = linkedList;
        return linkedList;
    }
}
