package com.tencent.mm.plugin.webview.modelcache.downloaderimpl;

import android.os.Looper;
import com.tencent.mm.e.a.so;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.pluginsdk.k.a.d.d;
import com.tencent.mm.pluginsdk.k.a.d.g;
import com.tencent.mm.pluginsdk.k.a.d.h;
import com.tencent.mm.pluginsdk.k.a.d.i;
import com.tencent.mm.pluginsdk.k.a.d.k;
import com.tencent.mm.pluginsdk.k.a.d.l;
import com.tencent.mm.pluginsdk.k.a.d.m;
import com.tencent.mm.pluginsdk.k.a.d.o;
import com.tencent.mm.pluginsdk.k.a.d.o.a;
import com.tencent.mm.pluginsdk.k.a.d.q;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class WebViewCacheDownloadHelper {
    private static final byte[] rYI = new byte[0];
    private static volatile WebViewCacheDownloadHelper rYJ = null;

    public static final class ResDownloaderPlugin implements g {
        private final d rYK = new d(this) {
            final /* synthetic */ ResDownloaderPlugin rYL;

            {
                this.rYL = r1;
            }

            public final void a(String str, l lVar) {
                b.c(str, lVar);
            }

            public final void b(String str, l lVar) {
                AnonymousClass1.Jj(str);
                b.c(str, lVar);
            }

            public final void Ji(String str) {
                AnonymousClass1.Jj(str);
            }

            public final String Qo() {
                return "WebViewCache";
            }

            private static void Jj(String str) {
                q Mu = a.sGQ.Mu(str);
                if (Mu != null) {
                    com.tencent.mm.pluginsdk.k.a.e.a.My(Mu.field_filePath);
                }
            }
        };

        public final void bwP() {
            a.sGQ.a("WebViewCache", this.rYK);
        }

        public final void onAccountRelease() {
            c.clearCache();
            o oVar = a.sGQ;
            String str = "WebViewCache";
            d dVar = this.rYK;
            if (oVar.rXW) {
                i iVar = oVar.sGP;
                if (dVar != null) {
                    int hashCode = str.hashCode();
                    synchronized (iVar.sGz) {
                        List list = (List) iVar.sGy.get(hashCode);
                        if (list == null) {
                            return;
                        }
                        list.remove(dVar);
                    }
                }
            }
        }

        public final String Qo() {
            return "WebViewCache";
        }

        public final m.a c(k kVar) {
            if (kVar != null && (kVar instanceof e)) {
                return new c((e) kVar);
            }
            w.e("MicroMsg.ResDownloader.WebViewCacheDownloadHelper", "getNetworkRequestHandler, get invalid request = " + kVar);
            return null;
        }

        public final h bwQ() {
            return new d();
        }
    }

    private WebViewCacheDownloadHelper() {
    }

    public static WebViewCacheDownloadHelper bwN() {
        if (rYJ == null) {
            synchronized (rYI) {
                rYJ = new WebViewCacheDownloadHelper();
            }
        }
        return rYJ;
    }

    public static void bwO() {
        FileOp.y(a.rYH, false);
    }

    static void a(f fVar) {
        b soVar = new so();
        soVar.gai.url = fVar.url;
        soVar.gai.filePath = fVar.filePath;
        soVar.gai.version = fVar.version;
        soVar.gai.appId = fVar.appId;
        soVar.gai.gaj = fVar.gaj;
        soVar.gai.gak = fVar.gak;
        soVar.gai.gal = fVar.gal;
        soVar.gai.gam = fVar.gam;
        soVar.gai.gao = fVar.gao;
        soVar.gai.gan = fVar.gan;
        com.tencent.mm.sdk.b.a.urY.a(soVar, Looper.getMainLooper());
    }
}
