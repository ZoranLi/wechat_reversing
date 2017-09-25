package com.tencent.mm.plugin.webview.modelcache;

import android.util.SparseArray;
import com.tencent.mm.e.b.ds;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;

public final class a {
    private static final SparseArray<a> rXT = new SparseArray();
    private static volatile b rXU = null;
    private static final byte[] rXV = new byte[0];
    public final String appId;
    public final String path;
    public final b rXS = bwJ();

    private static final class b extends i<a> {
        public final boolean rXW;

        public b(e eVar) {
            super(eVar, a.izp, "WebViewCacheAppIdOccupation", null);
            this.rXW = eVar != null;
        }

        public final void V(String str, long j) {
            if (this.rXW) {
                c aVar = new a();
                aVar.field_appId = str;
                if (b(aVar, new String[0])) {
                    aVar.field_occupation += j;
                    c(aVar, new String[0]);
                    return;
                }
                aVar.field_occupation = j;
                b(aVar);
            }
        }
    }

    private static final class a extends ds {
        public static final com.tencent.mm.sdk.e.c.a izp = ds.pw();

        protected final com.tencent.mm.sdk.e.c.a sY() {
            return izp;
        }
    }

    public static com.tencent.mm.plugin.webview.modelcache.d.a bwI() {
        return new com.tencent.mm.plugin.webview.modelcache.d.a("WEBVIEW_RESOURCE_CACHE_APPID_OCCUPATION_TABLE".hashCode(), new String[]{i.a(ds.pw(), "WebViewCacheAppIdOccupation")});
    }

    public static a Ja(String str) {
        if (bg.mA(str)) {
            return null;
        }
        int hashCode = str.hashCode();
        a aVar = (a) rXT.get(hashCode);
        if (aVar == null) {
            aVar = new a(str);
            rXT.put(hashCode, aVar);
            return aVar;
        }
        FileOp.kl(aVar.path);
        return aVar;
    }

    static void clearCache() {
        rXT.clear();
    }

    private static b bwJ() {
        if (!ap.zb()) {
            return new b(null);
        }
        synchronized (rXV) {
            if (rXU == null || !rXU.rXW) {
                ap.yY();
                rXU = new b(com.tencent.mm.u.c.wO());
            }
        }
        return rXU;
    }

    private a(String str) {
        this.appId = str;
        FileOp.kl(com.tencent.mm.compatible.util.e.gSL + "sfs");
        this.path = com.tencent.mm.compatible.util.e.gSL + String.valueOf(str.hashCode());
        FileOp.kl(this.path);
    }
}
