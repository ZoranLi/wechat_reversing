package com.tencent.mm.plugin.appbrand.f;

import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.appbrand.f.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.net.ssl.SSLContext;
import org.json.JSONObject;

public final class a {
    public static int FAILED = -1;
    public static int SUCCESS = 0;
    private String ivH;
    private int jaQ;
    private String jaR = (e.gSx + "appbrand/");
    private SSLContext jaS;
    private final ArrayList<b> jaT = new ArrayList();

    public interface a {
        void b(int i, long j, long j2);

        void b(int i, String str, String str2, int i2);

        void px(String str);
    }

    public a(String str) {
        this.ivH = str;
        this.jaQ = com.tencent.mm.plugin.appbrand.b.mY(str).iEY;
        this.jaS = i.pZ(this.ivH);
    }

    public final void a(JSONObject jSONObject, int i, Map<String, String> map, ArrayList<String> arrayList, int i2, final a aVar, String str, String str2) {
        String optString = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
        if (this.jaT.size() >= this.jaQ) {
            aVar.px("max_connected");
            w.i("MicroMsg.AppBrandNetworkDownload", "max connected");
        } else if (bg.mA(optString)) {
            w.i("MicroMsg.AppBrandNetworkDownload", "url is null");
            aVar.px("url is null");
        } else if (pQ(optString) != null) {
            w.i("MicroMsg.AppBrandNetworkDownload", "the same task is working");
            aVar.px("the same task is working");
        } else {
            Runnable bVar = new b(this.ivH, optString, this.jaR + aa.Pq(optString) + "temp", new com.tencent.mm.plugin.appbrand.f.a.a(this) {
                final /* synthetic */ a jaV;

                public final void a(String str, String str2, String str3, int i) {
                    this.jaV.pP(str3);
                    aVar.b(a.SUCCESS, str2, str, i);
                    w.i("MicroMsg.AppBrandNetworkDownload", "download success! filename %s, url %s", new Object[]{str, str3});
                }

                public final void c(int i, long j, long j2) {
                    aVar.b(i, j, j2);
                }

                public final void y(String str, String str2, String str3) {
                    this.jaV.pP(str2);
                    w.e("MicroMsg.AppBrandNetworkDownload", "download error! filename %s, url %s", new Object[]{str, str2});
                    aVar.px(str3);
                }

                public final void ba(String str, String str2) {
                    w.i("MicroMsg.AppBrandNetworkDownload", "download start! filename %s, url %s", new Object[]{str, str2});
                }
            });
            bVar.jbI = map;
            bVar.jbJ = i;
            bVar.aJi = true;
            bVar.jbh = arrayList;
            bVar.jbK = i2;
            bVar.jaS = this.jaS;
            bVar.iKz = str;
            bVar.jbk = str2;
            synchronized (this.jaT) {
                this.jaT.add(bVar);
            }
            com.tencent.mm.sdk.f.e.post(bVar, "appbrand_download_thread");
        }
    }

    public final void pP(String str) {
        if (str != null) {
            Collection arrayList = new ArrayList();
            synchronized (this.jaT) {
                Iterator it = this.jaT.iterator();
                while (it.hasNext()) {
                    b bVar = (b) it.next();
                    if (bVar.uri.equals(str)) {
                        arrayList.add(bVar);
                    }
                }
                if (arrayList.size() > 0) {
                    this.jaT.removeAll(arrayList);
                }
            }
        }
    }

    private b pQ(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.jaT) {
            Iterator it = this.jaT.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (bVar.uri.equals(str)) {
                    return bVar;
                }
            }
            return null;
        }
    }

    public final b pR(String str) {
        if (str == null) {
            return null;
        }
        synchronized (this.jaT) {
            Iterator it = this.jaT.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                if (str.equals(bVar.iKz)) {
                    return bVar;
                }
            }
            return null;
        }
    }
}
