package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.mm.plugin.appbrand.h;
import com.tencent.mm.plugin.webview.modelcache.p;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.Closeable;
import java.io.File;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class l {
    public static final Map<h, l> izA = new HashMap();
    private static final l izB = new l() {
        protected final <T> T d(String str, Class<T> cls) {
            return null;
        }
    };
    public static final String[] izz = new String[]{"/WAWebview.js", "/WAService.js", "/WAVConsole.js", "/WAPerf.js"};
    public final String ivH;
    final f izC;
    final f izD;

    private interface b<T> {

        public static class a {
            public static final Map<Class, b> izF;

            static {
                Map hashMap = new HashMap();
                izF = hashMap;
                hashMap.put(InputStream.class, new c());
                izF.put(WebResourceResponse.class, new e());
                izF.put(String.class, new d());
                izF.put(byte[].class, new a());
            }
        }

        T b(String str, InputStream inputStream);
    }

    private static final class a implements b<byte[]> {
        public final /* synthetic */ Object b(String str, InputStream inputStream) {
            return com.tencent.mm.plugin.appbrand.m.a.i(inputStream);
        }
    }

    private static final class c implements b<InputStream> {
        public final /* bridge */ /* synthetic */ Object b(String str, InputStream inputStream) {
            return inputStream;
        }
    }

    private static final class d implements b<String> {
        public final /* synthetic */ Object b(String str, InputStream inputStream) {
            return com.tencent.mm.plugin.appbrand.m.a.convertStreamToString(inputStream);
        }
    }

    private static final class e implements b<WebResourceResponse> {
        public final /* synthetic */ Object b(String str, InputStream inputStream) {
            return new WebResourceResponse(s.Nx(str), "UTF-8", inputStream);
        }
    }

    public static String a(h hVar, String str) {
        return (String) c(hVar).d(str, String.class);
    }

    public static boolean b(h hVar, String str) {
        Closeable d = d(hVar, str);
        if (d == null) {
            return false;
        }
        bg.g(d);
        return true;
    }

    public static WebResourceResponse c(h hVar, String str) {
        return (WebResourceResponse) c(hVar).d(str, WebResourceResponse.class);
    }

    public static InputStream d(h hVar, String str) {
        return (InputStream) c(hVar).d(str, InputStream.class);
    }

    public static byte[] e(h hVar, String str) {
        return (byte[]) c(hVar).d(str, byte[].class);
    }

    private static l c(h hVar) {
        if (hVar == null) {
            return izB;
        }
        l lVar;
        synchronized (izA) {
            lVar = (l) izA.get(hVar);
            if (lVar == null) {
                lVar = new l(hVar);
                izA.put(hVar, lVar);
            }
        }
        return lVar;
    }

    public l(final h hVar) {
        if (hVar == null) {
            this.izC = null;
            this.izD = null;
            this.ivH = null;
            return;
        }
        this.ivH = hVar.ivH;
        if (hVar.iwo.iFl.izY) {
            this.izC = null;
        } else {
            this.izC = new f(new File(hVar.iwo.iFl.iAe));
        }
        this.izD = new f(new File(hVar.iwo.iFk.iAe));
        com.tencent.mm.plugin.appbrand.e.a(this.ivH, new com.tencent.mm.plugin.appbrand.e.b(this) {
            final /* synthetic */ l izE;

            public final void onDestroy() {
                com.tencent.mm.plugin.appbrand.e.b(this.izE.ivH, this);
                synchronized (l.izA) {
                    l.izA.remove(hVar);
                }
                l lVar = this.izE;
                if (lVar.izC != null) {
                    lVar.izC.close();
                }
                if (lVar.izD != null) {
                    lVar.izD.close();
                }
            }
        });
    }

    protected <T> T d(String str, Class<T> cls) {
        T t = null;
        boolean z = true;
        boolean z2 = bg.mA(str) ? true : s.eq(str, "about:blank") ? true : p.xt(str);
        if (!z2) {
            String nA = a.nA(str);
            boolean a = com.tencent.mm.compatible.loader.a.a(izz, nA);
            long currentTimeMillis = System.currentTimeMillis();
            if (c(a, nA) != null) {
                t = ((b) a.izF.get(cls)).b(nA, c(a, nA));
            }
            String str2 = "MicroMsg.WxaPkgRuntimeReader";
            String str3 = "openRead, appId = %s, reqURL = %s, null(%B), type = %s, cost = %dms";
            Object[] objArr = new Object[5];
            objArr[0] = this.ivH;
            objArr[1] = nA;
            if (t != null) {
                z = false;
            }
            objArr[2] = Boolean.valueOf(z);
            objArr[3] = cls.getName();
            objArr[4] = Long.valueOf(System.currentTimeMillis() - currentTimeMillis);
            w.i(str2, str3, objArr);
        }
        return t;
    }

    private InputStream c(boolean z, String str) {
        if (!z) {
            this.izD.Qg();
            return this.izD.nC(str);
        } else if (this.izC == null) {
            return e.openRead(str);
        } else {
            this.izC.Qg();
            return this.izC.nC(str);
        }
    }
}
