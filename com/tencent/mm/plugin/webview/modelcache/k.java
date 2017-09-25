package com.tencent.mm.plugin.webview.modelcache;

import android.database.Cursor;
import com.tencent.mm.plugin.webview.modelcache.d.a;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.LinkedList;
import java.util.List;

public final class k extends i<f> {
    private static volatile k rYg = null;
    private final e gUz;
    public final boolean rXW;

    public final /* synthetic */ boolean b(c cVar) {
        return a((f) cVar);
    }

    public static List<a> bwK() {
        List linkedList = new LinkedList();
        linkedList.add(new a("WEBVIEW_RESOURCE_CACHE_TABLE".hashCode(), new String[]{i.a(f.gTP, "WebViewResourceCache")}));
        return linkedList;
    }

    public static k bwL() {
        if (!ap.zb()) {
            return new k(null);
        }
        if (rYg == null) {
            synchronized (k.class) {
                if (rYg == null || !rYg.rXW) {
                    ap.yY();
                    rYg = new k(com.tencent.mm.u.c.wO());
                }
            }
        }
        return rYg;
    }

    private k(e eVar) {
        super(eVar, f.gTP, "WebViewResourceCache", null);
        this.gUz = eVar;
        this.rXW = eVar != null;
        if (!this.rXW) {
            w.e("MicroMsg.WebViewCacheResStorage", "storage can not work!!!");
        }
    }

    static String vV(int i) {
        String str = "1=1";
        if (b.a.vR(i) && b.a.vQ(i)) {
            return str;
        }
        return String.format(" %s=%s ", new Object[]{"protocol", Integer.valueOf(i)});
    }

    public final List<f> l(String str, String... strArr) {
        List<f> list = null;
        Cursor rawQuery = rawQuery(str, strArr);
        if (rawQuery != null) {
            if (rawQuery.moveToFirst()) {
                list = new LinkedList();
                do {
                    f fVar = new f();
                    fVar.b(rawQuery);
                    list.add(fVar);
                } while (rawQuery.moveToNext());
                rawQuery.close();
            } else {
                rawQuery.close();
            }
        }
        return list;
    }

    public final boolean checkIsCached(String str, int i) {
        if (!this.rXW || bg.mA(str)) {
            return false;
        }
        String vV = vV(i);
        Cursor rawQuery = rawQuery(String.format("select * from %s where %s=? and %s", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", vV}), new String[]{String.valueOf(aa.Pq(str).hashCode())});
        if (rawQuery == null) {
            return false;
        }
        if (rawQuery.getCount() > 0) {
            rawQuery.close();
            return true;
        }
        rawQuery.close();
        return false;
    }

    private boolean a(f fVar) {
        if (!this.rXW) {
            return false;
        }
        if (bg.mA(fVar.field_url)) {
            w.d("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, url is null or nil");
            return false;
        }
        String Pq = aa.Pq(fVar.field_url);
        if (bg.mA(Pq)) {
            w.e("MicroMsg.WebViewCacheResStorage", "insertWebViewCacheRes, get md5 is null or nil , url = %s", new Object[]{fVar.field_url});
            return false;
        }
        fVar.field_urlMd5Hashcode = Pq.hashCode();
        long Ny = bg.Ny();
        fVar.field_accessTime = Ny;
        fVar.field_createTime = Ny;
        return a(fVar, false);
    }

    public final boolean insert(f fVar, int i, int i2) {
        return a(fVar);
    }

    public final boolean update(f fVar, int i, int i2) {
        return b(fVar);
    }

    public final boolean b(f fVar) {
        if (!this.rXW) {
            return false;
        }
        if (bg.mA(fVar.field_url)) {
            w.d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, url is null or nil");
            return false;
        }
        long Ny = bg.Ny();
        fVar.field_accessTime = Ny;
        fVar.field_createTime = Ny;
        w.d("MicroMsg.WebViewCacheResStorage", "updateWebViewCacheRes, record = " + fVar);
        return a(fVar, false, new String[]{"urlMd5Hashcode", "appId", "domain", "cacheType", "packageId"});
    }
}
