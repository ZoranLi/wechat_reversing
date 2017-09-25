package com.tencent.mm.plugin.appbrand.dynamic.i;

import com.tencent.mm.plugin.appbrand.appcache.WxaPkgItemInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appcache.e;
import com.tencent.mm.plugin.appbrand.appcache.f;
import com.tencent.mm.plugin.appbrand.dynamic.core.MiniJsApiFwContext;
import com.tencent.mm.plugin.webview.modelcache.p;
import com.tencent.mm.pluginsdk.j.c;
import com.tencent.mm.pluginsdk.ui.tools.s;
import com.tencent.mm.pluginsdk.ui.tools.s.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.smtt.export.external.interfaces.WebResourceResponse;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel.MapMode;
import java.util.HashMap;
import java.util.Iterator;

public final class g {
    private static WxaPkgWrappingInfo b(WxaPkgWrappingInfo wxaPkgWrappingInfo) {
        if (wxaPkgWrappingInfo == null) {
            return null;
        }
        if (wxaPkgWrappingInfo.izY || bg.bV(wxaPkgWrappingInfo.iAc) || wxaPkgWrappingInfo.iAb != null) {
            return wxaPkgWrappingInfo;
        }
        synchronized (wxaPkgWrappingInfo) {
            if (wxaPkgWrappingInfo.iAb == null) {
                wxaPkgWrappingInfo.iAb = new HashMap(wxaPkgWrappingInfo.iAc.size());
                Iterator it = wxaPkgWrappingInfo.iAc.iterator();
                while (it.hasNext()) {
                    WxaPkgItemInfo wxaPkgItemInfo = (WxaPkgItemInfo) it.next();
                    wxaPkgWrappingInfo.iAb.put(wxaPkgItemInfo.fyF, wxaPkgItemInfo);
                }
            }
        }
        return wxaPkgWrappingInfo;
    }

    private static WebResourceResponse b(String str, String str2, String str3, int i, int i2) {
        try {
            ByteBuffer map = new RandomAccessFile(new File(str), "r").getChannel().map(MapMode.READ_ONLY, (long) i, (long) i2);
            map.order(f.iyH);
            map.limit(i2);
            InputStream cVar = new c(map);
            String Nx = s.Nx(str2);
            String str4 = "UTF-8";
            a Nz = a.Nz(str3);
            if (Nz != null) {
                Nx = Nz.mimeType;
            }
            if (Nz != null) {
                str4 = Nz.charset;
            }
            return new WebResourceResponse(Nx, str4, cVar);
        } catch (Throwable e) {
            w.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile with pkgPath(%s), exp = %s", new Object[]{str, bg.g(e)});
            return null;
        }
    }

    public static String aT(String str, String str2) {
        if (bg.mA(str2)) {
            return "";
        }
        WebResourceResponse aU = aU(str, str2);
        if (aU != null) {
            try {
                w.d("MicroMsg.ResPkgReader", "getCacheContent, dataStream available = %d, url = %s", new Object[]{Integer.valueOf(aU.getData().available()), str2});
            } catch (Exception e) {
                w.e("MicroMsg.ResPkgReader", "getCacheContent exp = %s, id = %s, url = %s", new Object[]{e, str, str2});
            }
            return convertStreamToString(aU.getData());
        }
        w.e("MicroMsg.ResPkgReader", "get cache content for id : %s from url : %s, failed", new Object[]{str, str2});
        return "";
    }

    public static WebResourceResponse aU(String str, String str2) {
        w.i("MicroMsg.ResPkgReader", "getCacheResource called, id = %s, reqURL = %s", new Object[]{str, str2});
        if (bg.mA(str2) || s.eq(str2, "about:blank") || p.xt(str2)) {
            return null;
        }
        WxaPkgWrappingInfo b;
        WebResourceResponse webResourceResponse;
        WxaPkgItemInfo wxaPkgItemInfo;
        String nA = com.tencent.mm.plugin.appbrand.appcache.a.nA(str2);
        MiniJsApiFwContext oC = com.tencent.mm.plugin.appbrand.dynamic.core.g.oC(str);
        if (oC != null) {
            b = b(oC.RU());
        } else {
            b = null;
        }
        if (b == null) {
            w.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null appInfo by id %s", new Object[]{str});
            webResourceResponse = null;
        } else if (bg.mA(b.iAe) || b.iAb == null) {
            w.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get Null Or Nil pkgPath[%s] pkgFileInfoMap[%s] by appId %s", new Object[]{b.iAe, b.iAb, str});
            webResourceResponse = null;
        } else {
            wxaPkgItemInfo = (WxaPkgItemInfo) b.iAb.get(nA);
            if (wxaPkgItemInfo == null) {
                w.v("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, fileInfo not found with id(%s), fileName(%s)", new Object[]{str, nA});
                webResourceResponse = null;
            } else {
                String str3 = b.iAe;
                if (bg.mA(str3)) {
                    w.e("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, get null or nil pkgLocalPath");
                    webResourceResponse = null;
                } else {
                    w.d("MicroMsg.ResPkgReader", "tryHitWxaPkgFile, id(%s), fileName(%s), offset = %d, length = %d", new Object[]{str, nA, Integer.valueOf(wxaPkgItemInfo.izn), Integer.valueOf(wxaPkgItemInfo.izm)});
                    webResourceResponse = b(str3, nA, wxaPkgItemInfo.gam, wxaPkgItemInfo.izn, wxaPkgItemInfo.izm);
                }
            }
        }
        if (webResourceResponse == null) {
            oC = com.tencent.mm.plugin.appbrand.dynamic.core.g.oC(str);
            if (oC != null) {
                b = b(oC.RV());
            } else {
                b = null;
            }
            if (b == null) {
                webResourceResponse = null;
            } else if (b.izY) {
                InputStream openRead = e.openRead(str2);
                webResourceResponse = openRead != null ? new WebResourceResponse(s.Nx(str2), "UTF-8", openRead) : null;
            } else if (bg.mA(b.iAe) || b.iAb == null) {
                w.e("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, pkgPath[%s] or pkgFileInfoMap[%s] is Null Or Nil", new Object[]{b.iAe, b.iAb});
                webResourceResponse = null;
            } else {
                nA = com.tencent.mm.plugin.appbrand.appcache.a.nA(str2);
                wxaPkgItemInfo = (WxaPkgItemInfo) b.iAb.get(nA);
                if (wxaPkgItemInfo == null) {
                    w.v("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, fileInfo not found with fileName(%s)", new Object[]{nA});
                    webResourceResponse = null;
                } else {
                    w.d("MicroMsg.ResPkgReader", "tryHitLibWxaPkgFile, id(%s), fileName(%s), offset = %d, length = %d", new Object[]{str, nA, Integer.valueOf(wxaPkgItemInfo.izn), Integer.valueOf(wxaPkgItemInfo.izm)});
                    webResourceResponse = b(b.iAe, nA, wxaPkgItemInfo.gam, wxaPkgItemInfo.izn, wxaPkgItemInfo.izm);
                }
            }
        }
        return webResourceResponse;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String convertStreamToString(java.io.InputStream r8) {
        /*
        r7 = 1;
        r6 = 0;
        if (r8 != 0) goto L_0x0008;
    L_0x0004:
        r0 = "";
    L_0x0007:
        return r0;
    L_0x0008:
        r1 = new java.io.InputStreamReader;
        r1.<init>(r8);
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r0 = new char[r0];
        r2 = new java.io.StringWriter;
        r2.<init>();
    L_0x0016:
        r3 = -1;
        r4 = r1.read(r0);	 Catch:{ Exception -> 0x0022 }
        if (r3 == r4) goto L_0x0050;
    L_0x001d:
        r3 = 0;
        r2.write(r0, r3, r4);	 Catch:{ Exception -> 0x0022 }
        goto L_0x0016;
    L_0x0022:
        r0 = move-exception;
        r2 = "MicroMsg.ResPkgReader";
        r3 = "convertStreamToString: read, %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x006b }
        r5 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x006b }
        r4[r5] = r0;	 Catch:{ all -> 0x006b }
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);	 Catch:{ all -> 0x006b }
        r0 = "";
        r1.close();	 Catch:{ Exception -> 0x003d }
        goto L_0x0007;
    L_0x003d:
        r1 = move-exception;
        r2 = "MicroMsg.ResPkgReader";
        r3 = "convertStreamToString: close, %s";
        r4 = new java.lang.Object[r7];
        r1 = r1.getMessage();
        r4[r6] = r1;
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
        goto L_0x0007;
    L_0x0050:
        r1.close();	 Catch:{ Exception -> 0x0058 }
    L_0x0053:
        r0 = r2.toString();
        goto L_0x0007;
    L_0x0058:
        r0 = move-exception;
        r1 = "MicroMsg.ResPkgReader";
        r3 = "convertStreamToString: close, %s";
        r4 = new java.lang.Object[r7];
        r0 = r0.getMessage();
        r4[r6] = r0;
        com.tencent.mm.sdk.platformtools.w.e(r1, r3, r4);
        goto L_0x0053;
    L_0x006b:
        r0 = move-exception;
        r1.close();	 Catch:{ Exception -> 0x0070 }
    L_0x006f:
        throw r0;
    L_0x0070:
        r1 = move-exception;
        r2 = "MicroMsg.ResPkgReader";
        r3 = "convertStreamToString: close, %s";
        r4 = new java.lang.Object[r7];
        r1 = r1.getMessage();
        r4[r6] = r1;
        com.tencent.mm.sdk.platformtools.w.e(r2, r3, r4);
        goto L_0x006f;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.appbrand.dynamic.i.g.convertStreamToString(java.io.InputStream):java.lang.String");
    }
}
