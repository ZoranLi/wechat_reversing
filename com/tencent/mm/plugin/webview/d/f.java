package com.tencent.mm.plugin.webview.d;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.bj.g.c;
import com.tencent.mm.e.a.ad;
import com.tencent.mm.e.a.ae;
import com.tencent.mm.e.a.bu;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.e.a.ib;
import com.tencent.mm.e.a.kh;
import com.tencent.mm.e.a.sr;
import com.tencent.mm.network.m;
import com.tencent.mm.platformtools.n;
import com.tencent.mm.plugin.downloader.model.e;
import com.tencent.mm.plugin.fts.a.l;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.plugin.webview.model.aa;
import com.tencent.mm.plugin.webview.model.ac;
import com.tencent.mm.plugin.webview.model.ag;
import com.tencent.mm.plugin.webview.modelcache.k;
import com.tencent.mm.plugin.webview.modelcache.q;
import com.tencent.mm.plugin.webview.ui.tools.h;
import com.tencent.mm.pluginsdk.ui.tools.j;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.bov;
import com.tencent.mm.protocal.c.ho;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.bp;
import com.tencent.mm.u.p;
import com.tencent.mm.y.d;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class f implements am {
    private static final HashMap<Integer, c> gJr;
    com.tencent.mm.sdk.b.c iyu = new com.tencent.mm.sdk.b.c<ad>(this) {
        final /* synthetic */ f rZB;

        {
            this.rZB = r2;
            this.usg = ad.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            w.i("MicroMsg.SubCoreTools", "now prepare WebviewKeepBanner, hc:%d, sc:%d", new Object[]{Integer.valueOf(hashCode()), Integer.valueOf(this.rZB.hashCode())});
            b aeVar = new ae();
            aeVar.fDk.fDm = new h(ab.getContext());
            a.urY.m(aeVar);
            return false;
        }
    };
    private bp.a jOG = new bp.a(this) {
        final /* synthetic */ f rZB;

        {
            this.rZB = r1;
        }

        public final void a(d.a aVar) {
            final String a = n.a(aVar.hst.tff);
            final i bxa = f.bxa();
            new Thread(new Runnable(this) {
                final /* synthetic */ AnonymousClass11 rZD;

                public final void run() {
                    w.d("MicroMsg.SubCoreTools", "webview hijack sysMsgListener");
                    Map q = bh.q(a, "sysmsg");
                    long j = bg.getLong((String) q.get(".sysmsg.hijackconfig.expiretime"), Long.MAX_VALUE);
                    String str = ".sysmsg.hijackconfig.domainlist.domain";
                    int i = 0;
                    String str2 = str;
                    while (true) {
                        String str3;
                        if (i > 0) {
                            str3 = str + i;
                        } else {
                            str3 = str2;
                        }
                        i++;
                        str2 = (String) q.get(str3);
                        if (!bg.mA(str2)) {
                            com.tencent.mm.sdk.e.c hVar = new h();
                            hVar.field_expireTime = j;
                            hVar.field_host = str2;
                            bxa.b(hVar);
                            str2 = str3;
                        } else {
                            return;
                        }
                    }
                }
            }).start();
        }
    };
    private m lTJ = new m.a(this) {
        private final byte[] gJW = new byte[0];
        final /* synthetic */ f rZB;

        {
            this.rZB = r2;
        }

        public final void cU(int i) {
            synchronized (this.gJW) {
                if (com.tencent.mm.sdk.platformtools.am.getNetType(ab.getContext()) == 0) {
                    ag.bwr().setNetWorkState(1);
                } else {
                    ag.bwr().setNetWorkState(2);
                }
            }
        }
    };
    private com.tencent.mm.sdk.b.c rZA = new com.tencent.mm.sdk.b.c<kh>(this) {
        final /* synthetic */ f rZB;

        {
            this.rZB = r2;
            this.usg = kh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kh khVar = (kh) bVar;
            if (khVar.fQJ.scene == 0) {
                f.bwW().rVD = 0;
                f.bwW().hPH = null;
            } else {
                f.bwW().rVD = 1;
                f.bwW().hPH = new bov();
                f.bwW().hPH.unm = 1;
                f.bwW().hPH.unn = new ho();
                f.bwW().hPH.unn.fTO = khVar.fQJ.appId;
                f.bwW().hPH.unn.tlI = khVar.fQJ.type;
                f.bwW().hPH.unn.tlJ = khVar.fQJ.version;
                f.bwW().hPH.unn.tlK = khVar.fQJ.fQL;
            }
            return false;
        }
    };
    private com.tencent.mm.plugin.webview.model.ab rZh;
    private ac rZi;
    private aa rZj;
    private i rZk;
    private com.tencent.mm.plugin.webview.model.d rZl;
    private com.tencent.mm.plugin.webview.model.ae rZm;
    private com.tencent.mm.plugin.webview.c.b rZn;
    private com.tencent.mm.plugin.webview.c.c rZo;
    private com.tencent.mm.plugin.webview.c.d rZp;
    private com.tencent.mm.plugin.webview.b.a rZq;
    private com.tencent.mm.plugin.webview.e.a rZr = new com.tencent.mm.plugin.webview.e.a();
    private final com.tencent.mm.plugin.webview.modelcache.n rZs = new com.tencent.mm.plugin.webview.modelcache.n();
    private com.tencent.mm.plugin.webview.e.b rZt;
    private com.tencent.mm.plugin.webview.wepkg.utils.c rZu = new com.tencent.mm.plugin.webview.wepkg.utils.c();
    com.tencent.mm.sdk.b.c rZv = new com.tencent.mm.sdk.b.c<sr>(this) {
        final /* synthetic */ f rZB;

        {
            this.rZB = r2;
            this.usg = sr.class.getName().hashCode();
        }

        private static boolean a(sr srVar) {
            if (!(srVar instanceof sr)) {
                return false;
            }
            String str;
            String xL = com.tencent.mm.u.m.xL();
            List arrayList = new ArrayList();
            arrayList.add(srVar.gaq.gar);
            arrayList.add(srVar.gaq.gas);
            arrayList.add(srVar.gaq.gat);
            arrayList.add(srVar.gaq.gau);
            arrayList.add(srVar.gaq.url);
            arrayList.add(srVar.gaq.gav);
            arrayList.add(srVar.gaq.gaw);
            arrayList.add(srVar.gaq.gax);
            arrayList.add(srVar.gaq.gay);
            arrayList.add(srVar.gaq.gaz);
            arrayList.add(xL);
            arrayList.add(srVar.gaq.gaA);
            arrayList.add(srVar.gaq.gaB);
            PString pString = new PString();
            String a = ((com.tencent.mm.plugin.sns.b.h) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.sns.b.h.class)).a(srVar.gaq.gaC, pString);
            arrayList.add(a);
            arrayList.add("");
            arrayList.add("");
            arrayList.add("");
            int G = p.G(srVar.gaq.gat, srVar.gaq.gau);
            int G2 = p.G(xL, srVar.gaq.gaw);
            arrayList.add(String.valueOf(G));
            arrayList.add(String.valueOf(G2));
            Object obj = srVar.gaq.gaD;
            try {
                obj = URLEncoder.encode(obj, "UTF-8");
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.SubCoreTools", e, "", new Object[0]);
            }
            arrayList.add(obj);
            arrayList.add(pString.value);
            String str2 = "MicroMsg.SubCoreTools";
            String str3 = "report(11954) : prePublishId : %s, curPublishId : %s, preUsername : %s, preChatName : %s, url : %s, preMsgIndex : %s, curChatName : %s, curChatTitle : %s, curChatMemberCount : %s, sendAppMsgScene : %s, curUserName : %s, getA8KeyScene : %s, referUrl : %s. : statExtStr:%s(%s), preChatType:%d, curChatType:%d, webViewTitle:%s, sourceAppId:%s";
            Object[] objArr = new Object[19];
            objArr[0] = srVar.gaq.gar;
            objArr[1] = srVar.gaq.gas;
            objArr[2] = srVar.gaq.gat;
            objArr[3] = srVar.gaq.gau;
            if (srVar.gaq.url == null) {
                str = srVar.gaq.url;
            } else {
                str = srVar.gaq.url.replace(",", "!");
            }
            objArr[4] = str;
            objArr[5] = Integer.valueOf(srVar.gaq.gav);
            objArr[6] = srVar.gaq.gaw;
            objArr[7] = srVar.gaq.gax;
            objArr[8] = Integer.valueOf(srVar.gaq.gay);
            objArr[9] = Integer.valueOf(srVar.gaq.gaz);
            objArr[10] = xL;
            objArr[11] = Integer.valueOf(srVar.gaq.gaA);
            if (srVar.gaq.gaB == null) {
                str = srVar.gaq.gaB;
            } else {
                str = srVar.gaq.gaB.replace(",", "!");
            }
            objArr[12] = str;
            objArr[13] = srVar.gaq.gaC;
            objArr[14] = a;
            objArr[15] = Integer.valueOf(G);
            objArr[16] = Integer.valueOf(G2);
            objArr[17] = srVar.gaq.gaD;
            objArr[18] = pString.value;
            w.d(str2, str3, objArr);
            g.oUh.d(11954, arrayList);
            return true;
        }
    };
    com.tencent.mm.sdk.b.c rZw = new com.tencent.mm.sdk.b.c<ib>(this) {
        final /* synthetic */ f rZB;

        {
            this.rZB = r2;
            this.usg = ib.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            ib ibVar = (ib) bVar;
            if (!(ibVar instanceof ib)) {
                return false;
            }
            com.tencent.mm.plugin.webview.ui.tools.jsapi.h.bzS().a(ibVar.fNE.fFR, ibVar.fNE.aMA, ibVar.fNE.fFS);
            return true;
        }
    };
    com.tencent.mm.sdk.b.c rZx = new com.tencent.mm.sdk.b.c<cg>(this) {
        final /* synthetic */ f rZB;

        {
            this.rZB = r2;
            this.usg = cg.class.getName().hashCode();
        }

        private static boolean a(cg cgVar) {
            if (cgVar instanceof cg) {
                Editor edit = ab.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                String value = com.tencent.mm.i.g.sV().getValue("WebviewDownloadTbs");
                String value2 = com.tencent.mm.i.g.sV().getValue("WebviewEnableTbs");
                String value3 = com.tencent.mm.i.g.sV().getValue("WebviewSupportedTbsVersionSection");
                w.i("MicroMsg.SubCoreTools", "updateWebViewDynamicConfig, tbsDownload = %s, tbsEnable = %s, tbsSupportedVerSec = %s", new Object[]{value, value2, value3});
                if (value != null) {
                    edit.putString("tbs_download", value);
                }
                edit.apply();
                if ("1".equals(value) && "1".equals(value2)) {
                    j.mN(1);
                }
                if (value != null) {
                    try {
                        if ("0".equals(value)) {
                            w.i("MicroMsg.SubCoreTools", "tbs download disable, reset tbssdk in sandbox");
                            Intent intent = new Intent();
                            intent.setComponent(new ComponentName(ab.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
                            ab.getContext().sendBroadcast(intent);
                        }
                    } catch (Exception e) {
                        w.w("MicroMsg.SubCoreTools", "sendbroadcast ,ex = %s", new Object[]{e.getMessage()});
                    }
                }
            }
            return false;
        }
    };
    com.tencent.mm.sdk.b.c rZy = new com.tencent.mm.sdk.b.c<com.tencent.mm.e.a.b>(this) {
        final /* synthetic */ f rZB;

        {
            this.rZB = r2;
            this.usg = com.tencent.mm.e.a.b.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            com.tencent.mm.e.a.b bVar2 = (com.tencent.mm.e.a.b) bVar;
            if (bVar2 instanceof com.tencent.mm.e.a.b) {
                Intent intent = new Intent();
                intent.putExtra("card_list", bVar2.fCf.fCg);
                intent.putExtra("result_code", bVar2.fCf.aMA);
                if (bVar2.fCf == null || bVar2.fCf.aMA != -1) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.bzS().a(16, 0, intent);
                } else {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.bzS().a(16, -1, intent);
                }
            }
            return false;
        }
    };
    com.tencent.mm.sdk.b.c rZz = new com.tencent.mm.sdk.b.c<bu>(this) {
        final /* synthetic */ f rZB;

        {
            this.rZB = r2;
            this.usg = bu.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            bu buVar = (bu) bVar;
            if (buVar instanceof bu) {
                Intent intent = new Intent();
                if (buVar.fFl == null || buVar.fFl.aMA != -1) {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.bzS().a(29, 0, intent);
                } else {
                    com.tencent.mm.plugin.webview.ui.tools.jsapi.h.bzS().a(29, -1, intent);
                }
            }
            return false;
        }
    };

    public static f bwS() {
        f fVar = (f) ap.yR().gs("plugin.webview");
        if (fVar != null) {
            return fVar;
        }
        Object fVar2 = new f();
        w.e("MicroMsg.SubCoreTools", "new SubCoreTools add to subCore:%d", new Object[]{Integer.valueOf(fVar2.hashCode())});
        ap.yR().a("plugin.webview", fVar2);
        return fVar2;
    }

    public static com.tencent.mm.plugin.webview.b.a bwT() {
        if (bwS().rZq == null) {
            bwS().rZq = new com.tencent.mm.plugin.webview.b.a();
        }
        return bwS().rZq;
    }

    public static com.tencent.mm.plugin.webview.c.c bwU() {
        if (bwS().rZo == null) {
            bwS().rZo = new com.tencent.mm.plugin.webview.c.c();
        }
        return bwS().rZo;
    }

    public static com.tencent.mm.plugin.webview.c.d bwV() {
        if (bwS().rZp == null) {
            bwS().rZp = new com.tencent.mm.plugin.webview.c.d();
        }
        return bwS().rZp;
    }

    public static com.tencent.mm.plugin.webview.c.b bwW() {
        if (bwS().rZn == null) {
            bwS().rZn = new com.tencent.mm.plugin.webview.c.b();
        }
        return bwS().rZn;
    }

    public static com.tencent.mm.plugin.webview.e.b bwX() {
        if (bwS().rZt == null) {
            bwS().rZt = new com.tencent.mm.plugin.webview.e.b();
        }
        return bwS().rZt;
    }

    public static com.tencent.mm.plugin.webview.model.ab bwY() {
        if (bwS().rZh == null) {
            bwS().rZh = new com.tencent.mm.plugin.webview.model.ab();
        }
        return bwS().rZh;
    }

    public static ac bwZ() {
        if (bwS().rZi == null) {
            bwS().rZi = ac.bwp();
        }
        return bwS().rZi;
    }

    public static i bxa() {
        if (bwS().rZk == null) {
            f bwS = bwS();
            ap.yY();
            bwS.rZk = new i(com.tencent.mm.u.c.wO());
        }
        return bwS().rZk;
    }

    public static com.tencent.mm.plugin.webview.model.d bxb() {
        if (bwS().rZl == null) {
            f bwS = bwS();
            ap.yY();
            bwS.rZl = new com.tencent.mm.plugin.webview.model.d(com.tencent.mm.u.c.wO());
        }
        return bwS().rZl;
    }

    public static com.tencent.mm.plugin.webview.model.ae bxc() {
        if (bwS().rZm == null) {
            f bwS = bwS();
            ap.yY();
            bwS.rZm = new com.tencent.mm.plugin.webview.model.ae(com.tencent.mm.u.c.wO());
        }
        return bwS().rZm;
    }

    public final void onAccountRelease() {
        w.i("MicroMsg.SubCoreTools", "onAccountRelease hc:%d", new Object[]{Integer.valueOf(hashCode())});
        a.urY.c(this.rZw);
        a.urY.c(this.rZx);
        a.urY.c(this.rZy);
        a.urY.c(this.rZz);
        a.urY.c(this.rZv);
        a.urY.c(this.rZr);
        a.urY.c(this.iyu);
        a.urY.c(this.rZA);
        ap.b(this.lTJ);
        if (this.rZj != null) {
            aa aaVar = this.rZj;
            if (aaVar.rWT != null) {
                e.akM();
                com.tencent.mm.plugin.downloader.model.b.b(aaVar.rWT);
            }
            if (aaVar.rWU != null && aaVar.rWU.size() > 0) {
                for (Long l : aaVar.rWU) {
                    w.i("MicroMsg.WebViewAutoDownloader", "remove download task : %d", new Object[]{l});
                    e.akM().aT(l.longValue());
                }
            }
        }
        if (this.rZp != null) {
            com.tencent.mm.plugin.webview.c.d dVar = this.rZp;
            a.urY.c(dVar.iOT);
            dVar.bwc();
            this.rZp = null;
        }
        if (this.rZn != null) {
            com.tencent.mm.plugin.webview.c.b bVar = this.rZn;
            a aVar = bVar.rVE;
            if (aVar.rVH != null) {
                ap.vd().c(aVar.rVH);
            }
            b bVar2 = bVar.rVF;
            if (bVar2.rVI != null) {
                ap.vd().b(bVar2.rVI.getType(), bVar2.rVG);
            }
            if (bVar.mah != null) {
                ((l) com.tencent.mm.kernel.h.j(l.class)).cancelSearchTask(bVar.mah);
                bVar.mah = null;
            }
            this.rZn = null;
        }
        if (this.rZo != null) {
            com.tencent.mm.sdk.e.j.a aVar2 = this.rZo;
            aVar2.pRm.dead();
            aVar2.rVP.dead();
            com.tencent.mm.x.n.Bm().f(aVar2);
            this.rZo = null;
        }
        ap.getSysCmdMsgExtension().b("hijackconfig", this.jOG, true);
        if (this.rZl != null) {
            this.rZl.bwe();
        }
        com.tencent.mm.plugin.webview.modelcache.n nVar = this.rZs;
        ap.getSysCmdMsgExtension().b("webcache", nVar.rYj, true);
        a.urY.c(nVar.rYk);
        a.urY.c(nVar.rYl);
        q qVar = a.rYG;
        a.urY.c(qVar.rYr);
        a.urY.c(qVar.rYs);
        qVar.er(true);
        com.tencent.mm.plugin.webview.wepkg.utils.c cVar = this.rZu;
        w.i("MicroMsg.Wepkg.WepkgListener", "wepkg stop listen");
        a.urY.c(cVar.srx);
        a.urY.c(cVar.sry);
        com.tencent.mm.plugin.webview.wepkg.b.a.aAA();
        com.tencent.mm.plugin.webview.wepkg.utils.d.XI();
    }

    static {
        HashMap hashMap = new HashMap();
        gJr = hashMap;
        hashMap.put(Integer.valueOf("WebViewHostsFilterTable".hashCode()), new c() {
            public final String[] pP() {
                return i.gUx;
            }
        });
        List<com.tencent.mm.plugin.webview.modelcache.d.a> linkedList = new LinkedList();
        linkedList.add(com.tencent.mm.plugin.webview.modelcache.a.bwI());
        linkedList.addAll(k.bwK());
        linkedList.add(com.tencent.mm.plugin.webview.modelcache.h.bwI());
        for (com.tencent.mm.plugin.webview.modelcache.d.a aVar : linkedList) {
            gJr.put(Integer.valueOf(aVar.id), aVar);
        }
        gJr.put(Integer.valueOf("WEBVIEW_JSLOG_BLOCK_LIST_TABLE".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.webview.model.d.gUx;
            }
        });
        gJr.put(Integer.valueOf("WEBVIEW_LOCAL_DATA".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.webview.model.ae.gUx;
            }
        });
        gJr.put(Integer.valueOf("CHECK_WEPKG_VERSION".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.webview.wepkg.a.d.gUx;
            }
        });
        gJr.put(Integer.valueOf("WEPKG_PRELOAD_FILES".hashCode()), new c() {
            public final String[] pP() {
                return com.tencent.mm.plugin.webview.wepkg.a.b.gUx;
            }
        });
    }

    public final HashMap<Integer, c> uh() {
        return gJr;
    }

    public final void eD(int i) {
    }

    public final void aM(boolean z) {
        w.i("MicroMsg.SubCoreTools", "onAccountPostReset hc:%d", new Object[]{Integer.valueOf(hashCode())});
        if (((f) ap.yR().gs("plugin.webview")) == null) {
            ap.yR().a("plugin.webview", new f());
            w.e("MicroMsg.SubCoreTools", "getCore, should not be here:%d", new Object[]{Integer.valueOf(r0.hashCode())});
        }
        a.urY.b(this.rZw);
        a.urY.b(this.rZx);
        a.urY.b(this.rZy);
        a.urY.b(this.rZz);
        a.urY.b(this.rZv);
        a.urY.b(this.rZr);
        a.urY.b(this.iyu);
        a.urY.b(this.rZA);
        ap.getSysCmdMsgExtension().a("hijackconfig", this.jOG, true);
        ap.a(this.lTJ);
        com.tencent.mm.plugin.webview.modelcache.n nVar = this.rZs;
        com.tencent.mm.plugin.webview.modelcache.n.bwM();
        q qVar = a.rYG;
        a.urY.b(qVar.rYr);
        a.urY.b(qVar.rYs);
        ap.getSysCmdMsgExtension().a("webcache", nVar.rYj, true);
        a.urY.b(nVar.rYk);
        a.urY.b(nVar.rYl);
        com.tencent.mm.plugin.webview.wepkg.utils.c cVar = this.rZu;
        w.i("MicroMsg.Wepkg.WepkgListener", "wepkg start listen");
        a.urY.b(cVar.srx);
        a.urY.b(cVar.sry);
        com.tencent.mm.plugin.webview.wepkg.b.a.aAz();
        Context context = ab.getContext();
        if (context != null) {
            try {
                SharedPreferences sharedPreferences = context.getSharedPreferences("we_pkg_sp", 4);
                if (sharedPreferences == null) {
                    w.e("MicroMsg.Wepkg.WepkgListener", "sp is null");
                    return;
                }
                if (sharedPreferences.getBoolean("disable_we_pkg", false)) {
                    w.i("MicroMsg.Wepkg.WepkgListener", "enable wepkg");
                    sharedPreferences.edit().putBoolean("disable_we_pkg", false).commit();
                }
                sharedPreferences.edit().putInt("white_screen_times", 0).commit();
            } catch (Exception e) {
                w.e("MicroMsg.Wepkg.WepkgListener", e.getMessage());
            }
        }
    }

    public final void aN(boolean z) {
        com.tencent.mm.plugin.webview.modelcache.n.bwM();
    }
}
