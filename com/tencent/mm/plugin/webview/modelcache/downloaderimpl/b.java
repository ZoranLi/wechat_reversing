package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import com.tencent.mm.pluginsdk.k.a.d.l;
import com.tencent.mm.pluginsdk.k.a.d.o.a;
import com.tencent.mm.pluginsdk.k.a.d.q;
import com.tencent.mm.sdk.platformtools.w;

final class b {
    static void c(String str, l lVar) {
        q Mu = a.sGQ.Mu(str);
        if (Mu == null) {
            w.e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "networkRequest already completed, but get null record with urlKey = %s", new Object[]{str});
        } else if ("WebViewCache".equals(Mu.field_groupId1)) {
            Mu.field_contentType = lVar.gam;
            a.sGQ.e(Mu);
            f fVar = new f(Mu.field_url, Mu.field_filePath, Mu.field_fileVersion, Mu.field_appId, Mu.field_groupId2, Mu.field_packageId, Mu.field_wvCacheType, lVar.gam, lVar.gan, lVar.sGI);
            WebViewCacheDownloadHelper.bwN();
            WebViewCacheDownloadHelper.a(fVar);
        } else {
            w.e("MicroMsg.ResDownloader.WebViewCache.DoResponseLogic", "mismatch groupId, urlKey = %s, record.groupId = %s", new Object[]{str, Mu.field_groupId1});
        }
    }
}
