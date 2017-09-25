package com.tencent.mm.plugin.downloader;

import com.tencent.mm.bj.g.c;
import com.tencent.mm.kernel.api.bucket.a;
import com.tencent.mm.kernel.b.d;
import com.tencent.mm.kernel.b.e;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.downloader.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.w;
import java.util.HashMap;

public class PluginDownloader extends d implements a, b {
    public void installed() {
        alias(b.class);
    }

    public void dependency() {
        dependsOn(n.class);
    }

    public void configure(e eVar) {
    }

    public void execute(e eVar) {
        w.d("MicroMsg.PluginDownloader", "execute");
        h.a(com.tencent.mm.plugin.downloader.a.a.class, new a());
    }

    public HashMap<Integer, c> collectDatabaseFactory() {
        w.d("MicroMsg.PluginDownloader", "collectDatabaseFactory");
        HashMap<Integer, c> hashMap = new HashMap();
        hashMap.put(Integer.valueOf("FILEDOWNLOAD_TABLE".hashCode()), new c(this) {
            final /* synthetic */ PluginDownloader kGa;

            {
                this.kGa = r1;
            }

            public final String[] pP() {
                return com.tencent.mm.plugin.downloader.b.b.gUx;
            }
        });
        return hashMap;
    }
}
