package com.tencent.mm.plugin.webview.modelcache;

import android.os.Build.VERSION;
import android.os.Looper;
import android.os.MessageQueue.IdleHandler;
import android.os.Process;
import android.util.SparseArray;
import com.tencent.mm.e.a.lc;
import com.tencent.mm.e.a.so;
import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.plugin.webview.modelcache.downloaderimpl.f;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public final class q {
    private volatile af hta;
    private final Object jnL = new Object();
    public final c rYr = new c<so>(this) {
        final /* synthetic */ q rYz;

        {
            this.rYz = r2;
            this.usg = so.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            so soVar = (so) bVar;
            if (soVar != null) {
                final f fVar = new f(soVar.gai.url, soVar.gai.filePath, soVar.gai.version, soVar.gai.appId, soVar.gai.gaj, soVar.gai.gak, soVar.gai.gal, soVar.gai.gam, soVar.gai.gan, soVar.gai.gao);
                this.rYz.vL().D(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 rYB;

                    /* JADX WARNING: inconsistent code. */
                    /* Code decompiled incorrectly, please refer to instructions dump. */
                    public final void run() {
                        /*
                        r14 = this;
                        r8 = r1;
                        if (r8 != 0) goto L_0x0005;
                    L_0x0004:
                        return;
                    L_0x0005:
                        r0 = r8.appId;
                        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
                        if (r0 != 0) goto L_0x001d;
                    L_0x000d:
                        r0 = r8.gaj;
                        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
                        if (r0 != 0) goto L_0x001d;
                    L_0x0015:
                        r0 = r8.filePath;
                        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
                        if (r0 == 0) goto L_0x002d;
                    L_0x001d:
                        r0 = "MicroMsg.WebViewCacheDownloadResponseLogic";
                        r1 = "onResponse, invalid response = %s";
                        r2 = 1;
                        r2 = new java.lang.Object[r2];
                        r3 = 0;
                        r2[r3] = r8;
                        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
                        goto L_0x0004;
                    L_0x002d:
                        r0 = "MicroMsg.WebViewCacheDownloadResponseLogic";
                        r1 = "onResponse, response = %s";
                        r2 = 1;
                        r2 = new java.lang.Object[r2];
                        r3 = 0;
                        r2[r3] = r8;
                        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r2);
                        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.rYG;
                        r0 = r0.rYw;
                        r1 = r8.url;
                        r2 = r8.appId;
                        r3 = r8.gaj;
                        r4 = r8.gak;
                        r9 = r0.l(r1, r2, r3, r4);
                        r0 = r8.gao;
                        if (r0 == 0) goto L_0x00f3;
                    L_0x0050:
                        r1 = "MicroMsg.WebViewCacheDownloadResponseLogic";
                        r2 = "onResponse, response.exception = %s";
                        r3 = 1;
                        r3 = new java.lang.Object[r3];
                        r4 = 0;
                        r3[r4] = r0;
                        com.tencent.mm.sdk.platformtools.w.i(r1, r2, r3);
                        r1 = com.tencent.mm.sdk.platformtools.bg.bV(r9);
                        if (r1 != 0) goto L_0x00e9;
                    L_0x0065:
                        r1 = r0 instanceof java.net.SocketTimeoutException;
                        if (r1 == 0) goto L_0x00aa;
                    L_0x0069:
                        r0 = "timeout";
                        r7 = r0;
                    L_0x006d:
                        r10 = r9.iterator();
                    L_0x0071:
                        r0 = r10.hasNext();
                        if (r0 == 0) goto L_0x00e9;
                    L_0x0077:
                        r0 = r10.next();
                        r1 = r0;
                        r1 = (com.tencent.mm.plugin.webview.modelcache.e.c) r1;
                        r0 = r1.rYc;
                        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(r0);
                        r3 = r1.rYd;
                        r0 = r8.gal;
                        r4 = 3;
                        if (r0 != r4) goto L_0x00d3;
                    L_0x008b:
                        r0 = "publicCache";
                    L_0x008e:
                        r2.u(r3, r0, r7);
                        r0 = r8.gal;
                        r2 = 1;
                        if (r0 != r2) goto L_0x00d7;
                    L_0x0096:
                        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.rYG;
                        r0 = r0.rYw;
                        r1 = r1.rYc;
                        r2 = r8.appId;
                        r3 = r8.gaj;
                        r4 = r8.gak;
                        r5 = r8.gal;
                        r6 = r8.url;
                        r0.a(r1, r2, r3, r4, r5, r6);
                        goto L_0x0071;
                    L_0x00aa:
                        r1 = r0 instanceof com.tencent.mm.pluginsdk.k.a.c.d;
                        if (r1 == 0) goto L_0x00b3;
                    L_0x00ae:
                        r0 = "not support redirect resource";
                        r7 = r0;
                        goto L_0x006d;
                    L_0x00b3:
                        r1 = r0 instanceof com.tencent.mm.pluginsdk.k.a.c.f;
                        if (r1 == 0) goto L_0x00bc;
                    L_0x00b7:
                        r0 = "not support 0kb resource";
                        r7 = r0;
                        goto L_0x006d;
                    L_0x00bc:
                        r0 = r0 instanceof com.tencent.mm.pluginsdk.k.a.c.a;
                        if (r0 == 0) goto L_0x00ce;
                    L_0x00c0:
                        r0 = r8.gan;
                        r2 = 5242880; // 0x500000 float:7.34684E-39 double:2.590327E-317;
                        r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1));
                        if (r0 < 0) goto L_0x00ce;
                    L_0x00c9:
                        r0 = "exceed cache threshold";
                        r7 = r0;
                        goto L_0x006d;
                    L_0x00ce:
                        r0 = "batch download fail";
                        r7 = r0;
                        goto L_0x006d;
                    L_0x00d3:
                        r0 = "cache";
                        goto L_0x008e;
                    L_0x00d7:
                        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.rYG;
                        r0 = r0.rYw;
                        r1 = r1.rYc;
                        r2 = r8.appId;
                        r3 = r8.gaj;
                        r4 = r8.gak;
                        r5 = r8.gal;
                        r0.a(r1, r2, r3, r4, r5);
                        goto L_0x0071;
                    L_0x00e9:
                        r0 = 1;
                    L_0x00ea:
                        if (r0 == 0) goto L_0x00f5;
                    L_0x00ec:
                        r0 = 7;
                        com.tencent.mm.plugin.webview.modelcache.m.dV(r0);
                        goto L_0x0004;
                    L_0x00f3:
                        r0 = 0;
                        goto L_0x00ea;
                    L_0x00f5:
                        r0 = r8.filePath;
                        r0 = com.tencent.mm.a.e.aN(r0);
                        if (r0 != 0) goto L_0x0155;
                    L_0x00fd:
                        r0 = "MicroMsg.WebViewCacheDownloadResponseLogic";
                        r1 = "onResponse, readFileLength = 0, return";
                        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
                        r0 = com.tencent.mm.sdk.platformtools.bg.bV(r9);
                        if (r0 != 0) goto L_0x014b;
                    L_0x010c:
                        r7 = r9.iterator();
                    L_0x0110:
                        r0 = r7.hasNext();
                        if (r0 == 0) goto L_0x014b;
                    L_0x0116:
                        r0 = r7.next();
                        r1 = r0;
                        r1 = (com.tencent.mm.plugin.webview.modelcache.e.c) r1;
                        r0 = r1.rYc;
                        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(r0);
                        r3 = r1.rYd;
                        r0 = r8.gal;
                        r4 = 3;
                        if (r0 != r4) goto L_0x0147;
                    L_0x012a:
                        r0 = "publicCache";
                    L_0x012d:
                        r4 = "batch download fail";
                        r2.u(r3, r0, r4);
                        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.rYG;
                        r0 = r0.rYw;
                        r1 = r1.rYc;
                        r2 = r8.appId;
                        r3 = r8.gaj;
                        r4 = r8.gak;
                        r5 = r8.gal;
                        r6 = r8.url;
                        r0.a(r1, r2, r3, r4, r5, r6);
                        goto L_0x0110;
                    L_0x0147:
                        r0 = "cache";
                        goto L_0x012d;
                    L_0x014b:
                        r0 = 0;
                    L_0x014c:
                        if (r0 != 0) goto L_0x035e;
                    L_0x014e:
                        r0 = 8;
                        com.tencent.mm.plugin.webview.modelcache.m.dV(r0);
                        goto L_0x0004;
                    L_0x0155:
                        r0 = r8.url;
                        r4 = com.tencent.mm.plugin.webview.modelcache.p.Je(r0);
                        r6 = com.tencent.mm.plugin.webview.modelcache.q.a.rYG;
                        r1 = r8.appId;
                        r2 = r8.gaj;
                        r3 = r8.gal;
                        r5 = r8.gak;
                        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
                        if (r0 != 0) goto L_0x0177;
                    L_0x016b:
                        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
                        if (r0 != 0) goto L_0x0177;
                    L_0x0171:
                        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
                        if (r0 == 0) goto L_0x01f2;
                    L_0x0177:
                        r0 = "MicroMsg.WebViewCacheWorkerManager";
                        r3 = "getWebViewCacheWriter, invalid params | appId = %s, domain = %s, mainURL = %s";
                        r5 = 3;
                        r5 = new java.lang.Object[r5];
                        r6 = 0;
                        r5[r6] = r1;
                        r1 = 1;
                        r5[r1] = r2;
                        r1 = 2;
                        r5[r1] = r4;
                        com.tencent.mm.sdk.platformtools.w.e(r0, r3, r5);
                        r0 = 0;
                        r3 = r0;
                    L_0x018e:
                        r0 = 0;
                        if (r3 == 0) goto L_0x01aa;
                    L_0x0191:
                        r0 = r8.filePath;
                        r4 = r8.version;
                        r5 = r8.gam;
                        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
                        if (r1 == 0) goto L_0x0227;
                    L_0x019d:
                        r0 = "MicroMsg.WebViewCacheResWriter";
                        r1 = "writeRes with filePath, filePath is null or nil";
                        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
                        r0 = -1;
                    L_0x01a7:
                        if (r0 != 0) goto L_0x033d;
                    L_0x01a9:
                        r0 = 1;
                    L_0x01aa:
                        if (r0 != 0) goto L_0x035b;
                    L_0x01ac:
                        r0 = com.tencent.mm.sdk.platformtools.bg.bV(r9);
                        if (r0 != 0) goto L_0x0358;
                    L_0x01b2:
                        r7 = r9.iterator();
                    L_0x01b6:
                        r0 = r7.hasNext();
                        if (r0 == 0) goto L_0x0358;
                    L_0x01bc:
                        r0 = r7.next();
                        r1 = r0;
                        r1 = (com.tencent.mm.plugin.webview.modelcache.e.c) r1;
                        r0 = r1.rYc;
                        r2 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(r0);
                        r3 = r1.rYd;
                        r0 = r8.gal;
                        r4 = 3;
                        if (r0 != r4) goto L_0x0340;
                    L_0x01d0:
                        r0 = "publicCache";
                    L_0x01d3:
                        r4 = "batch save fail";
                        r2.u(r3, r0, r4);
                        r0 = r8.gal;
                        r2 = 1;
                        if (r0 != r2) goto L_0x0345;
                    L_0x01de:
                        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.rYG;
                        r0 = r0.rYw;
                        r1 = r1.rYc;
                        r2 = r8.appId;
                        r3 = r8.gaj;
                        r4 = r8.gak;
                        r5 = r8.gal;
                        r6 = r8.url;
                        r0.a(r1, r2, r3, r4, r5, r6);
                        goto L_0x01b6;
                    L_0x01f2:
                        r0 = "%s_%s_%s_%s";
                        r7 = 4;
                        r7 = new java.lang.Object[r7];
                        r10 = 0;
                        r7[r10] = r1;
                        r10 = 1;
                        r7[r10] = r2;
                        r10 = 2;
                        r11 = java.lang.Integer.valueOf(r3);
                        r7[r10] = r11;
                        r10 = 3;
                        r7[r10] = r4;
                        r0 = java.lang.String.format(r0, r7);
                        r7 = r0.hashCode();
                        r0 = r6.rYu;
                        r0 = r0.get(r7);
                        r0 = (com.tencent.mm.plugin.webview.modelcache.l) r0;
                        if (r0 != 0) goto L_0x0224;
                    L_0x021a:
                        r0 = new com.tencent.mm.plugin.webview.modelcache.l;
                        r0.<init>(r1, r2, r3, r4, r5);
                        r1 = r6.rYu;
                        r1.put(r7, r0);
                    L_0x0224:
                        r3 = r0;
                        goto L_0x018e;
                    L_0x0227:
                        r1 = com.tencent.mm.a.e.aO(r0);
                        if (r1 != 0) goto L_0x0239;
                    L_0x022d:
                        r0 = "MicroMsg.WebViewCacheResWriter";
                        r1 = "writeRes with filePath, file not exists";
                        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
                        r0 = -1;
                        goto L_0x01a7;
                    L_0x0239:
                        r1 = com.tencent.mm.a.e.aN(r0);
                        if (r1 > 0) goto L_0x024b;
                    L_0x023f:
                        r0 = "MicroMsg.WebViewCacheResWriter";
                        r1 = "writeRes with filePath, file size = 0kb";
                        com.tencent.mm.sdk.platformtools.w.i(r0, r1);
                        r0 = 6;
                        goto L_0x01a7;
                    L_0x024b:
                        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r4);
                        if (r1 == 0) goto L_0x025d;
                    L_0x0251:
                        r0 = "MicroMsg.WebViewCacheResWriter";
                        r1 = "writeRes with filePath, resVersion is null or nil, return";
                        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
                        r0 = -1;
                        goto L_0x01a7;
                    L_0x025d:
                        r1 = r3.rYi;
                        if (r1 != 0) goto L_0x026d;
                    L_0x0261:
                        r0 = "MicroMsg.WebViewCacheResWriter";
                        r1 = "writeRes with filePath, appIdDir is null, return";
                        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
                        r0 = -1;
                        goto L_0x01a7;
                    L_0x026d:
                        r2 = r3.rYi;
                        r6 = r3.fQE;
                        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
                        if (r1 != 0) goto L_0x027d;
                    L_0x0277:
                        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r6);
                        if (r1 == 0) goto L_0x02b8;
                    L_0x027d:
                        r0 = 0;
                    L_0x027f:
                        r6 = com.tencent.mm.plugin.webview.modelcache.k.bwL();
                        r7 = r3.appId;
                        r10 = r3.gaj;
                        r11 = r3.gal;
                        r12 = r3.rYh;
                        r13 = r3.gak;
                        r2 = r6.rXW;
                        if (r2 == 0) goto L_0x0310;
                    L_0x0291:
                        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r7);
                        if (r2 != 0) goto L_0x02a9;
                    L_0x0297:
                        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r10);
                        if (r2 != 0) goto L_0x02a9;
                    L_0x029d:
                        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r12);
                        if (r2 != 0) goto L_0x02a9;
                    L_0x02a3:
                        r2 = com.tencent.mm.sdk.platformtools.bg.mA(r13);
                        if (r2 == 0) goto L_0x02d2;
                    L_0x02a9:
                        r2 = 0;
                    L_0x02aa:
                        if (r2 != 0) goto L_0x0312;
                    L_0x02ac:
                        r0 = "MicroMsg.WebViewCacheResWriter";
                        r1 = "writeRes with filePath, no db record stored";
                        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
                        r0 = -1;
                        goto L_0x01a7;
                    L_0x02b8:
                        r0 = com.tencent.mm.modelsfs.FileOp.p(r0, r6);
                        r10 = 0;
                        r7 = (r0 > r10 ? 1 : (r0 == r10 ? 0 : -1));
                        if (r7 <= 0) goto L_0x027f;
                    L_0x02c2:
                        r7 = r2.path;
                        r6 = r6.startsWith(r7);
                        if (r6 == 0) goto L_0x027f;
                    L_0x02ca:
                        r6 = r2.rXS;
                        r2 = r2.appId;
                        r6.V(r2, r0);
                        goto L_0x027f;
                    L_0x02d2:
                        r2 = new com.tencent.mm.plugin.webview.modelcache.f;
                        r2.<init>();
                        r2.field_appId = r7;
                        r2.field_domain = r10;
                        r2.field_cacheType = r11;
                        r7 = com.tencent.mm.sdk.platformtools.aa.Pq(r12);
                        r7 = r7.hashCode();
                        r2.field_urlMd5Hashcode = r7;
                        r2.field_packageId = r13;
                        r7 = 5;
                        r7 = new java.lang.String[r7];
                        r10 = 0;
                        r11 = "appId";
                        r7[r10] = r11;
                        r10 = 1;
                        r11 = "domain";
                        r7[r10] = r11;
                        r10 = 2;
                        r11 = "cacheType";
                        r7[r10] = r11;
                        r10 = 3;
                        r11 = "urlMd5Hashcode";
                        r7[r10] = r11;
                        r10 = 4;
                        r11 = "packageId";
                        r7[r10] = r11;
                        r6 = r6.b(r2, r7);
                        if (r6 != 0) goto L_0x02aa;
                    L_0x0310:
                        r2 = 0;
                        goto L_0x02aa;
                    L_0x0312:
                        r3 = r3.fQE;
                        r2.field_localPath = r3;
                        r2.field_version = r4;
                        r2.field_contentType = r5;
                        r3 = r2.field_localPath;
                        r3 = com.tencent.mm.plugin.webview.modelcache.p.Jh(r3);
                        r2.field_contentMd5 = r3;
                        r2.field_contentLength = r0;
                        r0 = com.tencent.mm.plugin.webview.modelcache.k.bwL();
                        r0.b(r2);
                        r0 = "MicroMsg.WebViewCacheResWriter";
                        r1 = "writeRes with filePath, updated record = %s";
                        r3 = 1;
                        r3 = new java.lang.Object[r3];
                        r4 = 0;
                        r3[r4] = r2;
                        com.tencent.mm.sdk.platformtools.w.i(r0, r1, r3);
                        r0 = 0;
                        goto L_0x01a7;
                    L_0x033d:
                        r0 = 0;
                        goto L_0x01aa;
                    L_0x0340:
                        r0 = "cache";
                        goto L_0x01d3;
                    L_0x0345:
                        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.rYG;
                        r0 = r0.rYw;
                        r1 = r1.rYc;
                        r2 = r8.appId;
                        r3 = r8.gaj;
                        r4 = r8.gak;
                        r5 = r8.gal;
                        r0.a(r1, r2, r3, r4, r5);
                        goto L_0x01b6;
                    L_0x0358:
                        r0 = 0;
                        goto L_0x014c;
                    L_0x035b:
                        r0 = 1;
                        goto L_0x014c;
                    L_0x035e:
                        r0 = r8.gal;
                        r1 = 1;
                        if (r0 != r1) goto L_0x039f;
                    L_0x0363:
                        r0 = com.tencent.mm.sdk.platformtools.bg.bV(r9);
                        if (r0 != 0) goto L_0x0004;
                    L_0x0369:
                        r7 = r9.iterator();
                    L_0x036d:
                        r0 = r7.hasNext();
                        if (r0 == 0) goto L_0x0004;
                    L_0x0373:
                        r0 = r7.next();
                        r1 = r0;
                        r1 = (com.tencent.mm.plugin.webview.modelcache.e.c) r1;
                        r0 = r1.rYc;
                        r0 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(r0);
                        r2 = r1.rYd;
                        r3 = "cache";
                        r4 = "ok";
                        r0.u(r2, r3, r4);
                        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.rYG;
                        r0 = r0.rYw;
                        r1 = r1.rYc;
                        r2 = r8.appId;
                        r3 = r8.gaj;
                        r4 = r8.gak;
                        r5 = r8.gal;
                        r6 = r8.url;
                        r0.a(r1, r2, r3, r4, r5, r6);
                        goto L_0x036d;
                    L_0x039f:
                        r0 = com.tencent.mm.plugin.webview.modelcache.k.bwL();
                        r1 = r8.appId;
                        r2 = r8.gaj;
                        r3 = r8.gak;
                        r4 = r0.rXW;
                        if (r4 != 0) goto L_0x0407;
                    L_0x03ad:
                        r0 = 0;
                    L_0x03ae:
                        r1 = com.tencent.mm.sdk.platformtools.bg.bV(r0);
                        if (r1 != 0) goto L_0x0004;
                    L_0x03b4:
                        r2 = 1;
                        r3 = r0.iterator();
                    L_0x03b9:
                        r0 = r3.hasNext();
                        if (r0 == 0) goto L_0x0484;
                    L_0x03bf:
                        r0 = r3.next();
                        r0 = (com.tencent.mm.plugin.webview.modelcache.f) r0;
                        if (r0 != 0) goto L_0x044f;
                    L_0x03c7:
                        r1 = 0;
                    L_0x03c8:
                        if (r1 != 0) goto L_0x03b9;
                    L_0x03ca:
                        r0 = 0;
                    L_0x03cb:
                        if (r0 == 0) goto L_0x0004;
                    L_0x03cd:
                        r0 = com.tencent.mm.sdk.platformtools.bg.bV(r9);
                        if (r0 != 0) goto L_0x0004;
                    L_0x03d3:
                        r6 = r9.iterator();
                    L_0x03d7:
                        r0 = r6.hasNext();
                        if (r0 == 0) goto L_0x0004;
                    L_0x03dd:
                        r0 = r6.next();
                        r1 = r0;
                        r1 = (com.tencent.mm.plugin.webview.modelcache.e.c) r1;
                        r0 = r1.rYc;
                        r0 = com.tencent.mm.plugin.webview.ui.tools.jsapi.h.wH(r0);
                        r2 = r1.rYd;
                        r3 = "cache";
                        r4 = "ok";
                        r0.u(r2, r3, r4);
                        r0 = com.tencent.mm.plugin.webview.modelcache.q.a.rYG;
                        r0 = r0.rYw;
                        r1 = r1.rYc;
                        r2 = r8.appId;
                        r3 = r8.gaj;
                        r4 = r8.gak;
                        r5 = r8.gal;
                        r0.a(r1, r2, r3, r4, r5);
                        goto L_0x03d7;
                    L_0x0407:
                        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
                        if (r4 != 0) goto L_0x0419;
                    L_0x040d:
                        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r2);
                        if (r4 != 0) goto L_0x0419;
                    L_0x0413:
                        r4 = com.tencent.mm.sdk.platformtools.bg.mA(r3);
                        if (r4 == 0) goto L_0x041b;
                    L_0x0419:
                        r0 = 0;
                        goto L_0x03ae;
                    L_0x041b:
                        r4 = "select * from %s where %s=? and %s=? and %s=?";
                        r5 = 4;
                        r5 = new java.lang.Object[r5];
                        r6 = 0;
                        r7 = "WebViewResourceCache";
                        r5[r6] = r7;
                        r6 = 1;
                        r7 = "appId";
                        r5[r6] = r7;
                        r6 = 2;
                        r7 = "domain";
                        r5[r6] = r7;
                        r6 = 3;
                        r7 = "packageId";
                        r5[r6] = r7;
                        r4 = java.lang.String.format(r4, r5);
                        r5 = 3;
                        r5 = new java.lang.String[r5];
                        r6 = 0;
                        r5[r6] = r1;
                        r1 = 1;
                        r5[r1] = r2;
                        r1 = 2;
                        r5[r1] = r3;
                        r0 = r0.l(r4, r5);
                        goto L_0x03ae;
                    L_0x044f:
                        r1 = r0.field_contentMd5;
                        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r1);
                        if (r1 != 0) goto L_0x0482;
                    L_0x0457:
                        r1 = r0.field_localPath;
                        r1 = com.tencent.mm.plugin.webview.modelcache.p.Jh(r1);
                        r1 = com.tencent.mm.sdk.platformtools.bg.mz(r1);
                        r4 = r0.field_contentMd5;
                        r1 = r1.equals(r4);
                        if (r1 == 0) goto L_0x0482;
                    L_0x0469:
                        r1 = 1;
                    L_0x046a:
                        r4 = "MicroMsg.WebViewCacheUtils";
                        r5 = "isCacheResValid, cacheRes = %s, ret = %b";
                        r6 = 2;
                        r6 = new java.lang.Object[r6];
                        r7 = 0;
                        r6[r7] = r0;
                        r0 = 1;
                        r7 = java.lang.Boolean.valueOf(r1);
                        r6[r0] = r7;
                        com.tencent.mm.sdk.platformtools.w.d(r4, r5, r6);
                        goto L_0x03c8;
                    L_0x0482:
                        r1 = 0;
                        goto L_0x046a;
                    L_0x0484:
                        r0 = r2;
                        goto L_0x03cb;
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.webview.modelcache.q.1.1.run():void");
                    }
                });
            }
            return false;
        }
    };
    public final c rYs = new c<lc>(this) {
        final /* synthetic */ q rYz;

        {
            this.rYz = r2;
            this.usg = lc.class.getName().hashCode();
        }

        public final /* bridge */ /* synthetic */ boolean a(b bVar) {
            return false;
        }
    };
    private volatile i rYt;
    final SparseArray<l> rYu = new SparseArray();
    public final c rYv = new c();
    final e rYw = new e();
    public final byte[] rYx = new byte[0];
    public final SparseArray<Set<Object>> rYy = new SparseArray();

    class AnonymousClass5 implements Runnable {
        final /* synthetic */ List rYF;
        final /* synthetic */ q rYz;

        public AnonymousClass5(q qVar, List list) {
            this.rYz = qVar;
            this.rYF = list;
        }

        public final void run() {
            for (String str : this.rYF) {
                w.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate requestURL = %s", new Object[]{str});
                if (!bg.mA(str)) {
                    int vS;
                    if (str.startsWith("http://")) {
                        vS = com.tencent.mm.plugin.webview.modelcache.b.a.vS(0);
                    } else if (str.startsWith("https://")) {
                        vS = com.tencent.mm.plugin.webview.modelcache.b.a.vT(com.tencent.mm.plugin.webview.modelcache.b.a.vS(0));
                    } else {
                        w.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, unsupported scheme, url = %s", new Object[]{str});
                    }
                    String Je = p.Je(str);
                    k bwL = k.bwL();
                    List l = !bwL.rXW ? null : bg.mA(Je) ? null : bwL.l(String.format("select * from %s where %s=? and %s=?", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", "protocol"}), String.valueOf(aa.Pq(Je).hashCode()), String.valueOf(vS));
                    if (bg.bV(r1)) {
                        w.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, not cached requestURL = %s, parsed mainURL = %s, protocol = %s", new Object[]{str, Je, com.tencent.mm.plugin.webview.modelcache.b.a.toString(vS)});
                    } else {
                        String Je2 = p.Je(str);
                        if (!bg.mA(Je2)) {
                            Object obj;
                            long Ny = bg.Ny();
                            for (f fVar : r1) {
                                if (Ny - fVar.field_createTime > 60 && Je2.equals(fVar.field_version)) {
                                    obj = 1;
                                    break;
                                }
                            }
                            obj = null;
                            if (obj == null) {
                                w.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, createTime not exceed 1min, no need to update this mainDocument, url = %s", new Object[]{str});
                            } else {
                                byte[] Jg = p.Jg(str);
                                if (bg.bm(Jg)) {
                                    w.i("MicroMsg.WebViewCacheWorkerManager", "triggerMainDocumentURLUpdate, get empty bytes from requestURL = %s", new Object[]{str});
                                } else {
                                    k bwL2 = k.bwL();
                                    List l2 = !bwL2.rXW ? null : bg.mA(Je) ? null : bwL2.l(String.format("select * from %s where %s=? and %s", new Object[]{"WebViewResourceCache", "urlMd5Hashcode", k.vV(vS)}), String.valueOf(aa.Pq(Je).hashCode()));
                                    if (bg.bV(r0)) {
                                        w.e("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, get empty list ");
                                    } else {
                                        String bj = aa.bj(Jg);
                                        for (f fVar2 : r0) {
                                            w.d("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, cacheRes = %s", new Object[]{fVar2});
                                            if (!bg.mA(fVar2.field_localPath)) {
                                                if (bj.equals(fVar2.field_contentMd5)) {
                                                    w.i("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, cache not updated");
                                                } else {
                                                    a Ja = a.Ja(fVar2.field_appId);
                                                    if (Ja != null) {
                                                        String str2 = fVar2.field_localPath;
                                                        if (!(bg.mA(str2) || bg.bm(Jg))) {
                                                            if ((FileOp.k(str2, Jg) == 0 ? 1 : null) != null && str2.startsWith(Ja.path)) {
                                                                Ja.rXS.V(Ja.appId, (long) Jg.length);
                                                            }
                                                        }
                                                        fVar2.field_contentMd5 = bj;
                                                        k.bwL().b(fVar2);
                                                        w.i("MicroMsg.WebViewCacheWorkerManager", "batchUpdateContent with bytes, updated cacheRes = %s", new Object[]{fVar2});
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private static final class a {
        public static final q rYG = new q();
    }

    public final void er(boolean z) {
        for (int i = 0; i < this.rYu.size(); i++) {
            this.rYu.valueAt(i);
        }
        this.rYu.clear();
        a.clearCache();
        if (this.hta != null) {
            synchronized (this.jnL) {
                if (this.hta == null) {
                } else if (z) {
                    this.hta.nJF.quit();
                } else {
                    final af afVar = this.hta;
                    this.hta.D(new Runnable(this) {
                        final /* synthetic */ q rYz;

                        public final void run() {
                            Looper.myQueue().addIdleHandler(new IdleHandler(this) {
                                final /* synthetic */ AnonymousClass4 rYE;

                                {
                                    this.rYE = r1;
                                }

                                public final boolean queueIdle() {
                                    if (VERSION.SDK_INT >= 18) {
                                        afVar.nJF.getLooper().quitSafely();
                                    } else {
                                        afVar.nJF.getLooper().quit();
                                    }
                                    return false;
                                }
                            });
                        }
                    });
                    this.hta = null;
                }
            }
        }
    }

    public final af vL() {
        if (this.hta == null) {
            synchronized (this.jnL) {
                this.hta = new af(this, "WebViewCacheWorkerManager#WorkerThread") {
                    final /* synthetic */ q rYz;

                    public final int D(final Runnable runnable) {
                        return super.D(new Runnable(this) {
                            final /* synthetic */ AnonymousClass3 rYC;

                            public final void run() {
                                if ((Thread.currentThread().getId() == Looper.getMainLooper().getThread().getId() ? 1 : null) == null && Process.getThreadPriority(Process.myTid()) != 10) {
                                    Process.setThreadPriority(10);
                                }
                                if (runnable != null) {
                                    runnable.run();
                                }
                            }
                        });
                    }
                };
            }
        }
        return this.hta;
    }

    public final void vX(int i) {
        if (ap.zb()) {
            try {
                Set set;
                a.rYG.rYw.vU(i);
                synchronized (this.rYx) {
                    set = (Set) this.rYy.get(i);
                }
                if (set == null) {
                    return;
                }
                if (set.size() > 0) {
                    Iterator it = set.iterator();
                    while (it.hasNext()) {
                        it.next();
                        if (this.rYt == null) {
                            this.rYt = new i();
                        }
                        i iVar = this.rYt;
                    }
                }
            } catch (Exception e) {
                w.e("MicroMsg.WebViewCacheWorkerManager", "onWebViewUIDestroy, accHasReady, but occurred exception = %s", new Object[]{e});
            }
        }
    }
}
